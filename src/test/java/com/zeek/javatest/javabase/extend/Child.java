package com.zeek.javatest.javabase.extend;

public class Child extends Parent {

    Child() {
        System.out.println("Child construct");
    }

    static {
        System.out.println("Child static block");
    }

    {
        System.out.println("Child block");
    }

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
