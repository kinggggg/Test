package com.zeek.athena.dao;

import com.zeek.athena.domain.BaseOrder;

public interface BaseOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_order
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_order
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    int insert(BaseOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_order
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    int insertSelective(BaseOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_order
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    BaseOrder selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_order
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    int updateByPrimaryKeySelective(BaseOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_order
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    int updateByPrimaryKey(BaseOrder record);
}