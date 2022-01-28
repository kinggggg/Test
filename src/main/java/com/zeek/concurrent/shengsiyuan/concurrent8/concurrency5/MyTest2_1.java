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
public class MyTest2_1 {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int n = 0; n < 2; n++) { // 模拟2个阶段
            for (int i = 0; i < 3; i++) { // 模拟每个阶段三个线程共同完成
                new Thread(() -> {
                    try {
                        Thread.sleep((long) (Math.random() * 2000));
                        int randomInt = new Random().nextInt(500);
                        System.out.println("hello: " + randomInt);
                        cyclicBarrier.await(); // 这里代表每个线程所执行到的点
                        System.out.println("world: " + randomInt);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}
