package com.zeek.javatest.integer;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by weibo_li on 2016/12/28.
 */
public class AtomicIntegerTest {


    @Test
    public void forTest() {
        AtomicInteger atomicInteger = new AtomicInteger(10);

        int i = atomicInteger.addAndGet(5);
        System.out.println(i);

        int i1 = atomicInteger.accumulateAndGet(20, Integer::max);
        System.out.println(i1);
    }

}
