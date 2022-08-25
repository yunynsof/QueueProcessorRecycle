/**
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.queue.as400;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.DataQueue;
import com.ibm.as400.access.DataQueueEntry;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.IllegalObjectTypeException;
import com.ibm.as400.access.ObjectDoesNotExistException;

import hn.com.tigo.queue.dto.DetailQueueDTO;

/**
 * The Class AbstractDriverIndexedQueue expose the execute method that concrete
 * classes whose can inherited and use it for reading and writing queues.
 *
 * @author Leonardo Vijil
 * @version 1.0.0
 */
public class AbstractDriverQueueRecycle {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(AbstractDriverQueueRecycle.class);

	/** The Constant PATH of the queue. */
	private static final String PATH = "/QSYS.LIB/%1s.LIB/%2s.DTAQ";

	/** Attribute that determine config. */
	protected final DetailQueueDTO config;


	/** The as 400. */
	private AS400 as400;

	/**
	 * Instantiates a new abstract driver queue recycle.
	 *
	 * @param config the config
	 * @throws AS400SecurityException the AS 400 security exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public AbstractDriverQueueRecycle(final DetailQueueDTO config) throws AS400SecurityException, IOException {
		super();
		this.config = config;
		this.as400 = new AS400(config.getQueueIPAddress(), config.getQueueUser(), config.getQueuePassword());
		// this.as400.connectToPort(446);
	}


	/**
	 * Open queue.
	 *
	 * @return the data queue
	 * @throws Exception the exception
	 */
	public DataQueue openQueue() throws Exception {
		try {
			as400.connectService(AS400.DATAQUEUE);
		} catch (AS400SecurityException | IOException e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e.getMessage());
		}
		return new DataQueue(as400, String.format(PATH, config.getQueueLibName(), config.getQueueName()));
	}


	/**
	 * Read queue.
	 *
	 * @return the string
	 * @throws Exception the exception
	 */
	public String readQueue() throws Exception {
		String result = null;
		final DataQueue queue = openQueue();
		try {
			final DataQueueEntry entity = queue.read();
			if (entity != null) {
				result = entity.getString();
			}
		} catch (AS400SecurityException | ErrorCompletingRequestException | IOException | IllegalObjectTypeException
				| InterruptedException | ObjectDoesNotExistException e) {
			throw new Exception(e.getMessage());
		}
		return result;
	}

	/**
	 * Write queue.
	 *
	 * @param data the data
	 * @throws Exception the exception
	 */
	public void writeQueue(final String data) throws Exception {
		final DataQueue queue = openQueue();
		try {
			queue.write(data);
		} catch (AS400SecurityException | ErrorCompletingRequestException | IOException | IllegalObjectTypeException
				| InterruptedException | ObjectDoesNotExistException e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Disconnect service.
	 */
	public void disconnectService() {
		as400.disconnectService(AS400.DATAQUEUE);
	}

}
