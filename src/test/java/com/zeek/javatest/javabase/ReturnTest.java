package com.zeek.javatest.javabase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ReturnTest
 * @Description return执行时机
 * @Author liweibo
 * @Date 2019/8/5 4:21 PM
 * @Version v1.0
 **/
public class ReturnTest {

    public static void main(String[] args) {

        // 为什么输出的还是负值？
        int i = -2147483648;
        int j = -i;
        int q = Math.abs(i);
        System.out.println(i);
        System.out.println(j);
        System.out.println(q);

        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(1);
        path.add(2);
        LinkedList<Integer> path2 = new LinkedList<>();
        path2.add(3);
        path2.add(4);
        // [[1, 2], [3, 4]]
        list.add(path);
        list.add(path2);
        // [[1, 2], [3, 4]]
        list.add(new LinkedList(path));
        list.add(new LinkedList(path2));
        System.out.println(list);

    }

    public static int call() {
        ReturnTest returnTest = new ReturnTest();

        try {
            // 在return之前，会先执行finally代码块中的方法
            return returnTest.returnTest();
        }finally {
            System.out.println("finally");
        }
    }

    public static int returnTest () {
        System.out.println("returnTest");
        return 1;
    }
}
