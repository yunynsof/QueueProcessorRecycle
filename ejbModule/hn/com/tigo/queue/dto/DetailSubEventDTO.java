package hn.com.tigo.queue.dto;

/**
 * DetailSubEventDTO.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-25-2022 12:06:13 PM 2022
 */
public class DetailSubEventDTO {
	
	/** The name. */
	private String name;
	
	/** The product. */
	private String product;
	
	/** The order. */
	private String order;
	
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
	 * Gets the product.
	 *
	 * @return the product
	 */
	public final String getProduct() {
		return product;
	}
	
	/**
	 * Sets the product.
	 *
	 * @param product the product to set
	 */
	public final void setProduct(String product) {
		this.product = product;
	}
	
	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public final String getOrder() {
		return order;
	}
	
	/**
	 * Sets the order.
	 *
	 * @param order the order to set
	 */
	public final void setOrder(String order) {
		this.order = order;
	}
}
