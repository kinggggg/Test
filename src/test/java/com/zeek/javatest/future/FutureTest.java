package com.zeek.javatest.future;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FutureTest {

    private static final ExecutorService threadPool = new ThreadPoolExecutor(64, 64, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    @Test
    public void name() throws InterruptedException {

        List<Integer> integers = Arrays.asList(1, 2, 3);
        // 写入我方库
        for (int j = 0; j < 3; j++) {
            CountDownLatch countDownLatch = new CountDownLatch(integers.size());
            List<CompletableFuture<Void>> cfs = new ArrayList();
            for (Integer i : integers) {
                CompletableFuture<Void>
                        future = CompletableFuture.runAsync(() -> {
//                    System.out.println(i);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }, threadPool);
                cfs.add(future);
                System.out.println("inner++");
//                CompletableFuture.allOf(future);
            }
//            CompletableFuture[] completableFutures = cfs.toArray(new CompletableFuture[0]);
//            CompletableFuture.allOf(completableFutures);
            countDownLatch.await();
            System.out.println("outer=================>");
        }
    }

    @Test
    public void test1() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            while (!result.isDone()) {
                Thread.sleep(1000);
                System.out.println("子线程还没有执行完：" + System.currentTimeMillis());
            }
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");

        executor.shutdown();
    }
}
