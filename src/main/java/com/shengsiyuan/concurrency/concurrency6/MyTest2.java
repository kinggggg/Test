package com.shengsiyuan.concurrency.concurrency6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 对应CAS来说，其操作数主要涉及到如下三个：
 *
 * 1. 需要被操作的内存值V（当前AtomicInteger变量在内存中的值）
 * 2. 需要进行比较的值A （AtomicInteger自己维持的一个用于比较的值）
 * 3. 需要进行写入的值B （调用AtomicInteger的API后AtomicInteger变量的最新值）
 *
 * 只有当V==A的时候，CAS才会通过原子操作的手段来将V的值更新为B
 *
 * 关于CAS的限制或是问题：
 * 1. 循环开销问题：并发量大的情况下会导致线程一直自旋。这是CAS本身的机制所导致的，无法避免
 * 2. 只能保证一个变量的原子操作。即，不能实现同时对多个 AtomicInteger 类型的变量进行原子操作。
 *      如果需要同时对多个 AtomicInteger 变量进行原子操作的话，可以使用AtomicReference来实现
 *      对多个变量的原子操作
 * 3. CAS无法避免ABA问题。即，假设变量的初始值为1，线程a获取到变量的值为1，线程b也获取到了变量的值为
 *      1，但是线程b针对这个变量的值作为了如下的修改过程 1 -> 3 -> 1，而此时线程a虽然看到的值还是为1
 *      但是这个1是不是之前的那个1了，虽然值是相同的！此时针对线程a来说，就产品了ABA问题。解决ABA问题可以
 *      通过加入版本号或者时间戳的方式来解决。即，每次修改变量的值同时维护一个版本号或者时间戳，当判断是否
 *      能更新变量的值时，需要同时判断变量的值与版本号或者时间戳是否相同，如果相同才进行更新，否则不更新，
 *      然后进入到下一次判断当中持续进行
 *
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-29
 */
public class MyTest2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndSet(8));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}
