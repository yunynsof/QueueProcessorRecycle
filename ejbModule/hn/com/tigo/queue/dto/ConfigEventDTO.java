package hn.com.tigo.queue.dto;

import java.util.List;

/**
 * The Class ConfigEventDTO.
 *
 * @author Leonardo Vijil
 * @version 1.0.0
 */
public class ConfigEventDTO {
	
	/** The retries. */
	private int retries;
	
	/** The events. */
	private List<DetailEventDTO> events;
	
	/**
	 * Gets the retries.
	 *
	 * @return the retries
	 */
	public final int getRetries() {
		return retries;
	}
	
	/**
	 * Sets the retries.
	 *
	 * @param retries the retries to set
	 */
	public final void setRetries(int retries) {
		this.retries = retries;
	}
	
	/**
	 * Gets the events.
	 *
	 * @return the events
	 */
	public final List<DetailEventDTO> getEvents() {
		return events;
	}
	
	/**
	 * Sets the events.
	 *
	 * @param events the events to set
	 */
	public final void setEvents(List<DetailEventDTO> events) {
		this.events = events;
	}
	
}
