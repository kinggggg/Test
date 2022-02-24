package com.shengsiyuan.concurrency.concurrency9;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 测试代码。针对程序的输出有疑问？
 *
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-02-07
 */
public class MyTest2_1 {

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(3, 500, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue(3), new ThreadPoolExecutor.AbortPolicy());
        int corePoolSize = executorService.getCorePoolSize();
        int activeCount = executorService.getActiveCount();
        int poolSize = executorService.getPoolSize();
        String toString = executorService.toString();
        System.out.println("corePoolSize = " + corePoolSize + " activeCount = " + activeCount + " poolSize = " + poolSize + " toString = " + toString);

        IntStream.range(0, 9).forEach(i -> {
            executorService.submit(() -> {
                System.out.println("corePoolSize = " + corePoolSize + " activeCount = " + activeCount + " poolSize = " + poolSize + " toString = " + toString);
                IntStream.range(0, 2).forEach(j -> {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("corePoolSize = " + corePoolSize + " activeCount = " + activeCount + " poolSize = " + poolSize + " toString = " + toString);
                    System.out.println(Thread.currentThread().getName() );
                });
            });
        });

        executorService.shutdown();

    }
}
