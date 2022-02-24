package com.shengsiyuan.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName Test1
 * @Description
 * @Author liweibo
 * @Date 2019/9/27 10:49 AM
 * @Version v1.0
 **/
public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("--------------");

        for (Integer i : list) {
            System.out.println(i);
        }

        System.out.println("--------------");


        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer * 2);
            }
        });

        System.out.println("--------------");

        // 方法引用形式创建函数式接口的实例System.out::println
        list.forEach(System.out::println);

        System.out.println("--------------");


    }
}
