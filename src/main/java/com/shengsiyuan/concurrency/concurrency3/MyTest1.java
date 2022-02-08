package com.shengsiyuan.concurrency.concurrency3;

/**
 * 当我们使用synchronized关键字来修饰代码块时, 字节码层面上是通过monitorenter与monitorexit指令来实现的锁的获取与释放
 * 当线程进入到monitorenter指令后, 线程将会持有Monitor对象, 退出monitorenter指令后, 线程将会释放Monitor对象
 *
 * @ClassName MyTest1
 * @Description
 * @Author liweibo
 * @Date 2022/1/23 10:45 下午
 * @Version v1.0
 **/
public class MyTest1 {

    private Object object = new Object();

    public void method() {
        synchronized (object) {
            System.out.println("hello world");
            throw new RuntimeException();
        }
    }

    public void method2() {
        synchronized (object) {
            System.out.println("welcome");
        }
    }
}
