package com.zeek.javatest.collection.arraylist;

/**
 * @author: weibo_li
 * @since: 2018-03-06 下午7:56
 */
public class Person implements Cloneable{

    private int age ;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {}

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person(23, "zhang");
        Person p1 = (Person) p.clone();

        System.out.println(p);
        System.out.println(p1);

        String s1 = "a";
        String s2 = s1 + "b";
        String s3 = "a" + "b";
        System.out.println(s2 == "ab");//false
        System.out.println(s3 == "ab");//true


    }
}
