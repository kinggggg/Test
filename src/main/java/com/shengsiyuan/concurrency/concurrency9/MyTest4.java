package com.shengsiyuan.concurrency.concurrency9;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * 程序输出如下：
 *
 * pool-1-thread-3
 * pool-1-thread-1
 * pool-1-thread-4
 * 2 // 比 0 任务后提交执行，但是由于其执行快，其执行结果优先被放置到了 ExecutorCompletionService 结果队列的对头中，当遍历 这个结果队列时优先被遍历到
 * 0 // 最先提交的任务
 * 3
 * pool-1-thread-2
 * pool-1-thread-3
 * 1
 * 4
 *
 * 可以看到获取结果时，与任务提交的顺序没有关系
 *
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-02-10
 */
public class MyTest4 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = new ThreadPoolExecutor(4, 10, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20), new ThreadPoolExecutor.AbortPolicy());
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        IntStream.range(0, 5).forEach(i -> {
            completionService.submit(() -> {
                Thread.sleep((long) Math.random() * 1000);

                System.out.println(Thread.currentThread().getName());
                return i;
            });
        });

        for (int i = 0; i < 10; i++) {
            int result = completionService.take().get();
            System.out.println(result);
        }

        executorService.shutdown();
    }
}
