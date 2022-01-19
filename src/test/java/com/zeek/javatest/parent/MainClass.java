package com.zeek.javatest.parent;

import org.junit.Test;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by weibo_li on 2017/2/16.
 */
public class MainClass {

    public static void main(String[] args) {
        Teacher3 teacher3 = new Teacher3("zhangsan");
        Teacher3 teacher31 = new Teacher3("zhangsan");

        System.out.println(teacher3);
        System.out.println(teacher31);

        System.out.println(new Random().nextInt(2));

        Set<Teacher3> treeSet = new TreeSet<>();
        treeSet.add(teacher3);
        treeSet.add(teacher31);
        System.out.println(treeSet);
    }

    @Test
    public void treeSet() {
        Teacher3 t1 = new Teacher3("a");
        Teacher3 t2 = new Teacher3("b");
        Teacher3 t3 = new Teacher3("c");

        Set<Teacher3> treeSet = new TreeSet<>();
        treeSet.add(t1);
        treeSet.add(t2);
        treeSet.add(t3);

        for (Teacher3 t : treeSet) {
            System.out.println(t.getName());
        }
    }
}
