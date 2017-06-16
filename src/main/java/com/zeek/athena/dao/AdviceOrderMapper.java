package com.zeek.athena.dao;

import com.zeek.athena.domain.AdviceOrder;

public interface AdviceOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advice_order
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advice_order
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    int insert(AdviceOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advice_order
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    int insertSelective(AdviceOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advice_order
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    AdviceOrder selectByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advice_order
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    int updateByPrimaryKeySelective(AdviceOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advice_order
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    int updateByPrimaryKey(AdviceOrder record);
}