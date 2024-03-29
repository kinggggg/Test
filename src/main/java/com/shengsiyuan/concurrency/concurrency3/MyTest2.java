package com.shengsiyuan.concurrency.concurrency3;

/**
 * 对于synchronized关键字修饰方法来说, 并没有出现monitorenter与monitorexit指令, 而是出现了一个 ACC_SYNCHRONIZED 标志(通过
 * javap -v java字节码文件路径 可以看到这个标志)
 *
 * JVM使用了 ACC_SYNCHRONIZED 访问标志区分一个方法是否为同步方法; 当方法被调用时, 调用指令会检查该方法是否拥有 ACC_SYNCHRONIZED 标志.
 * 如果有, 那么执行线程将会先持有方法所在对象的Monitor对象, 然后再去执行方法体; 在该方法执行期间, 其他任何线程均无法再获取到这个Monitor对象,
 * 当线程执行完该方法后, 它会释放掉这个Monitor对象
 *
 * @ClassName MyTest2
 * @Description
 * @Author liweibo
 * @Date 2022/1/23 10:45 下午
 * @Version v1.0
 **/
public class MyTest2 {

    public synchronized void method() {
        System.out.println("hello world");
    }

}
