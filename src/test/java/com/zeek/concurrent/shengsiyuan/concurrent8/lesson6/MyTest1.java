package com.zeek.concurrent.shengsiyuan.concurrent8.lesson6;

/**
 * 在调用wait方法时, 线程必须要持有被调用对象的锁, 当调用wait方法后, 线程就会释放掉该对象的锁(monitor).
 * 在调用Thread类的sleep方法时, 线程是不会释放掉对象的锁的
 *
 * 关于当调用wait与notify和notifyAll方法的总结
 *
 * 1. 当调用wait时, 首先需要确保调用了wait方法的线程已经持有了对象的锁
 * 2. 当调用wait后, 该线程就会释放掉这个对象的锁, 然后进入到等待状态(wait set)
 * 3. 当线程调用了wait后进入到等待状态时, 它就可以等待其他其他线程调用相同对象的notify或notifyAll方法来使得自己被唤醒
 * 4. 一旦这个线程被其他线程唤醒后, 该线程就会与其他线程一同开始竞争这个对象的锁(公平竞争); 只有当该线程获取到这个对象的锁后, 线程才会继续往下执行
 * 5. 调用wait方法的代码片段需要放在一个synchronized块是synchronized方法中, 这样才可以确保线程在调用wait方法前已经获取到了对象的锁
 * 6. 当调用对象的notify方法时, 它会随机唤醒该对象等待集合(wait set)中的任意一个线程, 当某个线程(称之为T)被唤醒后, 它就会与其他线程一同竞争对象的锁. 注意!! 这里所说的"它就会与其他线程一同竞争对象的锁"
 *      其中表达了一层之前自己所忽略了一种含义: T线程被唤醒时(即, 执行wait方法时T线层会进行等待状态), T线程会与其他线程一同竞争对象的锁.
 *      若竞争成功获取到对象的锁了, 那么T会正常执行其下文的代码;
 *      若竞争失败了没有获取到对象的锁, 那么T线程还是会停止在执行wait方法一行代码处, 其会等待下一次时机来获取运行
 * 7. 当调用对象的notifyAll方法时, 它会唤醒该对象等待集合(wait set)中的所有线程, 这些线程被唤醒后, 又会开始竞争对象的锁
 * 8. 在某一时刻, 只有唯一一个线程可以拥有对象的锁
 *
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-23
 */
public class MyTest1 {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        synchronized (object) {
            object.wait();
        }
    }
}
