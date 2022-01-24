package com.zeek.concurrent.shengsiyuan.concurrent8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * @ClassName MyTest1
 * @Description
 *
 *
 *
 * @Author liweibo
 * @Date 2020/6/26 8:51 下午
 * @Version v1.0
 **/
public class MyTest2 {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void method() {

        try {
            readWriteLock.writeLock().lock();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("method");
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public static void main(String[] args) {

        MyTest2 myTest2 = new MyTest2();

        IntStream.range(0, 10).forEach(i -> new Thread(myTest2::method).start());

    }

}
