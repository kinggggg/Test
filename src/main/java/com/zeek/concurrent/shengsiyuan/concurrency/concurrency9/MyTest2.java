package com.zeek.concurrent.shengsiyuan.concurrency.concurrency9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-02-07
 */
public class MyTest2 {

    public static void main(String[] args) {

        /*
                Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@270421f5 rejected from java.util.concurrent.ThreadPoolExecutor@52d455b8[Running, pool size = 5, active threads = 5, queued tasks = 3, completed tasks = 0]
            at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
            at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
            at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
            at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:112)
            at com.zeek.concurrent.shengsiyuan.concurrency.concurrency9.MyTest2.lambda$main$2(MyTest2.java:24)
            at java.util.stream.Streams$RangeIntSpliterator.forEachRemaining(Streams.java:110)
            at java.util.stream.IntPipeline$Head.forEach(IntPipeline.java:557)
            at com.zeek.concurrent.shengsiyuan.concurrency.concurrency9.MyTest2.main(MyTest2.java:23)
        pool-1-thread-3
        pool-1-thread-3
        pool-1-thread-5
        pool-1-thread-5
        pool-1-thread-1
        pool-1-thread-1
        pool-1-thread-4
        pool-1-thread-4
        pool-1-thread-2
        pool-1-thread-2
        pool-1-thread-3
        pool-1-thread-3
        pool-1-thread-5
        pool-1-thread-5
        pool-1-thread-1
        pool-1-thread-1

        提交的任务是9个，超过了线程池处理的极限（同时处理的最大任务数是5，阻塞队列中是3，因此线程池的极限是8），当超过了这个极限再向线程池提交任务的话，会按照
        拒绝策略进行处理。此时拒绝策略是 AbortPolicy 该策略直接抛出异常。因此输出是16行（每个任务会输出2行，一共成功执行了8个任务）
         */
//        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS,
//                new LinkedBlockingQueue(3), new ThreadPoolExecutor.AbortPolicy());

        /*
        pool-1-thread-2
        pool-1-thread-2
        pool-1-thread-3
        pool-1-thread-3
        pool-1-thread-4
        pool-1-thread-4
        pool-1-thread-1
        pool-1-thread-1
        pool-1-thread-5
        pool-1-thread-5
        pool-1-thread-4
        pool-1-thread-4
        pool-1-thread-2
        pool-1-thread-2
        pool-1-thread-3
        pool-1-thread-3

        正常输出16行。DiscardPolicy 的策略是对超过线程池处理能力后再提交任务时，不做任何处理
         */
//        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS,
//                new LinkedBlockingQueue(3), new ThreadPoolExecutor.DiscardPolicy());

        /*

        pool-1-thread-5
        pool-1-thread-5
        main
        main
        pool-1-thread-3
        pool-1-thread-3
        pool-1-thread-1
        pool-1-thread-1
        pool-1-thread-4
        pool-1-thread-4
        pool-1-thread-2
        pool-1-thread-2
        pool-1-thread-3
        pool-1-thread-3
        pool-1-thread-1
        pool-1-thread-1
        pool-1-thread-5
        pool-1-thread-5

        超过线程池处理能力的任务会被调用线程池方法（这里为 submit 方法）的线程（这里来说也就是main线程）处理，因此输出2个main
         */
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue(3), new ThreadPoolExecutor.CallerRunsPolicy());

        IntStream.range(0, 9).forEach(i -> {
            executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                IntStream.range(0, 2).forEach(j -> {
                    System.out.println(Thread.currentThread().getName() );
                });
            });
        });

        executorService.shutdown();

    }
}
