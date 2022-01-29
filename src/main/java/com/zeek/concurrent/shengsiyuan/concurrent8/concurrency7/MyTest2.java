package com.zeek.concurrent.shengsiyuan.concurrent8.concurrency7;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-29
 */
public class MyTest2 {
    public static void main(String[] args) {
        /*
        程序输出为：
        ForkJoinPool.commonPool-worker-9---supplyAsync
        ForkJoinPool.commonPool-worker-9---thenApplyAsync
        hello world

        虽然在supplyAsync中等待了5秒，但是还是需要supplyAsync执行完了后，thenApplyAsync才继续执行。
        即，当supplyAsync中的异步任务执行完了后，此开始执行thenApplyAsync中的异步任务
         */
        String result = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "---supplyAsync");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenApplyAsync(value -> {
            System.out.println(Thread.currentThread().getName() + "---thenApplyAsync");
            return value + " world";
        }).join();
        System.out.println(result);

        System.out.println("====================");

        CompletableFuture.supplyAsync(() -> "hello").thenAccept(value -> System.out.println("welcome " + value));

        System.out.println("====================");

        /*
        两个supplyAsync中的任务是同时进行的！
         */
        String result2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "---supplyAsync1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "---supplyAsync2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> s1 + " " + s2).join();
        System.out.println(result2);

    }
}
