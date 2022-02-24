package com.shengsiyuan.java8;

/**
 * @ClassName Student
 * @Description
 * @Author liweibo
 * @Date 2019/10/17 7:27 PM
 * @Version v1.0
 **/
public class Student {

    private String name = "zhangsan";

    private int age = 20;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
