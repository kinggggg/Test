package com.shengsiyuan.concurrency.concurrency5;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * 简单介绍CountDownLatch的使用。
 *
 * 需要注意的有以下几点
 * 1. 当调用countDown将CountDownLatch的计数减为0后，若此还有另外一个线程调用await方法的话，await将直接返回
 * 2. 当CountDownLatch计数不减为0的话，调用await方法的线程将一直等待下去，除非调用了其interrupt方法
 * 3. 可以调用带超时时间的await方法，防止出现一直等待的情况出现
 *
 * @ClassName MyTest1
 * @Author liweibo
 * @Date 2022/1/28 10:20 下午
 * @Version v1.0
 **/
public class MyTest1 {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        }).start());

        System.out.println("启动子线程完毕");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行完毕");
    }
}
