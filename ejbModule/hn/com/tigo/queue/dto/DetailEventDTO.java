package hn.com.tigo.queue.dto;

import java.util.List;

/**
 * DetailEventDTO.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-25-2022 12:06:03 PM 2022
 */
public class DetailEventDTO {
	
	/** The name. */
	private String name;
	
	/** The default product. */
	private String defaultProduct;
	
	/** The comment. */
	private String comment;
	
	/** The channel id. */
	private int channelId;
	
	/** The default order. */
	private String defaultOrder;
	
	/** The endpoint. */
	private String endpoint;
	
	/** The subevents. */
	private List<DetailSubEventDTO> subevents;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the default product.
	 *
	 * @return the defaultProduct
	 */
	public final String getDefaultProduct() {
		return defaultProduct;
	}
	
	/**
	 * Sets the default product.
	 *
	 * @param defaultProduct the defaultProduct to set
	 */
	public final void setDefaultProduct(String defaultProduct) {
		this.defaultProduct = defaultProduct;
	}
	
	/**
	 * Gets the default order.
	 *
	 * @return the defaultOrder
	 */
	public final String getDefaultOrder() {
		return defaultOrder;
	}
	
	/**
	 * Sets the default order.
	 *
	 * @param defaultOrder the defaultOrder to set
	 */
	public final void setDefaultOrder(String defaultOrder) {
		this.defaultOrder = defaultOrder;
	}
	
	/**
	 * Gets the endpoint.
	 *
	 * @return the endpoint
	 */
	public final String getEndpoint() {
		return endpoint;
	}
	
	/**
	 * Sets the endpoint.
	 *
	 * @param endpoint the endpoint to set
	 */
	public final void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
	/**
	 * Gets the subevents.
	 *
	 * @return the subevents
	 */
	public final List<DetailSubEventDTO> getSubevents() {
		return subevents;
	}
	
	/**
	 * Sets the subevents.
	 *
	 * @param subevents the subevents to set
	 */
	public final void setSubevents(List<DetailSubEventDTO> subevents) {
		this.subevents = subevents;
	}
	
	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public final String getComment() {
		return comment;
	}
	
	/**
	 * Sets the comment.
	 *
	 * @param comment the comment to set
	 */
	public final void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
	 * Gets the channel id.
	 *
	 * @return the channelId
	 */
	public final int getChannelId() {
		return channelId;
	}
	
	/**
	 * Sets the channel id.
	 *
	 * @param channelId the channelId to set
	 */
	public final void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	
}
