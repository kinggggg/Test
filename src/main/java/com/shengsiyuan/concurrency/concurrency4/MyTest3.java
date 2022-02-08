package com.shengsiyuan.concurrency.concurrency4;

/**
 * volatile关键字
 *
 * private volatile int count
 *
 * volatile关键字有三方面作用：
 * 1. 实现double/long类型变量的原子操作
 *  视频的举例是以32位机器举例的。由于32位机器一次只能读取32个位，而java中的double/long类型的变量占用8个字节
 *  总共64位，因此在多个线程并发同一个double/long类型的变量时有可能导致变量的读写问题。例如当第一个线程修改double/long
 *  变量的低32位还没有来得及修改高32位时，第二个线程就对这个变量进行了读取操作，那么，此时第二个线程读取这个变量的值其实是
 *  一个中间状态，而不是正确的值
 * 2. 防止指令重排序
 * 3. 实现变量的可见性
 *
 * 当使用volatile修饰变量时，应用就不会从寄存器中获取改变量的值，而是从内存（高速缓存）中获取
 *
 * volatile与锁类似的地方：
 * 1. 确保变量在内存中的可见性
 * 2. 防止指令重排序
 *
 * volatile可以确保对变量写操作的原子性，但不具备排他性
 * 注意！！！视频中所说的原子性指的是这样的赋值：
 * volatile int count = 1;
 * volatile boolean flag = false;
 * 而下面的代码是不具备原子性的：
 * volatile int a = b + 2;
 * volatile int a = a++;
 * 即，如果要实现volatile写操作的原子性，那么在等号的右侧的表达式中就不能出现被多线程所共享的变量，
 *  哪怕这个变量也是个volatile修饰的变量也不可以
 *
 * 并且这样的代码也不能保证赋值的原子性 volatile Date date = new Date();
 * 因为这行代码其实涉及到两步操作，第一步是在堆上生成Date对象，第二步把这个Date对象的引用赋值给date变量。
 * 而只有第二步的这个赋值操作才具备原子性。
 *
 * int a = 1;
 * String s = "hello";
 * 内存屏障（Release Barrier，释放屏障）：  防止下面的volatile与上面的所有操作的指令重排序
 * volatile boolean v = false; //volatile变量的写入操作
 * 内存屏障（Store Barrier，存储屏障）：    重要的作用是刷新处理器缓存，结果是可以确保该存储屏障之前一切的操作所
 *                                     生成的结果对于其他处理器来说都可见
 *
 * 如果是对volatile类型的变量进行写入操作的话，JVM会进行如下的行为：
 * 1. 在volatile变量写操作前插入Release Barrier
 * 2. 在volatile变量写操作后插入Store Barrier
 *
 * 内存屏障（Load Barrier，加载屏障）:     可以刷新处理器缓存，同步其他处理器对该volatile变量的修改结果
 * boolean v1 = v;
 * 内存屏障（Acquire Barrier，获取屏障）：  可以防止上面的volatile读取操作与下面的所有操作语句的指令重排序
 * int a = 1;
 * String s = "hello";
 *
 * 对于volatile变量的读写操作，本质上都是通过内存屏障来执行的。
 *
 * 内存屏障兼具了两方面能力：1. 防止指令重排；2. 实现变量内存的可见性
 * 1. 对于修改操作来说，volatile可以去吧该操作与其上面的所有读写操作都不会进行指令重排
 * 2. 对于读取操作来说，volatile可以确保该操作与其后续的所有读写操作都不会进行指令重排
 *
 * volatile与锁的一些比较：
 * 锁同样具备变量内存可见性与防止指令重排功能，但是锁还具备volatile变量所不具备一个能力，锁可以保证排他性，即，
 * 在同一时刻锁能保证只有一个线程对共享变量的访问
 *
 * 锁本质的实现方式：
 * monitorenter
 * 内存屏障（Acquire Barrier，获取屏障）
 * ...业务代码...
 * 内存屏障（Release Barrier，释放屏障）
 * monitorexit
 *
 *
 * @ClassName MyTest3
 * @Author liweibo
 * @Date 2022/1/25 10:57 下午
 * @Version v1.0
 **/
public class MyTest3 {


}
