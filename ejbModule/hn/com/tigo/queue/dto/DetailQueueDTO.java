/**
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.queue.dto;

/**
 * The Class DetailQueueDTO.
 *
 * @author Leonardo Vijil
 * @version 1.0.0
 */
public class DetailQueueDTO {
    
    /** Attribute that determine queue end point or address. */
    private String queueipaddress;
    
    /** Attribute that determine queue authentication user. */
    private String queueuser;
    
    /** Attribute that determine queue password. */
    private String queuepassword;
    
    /** Attribute that determine queue library name. */
    private String queuelibname;
    
    /** Attribute that determine queue name. */
    private String queuename;
    
	/** Attribute that determine queue split character. */
	private String queuesplit;

        
    /**
     * Gets the queue ip address or endpoint of the queue.
     *
     * @return the queue ip address
     */
    public String getQueueIPAddress() {
        return queueipaddress;
    }

    /**
     * Sets the queue ip address.
     *
     * @param queueipaddress the new queue ip address
     */
    public void setQueueIPAddress(final String queueipaddress) {
        this.queueipaddress = queueipaddress;
    }

    /**
     * Gets the queue user.
     *
     * @return the queue user
     */
    public String getQueueUser() {
        return queueuser;
    }

    /**
     * Sets the queue user.
     *
     * @param queueuser the new queue user
     */
    public void setQueueUser(final String queueuser) {
        this.queueuser = queueuser;
    }

    /**
     * Gets the queue password.
     *
     * @return the queue password
     */
    public String getQueuePassword() {
        return queuepassword;
    }

    /**
     * Sets the queue password.
     *
     * @param queuepassword the new queue password
     */
    public void setQueuePassword(final String queuepassword) {
        this.queuepassword = queuepassword;
    }

    /**
     * Gets the queue library name.
     *
     * @return the queue library name
     */
    public String getQueueLibName() {
        return queuelibname;
    }

    /**
     * Sets the queue library name.
     *
     * @param queuelibname the new queue library name
     */
    public void setQueuelibName(final String queuelibname) {
        this.queuelibname = queuelibname;
    }

    /**
     * Gets the queue name.
     *
     * @return the queue name
     */
    public String getQueueName() {
        return queuename;
    }

    /**
     * Sets the queue name.
     *
     * @param queuename the new queue name
     */
    public void setQueueName(final String queuename) {
        this.queuename = queuename;
    }
    
	/**
     * Gets the queue split character of the queue definition.
     *
     * @return the queue split
     */
    public String getQueueSplit() {
        return queuesplit;
    }

    /**
     * Sets the queue split character.
     *
     * @param queuesplit the new queue split
     */
    public void setQueueSplit(final String queuesplit) {
        this.queuesplit = queuesplit;
    }
    
}
