package com.zeek.concurrent.shengsiyuan.concurrent8.concurrency7;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-29
 */
public class MyTest2_1 {
    public static void main(String[] args) {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().isDaemon());
            System.out.println("task finished");
        });
        /*
            如果不使用 CompletableFuture 的 whenComplete，而使用Future的get方法的话，get方法会阻塞住main
            线程！而 whenComplete 方法不会阻塞住main线程的执行！这就是 CompletableFuture 比 Future 的优势所在！
         */
        completableFuture.whenComplete((t, action) -> System.out.println("执行完成！"));
        System.out.println("主线程执行完毕");

        //  由于CompletableFuture中的线程为deamon类型的，因此需要在main线程中sleep等待一下，否则当
        // main线程运行结束后JVM就退出了
        try {
            TimeUnit.MILLISECONDS.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
