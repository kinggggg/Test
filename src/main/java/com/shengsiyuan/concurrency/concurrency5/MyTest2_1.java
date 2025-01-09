package com.shengsiyuan.concurrency.concurrency5;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 *
 * 关于CyclicBarrier的底层执行流程
 *
 * 1. 初始化CyclicBarrier中的各种成员变量，包括parties、count以及Runnable（可选）
 * 2. 当调用await方法时，底层会先检查计数器是否已经归零，如果是的话，那么就首先执行可选的Runnable，接下来开始下一个generation
 * 3. 在下一个分代中，将会重置count的值为parties，并且创建新的Generation实例
 * 4. 同时会调用Condition的signalAll方法，唤醒所有在屏障前面等待的线程，让其开始执行
 * 5. 如果计数器没有归零，那么当前的调用线程将会通过Condition的await方法，在屏障前进行等待
 * 6. 以上所有执行流程均在lock锁的控制范围内，不会出现并发情况
 * @ClassName MyTest2
 * @Author liweibo
 * @Date 2022/1/28 11:08 下午
 * @Version v1.0
 **/
public class MyTest2_1 {

    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        // 重载的方法。当所有线程达到后，会执行这个Runnable
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("hello world");
        });
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
