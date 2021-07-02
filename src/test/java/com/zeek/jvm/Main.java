package com.zeek.jvm;

/**
 * @author: weibo_li
 * @since: 2018-06-05 上午9:59
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {


        Integer i = 127;
        Integer j = 127;

        System.out.println(i == j);

        while (true) {
            Thread.sleep(1000);
        }

    }
}
