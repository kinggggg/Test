package com.shengsiyuan.concurrency.concurrency3;

/**
 * 在一般的情况下当反编译下面代码对应的字节码文件时每个用synchronized修饰的同步代码块都会生成与之对应的字节码
 * 同步指令（即，前面课程中所说的，例如monitorenter，monitorexit指令）
 *
 * 锁粗化：
 *
 * 但是JIT编译器在执行动态编译时，若发现前后相邻的synchronized块使用的是同一个锁对象，那么它机会把这几个synchronized
 * 块合并成一个较大的同步块，这样做的好处在于线程执行这些代码块时，就无需频繁申请与释放锁了，从而达到申请与释放锁一次，
 * 就可以执行完全部的同步代码块，从而提升了性能。这个优化称之为 锁粗化
 *
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-24
 */
public class MyTest5 {
    Object object = new Object();

    public void method() {
//        Object object = new Object();

        synchronized (object) {
            System.out.println("hello world");
        }

        synchronized (object) {
            System.out.println("welconme");
        }

        synchronized (object) {
            System.out.println("person");
        }
    }
}
