package com.shengsiyuan.java8;

/**
 * @ClassName Me
 * @Description Me实现了这个函数式接口。此时注意：Me此时只需要实现test接口接口，不需要实现toString接口！！
 * @Author liweibo
 * @Date 2019/9/27 3:00 PM
 * @Version v1.0
 **/
public class Me implements MyInterface {


    @Override
    public void test() {
        System.out.println("me");
        System.out.println(toString());
    }
}
