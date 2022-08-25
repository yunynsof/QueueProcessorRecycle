/**
 * ProcessQueueRecycleMasterThread.java
 * ProcessQueueRecycleMasterThread
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.queue.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import hn.com.tigo.josm.persistence.core.ServiceSessionEJB;
import hn.com.tigo.josm.persistence.core.ServiceSessionEJBLocal;
import hn.com.tigo.josm.persistence.exception.PersistenceException;
import hn.com.tigo.queue.as400.AbstractDriverQueueRecycle;
import hn.com.tigo.queue.dto.AttributeValuePair;
import hn.com.tigo.queue.dto.ConfigEventDTO;
import hn.com.tigo.queue.dto.DetailEventDTO;
import hn.com.tigo.queue.dto.DetailQueueDTO;
import hn.com.tigo.queue.dto.NotifyMessageDTO;
import hn.com.tigo.queue.listener.entity.OcepManager;
import hn.com.tigo.queue.utils.QueueConstantListener;
import hn.com.tigo.queue.utils.ReadFilesConfig;
import hn.com.tigo.queue.utils.States;

/**
 * ProcessQueueRecycleMasterThread.
 * 
 * Class that allows you to start the process of Read Queue AS400.
 *
 * @author Leonardo Vijil
 * @version 1.0.0
 * @since 11/02/2020 11:10:03 AM 2020
 */
public class ProcessQueueRecycleMasterThread extends Thread {

	/**
	 * This attribute will store an instance of log4j for
	 * ProcessQueueRecycleMasterThread class.
	 */
	private static final Logger LOGGER = LogManager.getLogger(ProcessQueueRecycleMasterThread.class);

	/**
	 * The executor service, allows the execution of a thread pool.
	 */
	private ThreadPoolExecutor executorService;

	/** The state. */
	private States state;
	
	/** The config. */
	private final DetailQueueDTO config;

	/** The params. */
	private Map<String, String> params;

	/**
	 * Instantiates a new process queue recycle master thread.
	 *
	 * @param config the config
	 */
	public ProcessQueueRecycleMasterThread(final DetailQueueDTO config) {

		this.config = config;
		try {
			initialize();
		} catch (Exception e) {
			state = States.SHUTTINGDOWN;
			LOGGER.error(QueueConstantListener.UNABLE_INITIALIZE + e.getMessage(), e);
		}
	}

