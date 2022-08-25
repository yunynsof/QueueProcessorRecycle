package hn.com.tigo.queue.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import hn.com.tigo.queue.dto.ConfigEventDTO;
import hn.com.tigo.queue.dto.ConfigQueueDTO;
import hn.com.tigo.queue.dto.DetailEventDTO;

/**
 * ReadFilesConfig.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-25-2022 12:08:19 PM 2022
 */
public class ReadFilesConfig {
	/** Attribute that determine a Constant of PATH_CONFIG_EVENT. */
	private static final String PATH_CONFIG_EVENT = "./properties/configEvents/configEventOCEPRecycle.json";
	
	/** Attribute that determine a Constant of PATH_CONFIG_QUEUE. */
	private static final String PATH_CONFIG_QUEUE = "./properties/configEvents/configQueueRecycle.json";
	
	/** The json. */
	private final Gson json = new Gson();
	
	/**
	 * Instantiates a new read files config.
	 */
	public ReadFilesConfig() {
	}
	
	/**
	 * Read config event.
	 *
	 * @return the config event DTO
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public ConfigEventDTO readConfigEvent() throws IOException {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			File file = new File(PATH_CONFIG_EVENT);
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			ConfigEventDTO obj = json.fromJson(bufferedReader, ConfigEventDTO.class);
			return obj;
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
	}
	
	/**
	 * Gets the detail event.
	 *
	 * @param obj the obj
	 * @param eventType the event type
	 * @return the detail event
	 */
	public DetailEventDTO getDetailEvent(final ConfigEventDTO obj, final String eventType) {
		for (DetailEventDTO objDetail : obj.getEvents()) {
			if(eventType.equalsIgnoreCase(objDetail.getName())) {
				return objDetail;
			}
		}
		return null;
	}
	
	/**
	 * Read config queue.
	 *
	 * @return the config queue DTO
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public ConfigQueueDTO readConfigQueue() throws IOException {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			File file = new File(PATH_CONFIG_QUEUE);
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			ConfigQueueDTO obj = json.fromJson(bufferedReader, ConfigQueueDTO.class);
			return obj;
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
	}
}
