package com.shengsiyuan.java8;

import java.util.function.Supplier;

/**
 * @ClassName StudentTest
 * @Description
 * @Author liweibo
 * @Date 2019/10/17 7:27 PM
 * @Version v1.0
 **/
public class StudentTest {

    public static void main(String[] args) {

        Supplier<Student> supplier1 = () -> new Student();
        System.out.println(supplier1.get().getName());

        // Student的构造方法符合Supplier函数式接口中的get方法的契约要求，即，不接受参数，只有返回值
        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get().getName());

    }
}
