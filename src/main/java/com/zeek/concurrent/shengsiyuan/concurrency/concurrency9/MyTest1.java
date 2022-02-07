package com.zeek.concurrent.shengsiyuan.concurrency.concurrency9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * 比如当前创建了一个固定数量的线程，指定的线程数量为5。
 *
 * 1. 当线程池开始启动的时候，是马上创建这
 * 5个线程，还是当有第一个任务被提交到线程池后才开始创建线程？
 *
 * 2. 如果提交到线程池中的第一个任务执行完了后，此时的线程池中线程的数量为3，此时向线程池中提交第
 * 2个线程，由于此时核心线程数量还没有超过5，此时线程池是新创建线程，还是复用已有的线程？
 *
 * @param corePoolSize the number of threads to keep in the pool, even
 *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
 *        线程池中所一直维护的线程数量，如果线程池处于任务空闲期间，那么该线程也并不会被回收掉
 * @param maximumPoolSize the maximum number of threads to allow in the
 *        pool
 *        线程池中所维护的线程数的最大数量
 * @param keepAliveTime when the number of threads is greater than
 *        the core, this is the maximum time that excess idle threads
 *        will wait for new tasks before terminating.
 *        超过了 corePoolSize 的线程在经过 keepAliveTime 时间后如果一直处于空闲状态，
          那么超过的这部分线程将会被回收掉
 * @param unit the time unit for the {@code keepAliveTime} argument
 *        指的是 keepAliveTime 的时间单位
 * @param workQueue the queue to use for holding tasks before they are
 *        executed.  This queue will hold only the {@code Runnable}
 *        tasks submitted by the {@code execute} method.
 *        向线程池所提交的任务位于阻塞队列，它的实现有多种方式
 * @param threadFactory the factory to use when the executor
 *        creates a new thread
 *        线程工厂，用于创建新的线程并被线程池所管理，默认线程工厂所创建的线程都是用户线程（即，非daemon类型的线程）
 *        且优先级为正常优先级
 * @param handler the handler to use when execution is blocked
 *        because the thread bounds and queue capacities are reached
 *        表示当线程池中的线程都在忙于执行任务且阻塞队列也已经满了的情况下，新到的任务该如何被对待和处理。
 *        它有四种实现策略：
 *        1. AbortPolicy：直接抛出一个运行期异常
 *        2. DiscardPolicy：默默地丢弃掉提交的任务，什么都不做且不抛出任何异常
 *        3. DiscardOldestPolicy：丢弃掉阻塞队列中存放时间最久的任务（队头元素），并且（在队列的末尾）为当前所提交的任务留出一个队列
 *        中的空闲空间，以便将其放进队列中
 *        4. CallerRunsPolicy：直接由提交任务的线程（即，调用线程池execute或者submit方法的线程）来运行这个提交的任务
 *
 *        在线程池中，最好将偏向锁的标记关闭。
 *        JVM开启和关闭偏向锁参考：
 *        1. https://blog.csdn.net/weixin_44737877/article/details/104867624
 *        2. https://blog.csdn.net/weixin_39841589/article/details/106456221
 *
 *
 */
public class MyTest1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        IntStream.range(0, 10).forEach(i -> {
            executorService.submit(() -> {
               IntStream.range(0, 10).forEach(j -> {
                   System.out.println(Thread.currentThread().getName() );
               });
            });
        });

        executorService.shutdown();
    }
}
