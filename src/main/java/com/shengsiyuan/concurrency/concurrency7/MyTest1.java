package com.shengsiyuan.concurrency.concurrency7;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-29
 */
public class MyTest1 {
    public static void main(String[] args) {
        Callable callable = () -> {
            System.out.println("pre execution");
            Thread.sleep(5000);
            int nextInt = new Random().nextInt(500);
            System.out.println("post execution");
            return nextInt;
        };

        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.setDaemon(true);
        thread.start();

        System.out.println("thread has started");
        try {
            Thread.sleep(1000);
//            System.out.println(futureTask.get());
            // 若超过等待的时间后还没有获取到结果，这个重载的get方法会抛出异常。
            // 注意！虽然抛出了异常（是在主线程main中抛出了异常），但是不会影响thread的继续执行，因此程序的输出为：
            /*
                thread has started
                pre execution
                java.util.concurrent.TimeoutException
                    at java.util.concurrent.FutureTask.get(FutureTask.java:205)
                    at com.zeek.concurrent.shengsiyuan.concurrent8.concurrency7.MyTest1.main(MyTest1.java:30)
                post execution
            */
            // 这是因为在默认的情况下创建出的线程为非deamon类型的
            // 若thread线程在start之前设置为deamon类型的话， 即，执行 thread.setDaemon(true);
            // 此时程序的输出为：
            /*
                thread has started
                pre execution
                java.util.concurrent.TimeoutException
                    at java.util.concurrent.FutureTask.get(FutureTask.java:205)
                    at com.zeek.concurrent.shengsiyuan.concurrent8.concurrency7.MyTest1.main(MyTest1.java:43)
            */
            // 这是因为当主线程中抛出异常后，主线程main就结束了；而thread线程又为deamon线程，而deamon类型的线程是无法停止JVM的退出的，即使
            // deamon线程还没有运行结束
            System.out.println(futureTask.get(1, TimeUnit.MILLISECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
