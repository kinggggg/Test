package com.zeek.jd;

import org.junit.runner.notification.RunListener;

/**
 * 线程安全的单例模式
 *
 * @author liweibo04 <liweibo04@58.com>
 * Created on 2025/6/21 11:36
 */
public class SingletonSafeThread {

    public static void main(String[] args) {

    }
}

class MyTheadSafe {
    private MyTheadSafe() {}
    private volatile MyTheadSafe threadSafe = null;

    public MyTheadSafe getThreadSafe() {
            if (threadSafe == null) {
                synchronized (SingletonSafeThread.class) {
                    if (threadSafe != null) {
                        return threadSafe;
                    }
                    threadSafe = new MyTheadSafe();
                    return threadSafe;
                }
            }
        return threadSafe;
    }
}
