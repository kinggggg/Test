package com.shengsiyuan.java8.methodreference;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MethodReferenceDemo
 * @Description
 * @Author liweibo
 * @Date 2019/10/22 5:33 PM
 * @Version v1.0
 **/
public class MethodReferenceDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "hello world");

//        list.forEach(item -> System.out.println(item));
        list.forEach(System.out::println);
    }
}
