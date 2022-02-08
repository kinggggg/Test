package com.shengsiyuan.concurrency.concurrency6;

/**
 * CAS
 * <p>
 * 1. synchronized关键字与Lock等锁机制都是悲观锁：无论做何种操作，首先都是需要先上锁，接下来再去执行后续操作，从而
 * 保证了接下来所有操作都是由当前这个线程来执行的
 * 2. 乐观锁：线程在操作之前不会做任何预先处理，而是直接去执行；当在最后执行变量变量变更的时候，当前线程需要有一种机制来
 * 确保当前被操作的变量是没有被其他线程修改的；CAS是乐观锁的一种极为重要的实现方式
 * <p>
 * CAS（Compare And Swap）
 * 比较与交换：这是一个不断循环的过程，一直到变量值被修改成功为止。CAS本身是由硬件指令来提供支持的，换句话说，硬件中是通过
 * 一个原子指令来实现比较与交换的（什么意思呢？虽然CAS的操作是先比较再交换，那如果在比较完成了后，在交换之前，值
 * 又被其他线程修改了后不就又出为了吗？答案是不会的！因为这个先比较然后再交换的过程是由硬件来保证其原子性的）；
 * 因此，CAS可以确保变量操作的原子性的
 *
 * @ClassName MyTest1
 * @Author liweibo
 * @Date 2022/1/29 12:24 上午
 * @Version v1.0
 **/
public class MyTest1 {

    private int count;

    public synchronized int getCount() {
        return count;
    }

    /*
        ++this.count语句其实在字节码层面的执行过程是这样的：
        读取 -> 修改 -> 写入：这三个操作并非是原子操作
        increaseCount中++this.count对应的关键字节码如下，可见是四个字节码指令：
        ...
         2 getfield #2 <com/zeek/concurrent/shengsiyuan/concurrent8/concurrency6/MyTest1.count : I>
         5 iconst_1
         6 iadd
         7 putfield #2 <com/zeek/concurrent/shengsiyuan/concurrent8/concurrency6/MyTest1.count : I>
        ...
     */
    public synchronized void increaseCount() {
        ++this.count;
    }
}
