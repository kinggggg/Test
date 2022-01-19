package com.zeek.javatest.parent;

/**
 * Created by weibo_li on 2017/2/17.
 */
public class Teacher3 implements Comparable{

    private String name;

    public Teacher3() {}

    public Teacher3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return -1;
    }
}
