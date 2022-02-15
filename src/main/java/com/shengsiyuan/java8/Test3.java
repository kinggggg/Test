package com.shengsiyuan.java8;

import java.util.Arrays;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        TheInterface i1 = () -> {};
        System.out.println(i1.getClass().getInterfaces()[0]);

        TheInterface2 i2 = () -> {};
        System.out.println(i2.getClass().getInterfaces()[0]);

        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().map(String::toUpperCase).forEach(System.out::print);
    }
}

@FunctionalInterface
interface TheInterface{

    void myMethod();

}

@FunctionalInterface
interface TheInterface2 {
    void myMethod2();
}
