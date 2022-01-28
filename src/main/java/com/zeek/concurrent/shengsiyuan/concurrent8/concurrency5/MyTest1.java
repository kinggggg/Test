package com.zeek.concurrent.shengsiyuan.concurrent8.concurrency5;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
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
