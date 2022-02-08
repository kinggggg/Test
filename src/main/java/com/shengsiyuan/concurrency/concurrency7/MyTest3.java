package com.shengsiyuan.concurrency.concurrency7;

/**
 * ThreadLocal
 * 本质上，ThreadLocal是通过空间来换取时间，从而实现每个线程当中都会有一个变量的副本，这样每个线程就都会操作该副本
 * ，从而完全规避了多线程的并发问题
 *
 * Java中存在四种类型的引用：
 * 1. 强引用（strong）
 * 2. 软引用（soft）
 * 3. 弱引用（weak）
 * 4. 虚引用（phantom）
 *
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-29
 */
public class MyTest3 {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
        threadLocal1.set("hello world");
        System.out.println(threadLocal1.get());
        threadLocal1.set("welcome");
        System.out.println(threadLocal1.get());

        ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
        threadLocal2.set("hello");
        System.out.println(threadLocal2.get());

    }
}
