package com.shengsiyuan.java8;

import java.util.function.Supplier;

/**
 * @ClassName SupplierTest
 * @Description
 * @Author liweibo
 * @Date 2019/10/17 7:25 PM
 * @Version v1.0
 **/
public class SupplierTest {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "hello world";

        System.out.println(supplier.get());

    }
}
