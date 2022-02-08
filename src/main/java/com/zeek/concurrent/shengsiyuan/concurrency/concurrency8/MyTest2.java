package com.zeek.concurrent.shengsiyuan.concurrency.concurrency8;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-02-02
 */
public class MyTest2 {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void method() {

        try {
            readWriteLock.readLock().lock();
//            readWriteLock.writeLock().lock();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("method");
        } finally {
            readWriteLock.readLock().unlock();
//            readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        MyTest2 test = new MyTest2();
        IntStream.range(0, 10).forEach(i -> new Thread(test::method).start());
    }
}
