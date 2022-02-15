package com.shengsiyuan.java8.defaultmethod;

/**
 * @ClassName MyClass
 * @Description
 * @Author liweibo
 * @Date 2019/10/24 5:01 PM
 * @Version v1.0
 **/
public class MyClass implements MyInterface1, MyInterface2{

    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        myClass.myMethod();
    }

    @Override
    public void myMethod() {
//        System.out.println("myMethod");

        // 显示指定调用哪个接口中的默认方法。接口名称.super.默认方法 这种语法形式第一次看到
        MyInterface2.super.myMethod();
    }
}
