package com.zeek.javatest.javabase.extend;

public class Child extends Parent {

    @Override
    public void test1() {
        super.test1();
    }

    @Override
    public void test2() {
        System.out.println("child test2");
    }

    public static void main(String[] args) {
        new Child().test1();
    }
}
