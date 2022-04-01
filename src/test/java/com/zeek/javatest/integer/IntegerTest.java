package com.zeek.javatest.integer;

import org.junit.Test;

/**
 * @ClassName IntegerTest
 * @Description
 * @Author liweibo
 * @Date 2018/10/25 下午5:30
 * @Version v1.0
 **/
public class IntegerTest {

    @Test
    public void integerTest() throws Exception {

        // 为什么输出的还是负值？
        //
        int i = -2147483648;
        int j = -i;
        int q = Math.abs(i);
        System.out.println(i);
        System.out.println(j);
        System.out.println(q);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void test04() {
        Integer i = 127;
        Integer j = 127;
        if(i==j){
            System.out.println("i==j is equal");
        }else {
            System.out.println("i==j is not equal");
        }
    }

    @Test
    public void test03() {
        Integer i = 128;
        Integer j = 128;
        if(i==j){
            System.out.println("i==j is equal");
        }else {
            System.out.println("i==j is not equal");
        }

    }

    @Test
    public void test02() {
        Integer i = 500;
        Integer j = new Integer(500);
        if(i==j){
            System.out.println("i==j is equal");
        }else {
            System.out.println("i==j is not equal");
        }

    }

    @Test
    public void test01() {

        Integer i = new Integer(555);
        Integer j = new Integer(555);
        if(i==j){
            System.out.println("i==j is equal");
        }else {
            System.out.println("i==j is not equal");
        }

    }


}
