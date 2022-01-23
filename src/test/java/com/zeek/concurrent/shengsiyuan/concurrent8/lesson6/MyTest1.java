package com.zeek.concurrent.shengsiyuan.concurrent8.lesson6;

/**
 * 在调用wait方法时, 线程必须要持有被调用对象的锁, 当调用wait方法后, 线程就会释放掉该对象的锁(monitor).
 * 在调用Thread类的sleep方法时, 线程是不会释放掉对象的锁的
 *
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-23
 */
public class MyTest1 {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        synchronized (object) {
            object.wait();
        }
    }
}
