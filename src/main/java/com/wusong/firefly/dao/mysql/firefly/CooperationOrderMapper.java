package com.wusong.firefly.dao.mysql.firefly;

import com.wusong.firefly.domain.firefly.CooperationOrder;

public interface CooperationOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cooperation_order
     *
     * @mbggenerated Mon Jun 19 18:48:23 CST 2017
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cooperation_order
     *
     * @mbggenerated Mon Jun 19 18:48:23 CST 2017
     */
    int insert(CooperationOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cooperation_order
     *
     * @mbggenerated Mon Jun 19 18:48:23 CST 2017
     */
    int insertSelective(CooperationOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cooperation_order
     *
     * @mbggenerated Mon Jun 19 18:48:23 CST 2017
     */
    CooperationOrder selectByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cooperation_order
     *
     * @mbggenerated Mon Jun 19 18:48:23 CST 2017
     */
    int updateByPrimaryKeySelective(CooperationOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cooperation_order
     *
     * @mbggenerated Mon Jun 19 18:48:23 CST 2017
     */
    int updateByPrimaryKey(CooperationOrder record);
}