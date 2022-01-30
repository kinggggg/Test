package com.zeek.concurrent.shengsiyuan.concurrency.concurrency2;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-23
 */
public class MyThreadTest2 {
}

class MyClass {

    public synchronized void hello() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello");
    }

    public synchronized void world() {
        System.out.println("world");
    }

}

class Thread1 extends Thread {

    private MyClass myClass;

    public Thread1(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        myClass.hello();
    }
}

class Thread2 extends Thread {

    private MyClass myClass;

    public Thread2(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        myClass.world();
    }
}
