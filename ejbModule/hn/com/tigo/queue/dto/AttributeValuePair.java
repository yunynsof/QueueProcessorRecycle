package hn.com.tigo.queue.dto;

/**
 * AttributeValuePair This class contains the necessary attributes for the attribute Value Pair object, 
 * a class that makes up the NotifyMessageDTO model class.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-25-2022 12:04:50 PM 2022
 */
public class AttributeValuePair {

	/** The attribute. */
	private String attribute;
	
	/** The value. */
	private String value;

	/**
	 * Gets the attribute.
	 *
	 * @return the attribute
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * Sets the attribute.
	 *
	 * @param attribute the new attribute
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
