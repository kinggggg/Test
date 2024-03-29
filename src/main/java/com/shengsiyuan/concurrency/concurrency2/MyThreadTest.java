package com.shengsiyuan.concurrency.concurrency2;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2022-01-23
 */
public class MyThreadTest {

    public static void main(String[] args) {
        Runnable r = new MyThread();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable {

    int x;

    @Override
    public void run() {
        x = 0;

        while (true) {
            System.out.println("result: " + x++);

            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (x == 30) {
                break;
            }
        }
    }
}
