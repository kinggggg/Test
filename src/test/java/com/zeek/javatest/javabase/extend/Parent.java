package com.zeek.javatest.javabase.extend;

public class Parent {

    Parent() {
        System.out.println("Parent construct");
    }

    static {
        System.out.println("Parent static block");
    }

    {
        System.out.println("parent block");
    }

    public void test1() {
        System.out.println("parent test1");
        test2();
    }

    public void test2() {
        System.out.println("parent test2");
    }
}
