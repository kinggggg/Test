package com.zeek.javatest.javabase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ReturnTest
 * @Description return执行时机
 * @Author liweibo
 * @Date 2019/8/5 4:21 PM
 * @Version v1.0
 **/
public class ReturnTest {

    public static void main(String[] args) {

        // 为什么输出的还是负值？
        int i = -2147483648;
        int j = -i;
        int q = Math.abs(i);
        System.out.println(i);
        System.out.println(j);
        System.out.println(q);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);


    }


}
