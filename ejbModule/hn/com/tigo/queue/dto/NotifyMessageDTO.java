package hn.com.tigo.queue.dto;

import java.util.List;


/**
 * NotifyMessageDTO.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-25-2022 12:06:25 PM 2022
 */
public class NotifyMessageDTO {

	  /**
     * Attribute that determine eventType.
     */
    private String eventType;

    /**
     * Attribute that determine source.
     */
    private String channelId;

    /**
     * Attribute that determine orderType.
     */
    private String orderType;

    /**
     * Attribute that determine productId.
     */
    private int productId;

    /**
     * Attribute that determine subscriberId.
     */
    private String subscriberId;

    /**
     * Attribute that determine date.
     */
    private String date;

    /**
     * Attribute that determine transactionId.
     */
    private String transactionId;

    /**
     * Attribute that determine additionalsParams.
     */
    private List<AttributeValuePair> additionalsParams;

    /**
     * Method responsible to gets the event type.
     *
     * @return the event type
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Method responsible to sets the event type.
     *
     * @param eventType the new event type
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * Method responsible to gets the channel Id.
     *
     * @return the channelId
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * Method responsible to sets the channel Id.
     *
     * @param channelId the new source
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * Method responsible to gets the order type.
     *
     * @return the order type
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Method responsible to sets the order type.
     *
     * @param orderType the new order type
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * Method responsible to gets the product id.
     *
     * @return the product id
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Method responsible to sets the product id.
     *
     * @param productId the new product id
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Method responsible to gets the subscriber id.
     *
     * @return the subscriber id
     */
    public String getSubscriberId() {
        return subscriberId;
    }

    /**
     * Method responsible to sets the subscriber id.
     *
     * @param subscriberId the new subscriber id
     */
    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Method responsible to gets the transaction id.
     *
     * @return the transaction id
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Method responsible to sets the transaction id.
     *
     * @param transactionId the new transaction id
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Gets the additionals params.
     *
     * @return the additionals params
     */
    public List<AttributeValuePair> getAdditionalsParams() {
        return additionalsParams;
    }

    /**
     * Sets the additionals params.
     *
     * @param additionalsParams the new additionals params
     */
    public void setAdditionalsParams(List<AttributeValuePair> additionalsParams) {
        this.additionalsParams = additionalsParams;
    }

}
