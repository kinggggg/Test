package com.shengsiyuan.concurrency.concurrency3;

/**
 * 死锁：线程1等待线程2互斥持有的资源，而线程2也在等待线程1互斥持有的资源，两个线程都无法继续执行
 * 活锁：线程持续重试一个总是失败的操作，导致无法继续执行
 * 饿死：线程一直被调度器延迟访问其依赖以执行的资源，也许是调度器先于低优先级的线程而执行高优先级的线程，
 *  同时总会有一个高优先级的线程可以执行，饿死也叫做无限延迟
 *
 *
 *
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-25
 */
public class MyTest6 {

    private Object lock1 = new Object();

    private Object lock2 = new Object();

    public void myMethod1() {
        synchronized (lock1) {
            synchronized(lock2) {
                System.out.println("myMethod1 invoked");
            }
        }
    }

    public void myMethod2() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("myMethod2 invoked");
            }
        }
    }

    public static void main(String[] args) {
        MyTest6 myTest6 = new MyTest6();

        Runnable runnable1 = () -> {
            while (true) {
                myTest6.myMethod1();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(runnable1, "myThread1");

        Runnable runnable2 = () -> {
            while (true) {
                myTest6.myMethod2();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread(runnable2, "myThread2");

        thread1.start();
        thread2.start();


    }
}
