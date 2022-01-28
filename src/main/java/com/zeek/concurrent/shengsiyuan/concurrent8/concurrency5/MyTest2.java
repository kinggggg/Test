package com.zeek.concurrent.shengsiyuan.concurrent8.concurrency5;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 *
 * @ClassName MyTest2
 * @Author liweibo
 * @Date 2022/1/28 11:08 下午
 * @Version v1.0
 **/
public class MyTest2 {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 2000));
                    int randomInt = new Random().nextInt(500);
                    System.out.println("hello: " + randomInt);
                    cyclicBarrier.await();
                    System.out.println("world: " + randomInt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
