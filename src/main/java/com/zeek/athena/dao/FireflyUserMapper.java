package com.zeek.athena.dao;

import com.zeek.athena.domain.FireflyUser;

public interface FireflyUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table firefly_user
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    int deleteByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table firefly_user
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    int insert(FireflyUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table firefly_user
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    int insertSelective(FireflyUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table firefly_user
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    FireflyUser selectByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table firefly_user
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    int updateByPrimaryKeySelective(FireflyUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table firefly_user
     *
     * @mbggenerated Sat May 27 14:39:11 CST 2017
     */
    int updateByPrimaryKey(FireflyUser record);
}