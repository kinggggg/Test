package com.wusong.firefly.domain.firefly;

import java.util.Date;

public class AdviceApplyLike {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column advice_apply_like.id
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column advice_apply_like.order_id
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column advice_apply_like.advice_apply_id
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    private String adviceApplyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column advice_apply_like.user_id
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column advice_apply_like.create_date
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    private Date createDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column advice_apply_like.id
     *
     * @return the value of advice_apply_like.id
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column advice_apply_like.id
     *
     * @param id the value for advice_apply_like.id
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column advice_apply_like.order_id
     *
     * @return the value of advice_apply_like.order_id
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column advice_apply_like.order_id
     *
     * @param orderId the value for advice_apply_like.order_id
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column advice_apply_like.advice_apply_id
     *
     * @return the value of advice_apply_like.advice_apply_id
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    public String getAdviceApplyId() {
        return adviceApplyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column advice_apply_like.advice_apply_id
     *
     * @param adviceApplyId the value for advice_apply_like.advice_apply_id
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    public void setAdviceApplyId(String adviceApplyId) {
        this.adviceApplyId = adviceApplyId == null ? null : adviceApplyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column advice_apply_like.user_id
     *
     * @return the value of advice_apply_like.user_id
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column advice_apply_like.user_id
     *
     * @param userId the value for advice_apply_like.user_id
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column advice_apply_like.create_date
     *
     * @return the value of advice_apply_like.create_date
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column advice_apply_like.create_date
     *
     * @param createDate the value for advice_apply_like.create_date
     *
     * @mbggenerated Thu Nov 09 10:18:40 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}