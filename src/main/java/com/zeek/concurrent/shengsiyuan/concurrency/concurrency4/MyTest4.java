package com.zeek.concurrent.shengsiyuan.concurrency.concurrency4;

/**
 * Java内存模型（Java Memory Model，jMM）以及happen-before原则
 * Java内存模型是为了解决以下的问题：
 * 1. 变量的原子性问题
 *      （1）JMM规定针对基本类型的变量的变量（除long与double类型外的）与引用类型的赋值操作都是原子性的
 *      （2）JVM规定针对volatile类型的变量（即使是long与double类型的变量）是原子性
 *          （注意！这里的原子性仅仅是赋值操作，并且这赋值操作右边的表达式中不能还有其他变量！
 *           之间的笔记中『33_volatile关键字作用与锁的关系深入详解』有强调过，可以参考）的
 * 2. 变量的可见性问题
 *      即，在多个线程同事修个一个共享变量的情况下
 * 3. 变量修改的时序性问题
 *      即，两个（多个）线程同时修改几个共享变量。如果线程1是按照先修改共享变量a，
 *      然后修改变量b进行的，那么线程2是按照什么顺序看到对变量a与变量b的修改的（与线程1一样还是不一样）
 *
 * happen-before重要规则：
 * 1. 顺序性规则（注意！该规则仅仅是在单线程的前提下）（即，极客时间专栏中的『1. 程序的顺序性规则』）：
 *      该线程的每个动作都happen-before它的后面的动作（注意！这里所说的与指令重排并不冲突！如果两行代码所访问的变量均不相关的
 *      话，此时JIT编译器还是会进行指令重排的）
 * 2. 隐式锁（Monitor）规则（即，极客时间专栏中的『4. 管程中锁的规则』）：
 *      unlock happen-before lock，之前的线程对于同步代码块（方法）的所有执行结果对于后续获取锁的线程来说都是可见的
 * 3. volatile规则（即，极客时间专栏中的『2. volatile 变量规则』）：
 *      对一个volatile变量的写操作一定会happen-before后续对改变量的读操作
 * 4. 多线程的启动规则（即，极客时间专栏中的『5. 线程 start() 规则』）：
 *      这条是关于线程启动的。它是指主线程 A 启动子线程 B 后，子线程 B 能够看到主线程在启动子线程 B 前的操作。
 *      换句话说就是，如果线程 A 调用线程 B 的 start() 方法（即在线程 A 中启动线程 B），那么该 start() 操作 Happens-Before 于线程 B 中的任意操作。
 *      具体可参考下面示例代码。
         Thread B = new Thread(()->{
         // 主线程调用B.start()之前
         // 所有对共享变量的修改，此处皆可见
         // 此例中，var==77
         });
         // 此处对共享变量var修改
         var = 77;
         // 主线程启动子线程
         B.start();
 * 5. 多线程的终止规则（即，极客时间专栏中的『6. 线程 join() 规则』）：
 *      一个线程启动了一个子线程，并且调用了子线程的join方法等待其结束，那么当子线程结束后，父线程接来下的所有操作
 *      都可以看到子线程run方法中的执行结果
 * 6. 线程的中断规则：
 *      可以调用interrupt方法来中断线程，这个调用happen-before对该线程中断的检查（isInterrupted）
 * 7. 传递性（即，极客时间专栏中的『3. 传递性』。这一点视频中提到了但是没有写笔记）：
 *      这条规则是指如果 A Happens-Before B，且 B Happens-Before C，那么 A Happens-Before C。
 *
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-28
 */
public class MyTest4 {
}
