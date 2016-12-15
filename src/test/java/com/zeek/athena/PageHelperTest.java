package com.zeek.athena;

import com.github.pagehelper.PageHelper;
import com.zeek.athena.dao.UserMapper;
import com.zeek.athena.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by weibo_li on 2016/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PageHelperTest {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    UserMapper userMapper;

    @Test
    public void pageHelperTest2() {

        /**
         * 1.�ڲ�ѯ��ʱ��ָ��pageNum��pageSize����
         * 2.Ҳ������service���н������á�������service1����server2��m1����֮ǰ�������ã�Ȼ�����service2�е�m1������mapper��һ��select��ѯ
         */
        PageHelper.startPage(1, 10);

        List<User> userList = userMapper.selectTest();
        System.out.println(userList.size());

    }


}
