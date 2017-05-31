package com.zeek.athena.domain;

import java.util.Date;

public class BaseOrder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.order_id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.order_type
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    private Integer orderType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.order_status
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    private Integer orderStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.order_title
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    private String orderTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.creator_id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    private String creatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.taker_id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    private String takerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.city_id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    private Integer cityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.contact_name
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    private String contactName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.create_date
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.update_date
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.id
     *
     * @return the value of base_order.id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.id
     *
     * @param id the value for base_order.id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.order_id
     *
     * @return the value of base_order.order_id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.order_id
     *
     * @param orderId the value for base_order.order_id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.order_type
     *
     * @return the value of base_order.order_type
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.order_type
     *
     * @param orderType the value for base_order.order_type
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.order_status
     *
     * @return the value of base_order.order_status
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.order_status
     *
     * @param orderStatus the value for base_order.order_status
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.order_title
     *
     * @return the value of base_order.order_title
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public String getOrderTitle() {
        return orderTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.order_title
     *
     * @param orderTitle the value for base_order.order_title
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle == null ? null : orderTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.creator_id
     *
     * @return the value of base_order.creator_id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.creator_id
     *
     * @param creatorId the value for base_order.creator_id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.taker_id
     *
     * @return the value of base_order.taker_id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public String getTakerId() {
        return takerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.taker_id
     *
     * @param takerId the value for base_order.taker_id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public void setTakerId(String takerId) {
        this.takerId = takerId == null ? null : takerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.city_id
     *
     * @return the value of base_order.city_id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.city_id
     *
     * @param cityId the value for base_order.city_id
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.contact_name
     *
     * @return the value of base_order.contact_name
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.contact_name
     *
     * @param contactName the value for base_order.contact_name
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.create_date
     *
     * @return the value of base_order.create_date
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.create_date
     *
     * @param createDate the value for base_order.create_date
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.update_date
     *
     * @return the value of base_order.update_date
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.update_date
     *
     * @param updateDate the value for base_order.update_date
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}