package com.java.mashibing;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-27
 */
public class VolatileTest {

    // 使用这行代码的时候，由于volatile修饰的变量可以保证当前线程对共享变量修改对其他线程的可见性
    // 程序不会在while语句造成死循环
//    public static volatile boolean flag = true;
    // 使用这行代码时，程序会陷入while语句的无限循环中，因为主线程中对flag变量的修改对server
    // 线程来说其实是不可见的
    public static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while(flag) {
            }
            System.out.println(Thread.currentThread().getName() + " " + "end");
        },"server").start();

        Thread.sleep(1000);

        System.out.println(Thread.currentThread().getName());
        flag = false;
    }
}
