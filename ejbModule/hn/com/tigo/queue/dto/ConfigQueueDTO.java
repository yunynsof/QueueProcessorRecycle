/**
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.queue.dto;

import java.util.List;

/**
 * This class contains the necessary attributes for the ConfigQueueDTO object.
 *
 * @author Leonardo Vijil
 * @version 1.0.0
 */
public class ConfigQueueDTO {
    
    /** The config queue. */
    private List<DetailQueueDTO> configQueue;

	/**
	 * Gets the config queue.
	 *
	 * @return the configQueue
	 */
	public final List<DetailQueueDTO> getConfigQueue() {
		return configQueue;
	}

	/**
	 * Sets the config queue.
	 *
	 * @param configQueue the configQueue to set
	 */
	public final void setConfigQueue(List<DetailQueueDTO> configQueue) {
		this.configQueue = configQueue;
	}
    
}
