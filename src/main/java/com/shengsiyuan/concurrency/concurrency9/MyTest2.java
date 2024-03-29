package com.shengsiyuan.concurrency.concurrency9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 对于线程池来说，其提供了execute与submit两种方式来向线程池提交任务
 * 总体来说，submit方法是可以取代execute方法的，因为它既可以接收Callable任务，也可以接收Runnable任务
 *
 * 关于线程池的总体执行策略：
 * 1. 如果线程池中正在执行的线程数 < corePoolSize，那么线程池就会优先选择创建新的线程而非将提交的任务加到阻塞队列中
 * 2. 如果线程池中正在执行的线程数 >= corePoolSize，那么线程池就会优先选择对提交的任务进行阻塞排队而非创建新的线程
 * 3. 如果提交的任务无法加入阻塞队列当中，那么线程池就会创建新的线程；如果创建的线程数超过了maximumPoolSize，那么拒绝策略就会起作用
 *
 * 对于线程池来说，存在两个状态需要维护，通过其ctl属性来维护：
 * 1. 线程池本身的状态：ctl的高3位来表示
 * 2. 线程池中所运行着的（知识running状态的吗？包括空闲状态的吗？）线程的数量：ctl的其余29位来表示
 *
 * 线程池一共存在5种状态：
 * 1. RUNNING：线程池可以接收新的任务提交，并且还可以正常处理阻塞队列中的任务
 * 2. SHUTDOWN: 不再接收新的提交任务，不过线程池可以继续处理阻塞队列中的任务
 * 3. STOP: 不再接收新的提交任务，同时还会丢弃阻塞队列中的既有任务；此外，它还会中断正在处理中的任务
 * 4. TIDYING: 所有的任务都执行完毕后（同时也涵盖了阻塞队列中的任务），当前线程池中的活动的线程数量降为0
 *    （当初始化线程池指定的corePoolSize不为0时，线程池中活动的线程数量不可能为0吧?！），将会调用terminated方法
 * 5. TERMINATED: 线程池的终止状态，当terminated方法执行完毕后，线程池将会处于该状态下
 *
 * RUNNING -> SHUTDOWN: 当调用了线程池的shutdown方法时，或者finalize方法被隐式调用后（该方法内部会调用shutdown方法）
 * RUNNING, SHUTDOWN -> STOP: 当调用了线程池的shutdownNow方法时
 * SHUTDOWN -> TIDYING：在线程池与阻塞队列均变为空时
 * STOP -> TIDYING：在线程池变为空时
 *
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