	/**
	 * Method that allow to initialize the executor thread.
	 */
	public void initialize() {
		BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<Runnable>(1);
		LOGGER.info("workingQueue correctly");
		executorService = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MILLISECONDS, workingQueue);
		// Starting master thread
		state = States.STARTED;
		LOGGER.info("Iinitialize Finalized.");
	}

	/**
	 * Shutdown.
	 */
	public void shutdown() {
		state = States.SHUTTINGDOWN;
		executorService.shutdownNow();
	}

	/**
	 * Run.
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		getConnection();
		AbstractDriverQueueRecycle connqueue = null;
		while (state == States.STARTED) {
			ReadFilesConfig readConfig = null;
			long startTime = 0;
			try {
				readConfig = new ReadFilesConfig();
				if (connqueue == null) {
					connqueue = new AbstractDriverQueueRecycle(config);
				}

				String tramaComplete = connqueue.readQueue();

				startTime = processTrama(readConfig, startTime, tramaComplete);
			} catch (Exception error) {
				LOGGER.error(QueueConstantListener.NAME_LISTENER + this.getClass().getName()
						+ QueueConstantListener.MESSAGE_ERROR_PROCESS, error);
				NewRelicImpl.addNewRelicError(error);
			} finally {
				long endTime = System.nanoTime(); // Se guarda el tiempo final del proceso.
				long duration = (endTime - startTime); // Se calcula el tiempo que tomo procesar los datos.
				long timeDuration = duration / 1000000;
				NewRelicImpl.addNewRelicMetric("QueueProcessorRecycleAgent", timeDuration); // Se manda la
																									// informacion de la
																									// duracion del
																									// proceso a
																									// NewRelic como
																									// metrica.
				startTime = 0;
				if (connqueue != null) {
					if (state != States.STARTED) {
						connqueue.disconnectService();
						connqueue = null;
					}
				}
			}
			state = States.SHUTTINGDOWN; //linea habilitarla solo para junit test
		}
		executorService.shutdown();
	}

	
	/**
	 * Process trama.
	 *
	 * @param readConfig the read config
	 * @param startTime the start time
	 * @param tramaComplete the trama complete
	 * @return the long
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public long processTrama(ReadFilesConfig readConfig, long startTime, String tramaComplete) throws IOException  {
		if (tramaComplete != null) {
			startTime = System.nanoTime();
			String[] trama = tramaComplete.split("\\|");

			final ConfigEventDTO configEvent = readConfig.readConfigEvent();
			DetailEventDTO detailEvent = readConfig.getDetailEvent(configEvent, trama[0]);

			if (detailEvent != null) {
				LOGGER.info("Trama: " + tramaComplete + " Evento: " + detailEvent.getName() + " ProductId: "
						+ detailEvent.getDefaultProduct());
				String request = obtainRequest(trama, detailEvent);

				if (request != null) {
					methodPost(request);
				}

			} else {
				LOGGER.info("Trama no aceptada, por no tener evento valido: " + tramaComplete);
			}
		}
		return startTime;
	}
	
	/**
	 * Obtain request.
	 *
	 * @param trama the trama
	 * @param detailEvent the detail event
	 * @return the string
	 */
	private String obtainRequest(String[] trama, DetailEventDTO detailEvent) {
		String request = null;

		NotifyMessageDTO notifyMessageDTO = new NotifyMessageDTO();
		String evenType = trama[0];
		String uuid = UUID.randomUUID().toString();
		Calendar cycleCalendar = Calendar.getInstance();
		final SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

		switch (evenType) {
		case "RECICLAJE":
			String[] subscriber = trama[2].split(params.get("SUBSCRIBER_SPLIT"));
			NotifyMessageDTO object = generatedRequest(trama, detailEvent, notifyMessageDTO, evenType, uuid,
					(subscriber.length > 1 ? subscriber[1] : ""), df.format(cycleCalendar.getTime()));
			Gson gson = new Gson();
			return gson.toJson(object);
			
		default:
			return request;
		}
	}

	/**
	 * Generated request.
	 *
	 * @param trama the trama
	 * @param detailEvent the detail event
	 * @param notifyMessageDTO the notify message DTO
	 * @param evenType the even type
	 * @param uuid the uuid
	 * @param subscriber the subscriber
	 * @param fecha the fecha
	 * @return the notify message DTO
	 */
	private NotifyMessageDTO generatedRequest(String[] trama, DetailEventDTO detailEvent,
			NotifyMessageDTO notifyMessageDTO, String evenType, String uuid, String subscriber, String fecha) {
		notifyMessageDTO.setEventType(evenType);
		notifyMessageDTO.setChannelId(String.valueOf(detailEvent.getChannelId()));
		notifyMessageDTO.setOrderType(detailEvent.getDefaultOrder());
		notifyMessageDTO.setProductId(Integer.valueOf(detailEvent.getDefaultProduct()));
		notifyMessageDTO.setSubscriberId(subscriber);
		notifyMessageDTO.setDate(fecha);
		notifyMessageDTO.setTransactionId(uuid);
		notifyMessageDTO.setAdditionalsParams(getAdditionalParams(trama));
		return notifyMessageDTO;
	}

	/**
	 * Gets the additional params.
	 *
	 * @param trama the trama
	 * @return the additional params
	 */
	private List<AttributeValuePair> getAdditionalParams(String[] trama) {

		List<AttributeValuePair> list = new ArrayList<AttributeValuePair>();

		for (int i = 0; i < trama.length; i++) {
			AttributeValuePair attributeValuePair = new AttributeValuePair();
			if (i == 0) {

				attributeValuePair.setAttribute("EVENT");
				attributeValuePair.setValue(trama[0]);
				list.add(attributeValuePair);
			} else if (i == 1) {

				attributeValuePair.setAttribute("SUBEVENT");
				attributeValuePair.setValue(trama[1]);
				list.add(attributeValuePair);
			} else {

				String tramaF = trama[i];
				if ((i + 1) == trama.length) {
					tramaF = tramaF.replaceAll(" ", "");
					tramaF = tramaF.replaceAll("\u0000", "");
					tramaF = tramaF.replaceAll("\u000f", "");
				}
				String[] attribute = tramaF.split(params.get("SUBSCRIBER_SPLIT"));
				if (!attribute[0].equals("")) {
					attributeValuePair.setAttribute(attribute[0]);
					attributeValuePair.setValue(attribute.length > 1 ? attribute[1] : "");
					list.add(attributeValuePair);
				}
			}
		}
		return list;
	}

	/**
	 * Method post.
	 *
	 * @param request the request
	 * @return the string
	 */
	private String methodPost(String request) {
		StringBuilder content = null;
		try {

			String urlFinal = params.get("URL_NOTIFY_EVENT");
			LOGGER.info(urlFinal);

			URL url = new URL(urlFinal);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			con.setRequestProperty("Content-Type", "application/json");

			byte[] outputInBytes = request.getBytes("UTF-8");
			OutputStream os = con.getOutputStream();
			os.write(outputInBytes);
			os.flush();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			content = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			con.disconnect();
			LOGGER.info(content.toString());
		} catch (Exception e) {
			LOGGER.error("ERROR: en api Notifyevent: " + e.getMessage());
			return "";
		}
		return content.toString();
	}
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	@SuppressWarnings("unchecked")
	private void getConnection() {
		OcepManager manager = null;
		try {
			ServiceSessionEJBLocal<OcepManager> serviceSession = ServiceSessionEJB.getInstance();
			manager = serviceSession.getSessionDataSource(OcepManager.class,
					QueueConstantListener.DATASOURCE_CPE);
			params = manager.listAllParam();
		} catch (PersistenceException e) {
			LOGGER.error(QueueConstantListener.ERROR_CONNECTION + e.getMessage(), e);
		} finally {
			if (manager != null) {
				try {
					manager.close();
				} catch (PersistenceException e) {
					LOGGER.error(QueueConstantListener.COULD_NOT_CLOSE);
				}
			}
		}
	}

	
	/**
	 * Sets the params.
	 *
	 * @param params the params
	 */
	public void setParams(Map<String, String> params) {
		this.params = params;
	}

}
