package com.shengsiyuan.java8;

/**
 * @author: liweibo
 * @since: 2019-09-27 2:48 PM
 */
@FunctionalInterface
public interface MyInterface {

    void test();

    String toString();
}

class RunTest {

    public void myTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Me me = new Me();
        me.test();

        RunTest runTest = new RunTest();
        runTest.myTest(() -> {
            System.out.println("mytest");
        });

        MyInterface myInterface = () -> {
            System.out.println("mytest");
        };

        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);

    }
}
