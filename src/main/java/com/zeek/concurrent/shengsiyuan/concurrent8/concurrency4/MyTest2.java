package com.zeek.concurrent.shengsiyuan.concurrent8.concurrency4;

/**
 * 传统上，我们可以通过synchronized关键字 + wait + notify/notifyAll 来实现多个线程之间的协调与通信，
 * 整个过程都是由JVM来帮助我们实现的；开发者无需（也是无法）了解底层的实现细节
 *
 * 从JDK1.5开始，并发包提供了Lock，Condition（await与signal/signalAll）来实现多个线程之间的协调与通信，
 * 整个过程都是由开发者来控制的，而且相比于传统方式，更加灵活，功能也更加强大
 *
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-25
 */
public class MyTest2 {
}
