package com.zeek.junit;

import com.zeek.javatest.domain.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2020-10-21
 */
public class JunitTest {

    @Test
    public void test2() {
        whileTurn();
    }

    public String whileTurn() {

        while (true) {
            System.out.println("1");
            return "2" ;
        }


    }

    @Test
    public void testAssert() {

//        Assert.assertNull(null);

        Assert.assertNull(new User());

    }
}
