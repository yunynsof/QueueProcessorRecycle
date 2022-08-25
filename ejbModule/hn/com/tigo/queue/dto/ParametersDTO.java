package hn.com.tigo.queue.dto;

import java.util.Date;

/**
 * ParametersModel.
 *
 * @author Leonardo Vijil
 * @version 1.0.0
 * @since 11-20-2019 10:16:06 AM 2019
 */
public class ParametersDTO extends DTO {

	/** Attribute that determine id. */
	private long idApplication;
	/** Attribute that determine name. */
	private String name;

	/** Attribute that determine value. */
	private String value;

	/** Attribute that determine description. */
	private String description;

	/** Attribute that determine createdDate. */
	private Date createdDate;

	/**
	 * Instantiates a new parameters model.
	 */
	public ParametersDTO() {
	}

	/**
	 * Gets the id application.
	 *
	 * @return the idApplication
	 */
	public final long getIdApplication() {
		return idApplication;
	}

	/**
	 * Sets the id application.
	 *
	 * @param idApplication the idApplication to set
	 */
	public final void setIdApplication(long idApplication) {
		this.idApplication = idApplication;
	}

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
	 * Gets the value.
	 *
	 * @return the value
	 */
	public final String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the value to set
	 */
	public final void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public final void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the createdDate
	 */
	public final Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the createdDate to set
	 */
	public final void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
