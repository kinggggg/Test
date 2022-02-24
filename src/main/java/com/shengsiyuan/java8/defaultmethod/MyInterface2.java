package com.shengsiyuan.java8.defaultmethod;

/**
 * @author: liweibo
 * @since: 2019-10-24 5:00 PM
 */
public interface MyInterface2 {

    default void myMethod() {
        System.out.println("MyInterface2");
    }
}
