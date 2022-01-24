package com.zeek.concurrent.shengsiyuan.concurrent8.concurrency3;

/**
 * 当使用synchronized修饰类的静态方法时,
 * JVM使用了 ACC_STATIC 和 ACC_SYNCHRONIZED 2个访问标志区分一个方法是否为同步方法
 *
 * @ClassName MyTest3
 * @Description
 * @Author liweibo
 * @Date 2022/1/23 11:53 下午
 * @Version v1.0
 **/
public class MyTest3 {

    public static synchronized void method() {
        System.out.println("hello world");
    }
}
