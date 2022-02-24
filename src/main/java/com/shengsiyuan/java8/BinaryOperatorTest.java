package com.shengsiyuan.java8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @ClassName BinaryOperatorTest
 * @Description
 * @Author liweibo
 * @Date 2019/10/17 7:44 PM
 * @Version v1.0
 **/
public class BinaryOperatorTest {

    public static void main(String[] args) {


        BinaryOperator<Integer> binaryOperator1 = (a, b) -> a * b;
        int compute = BinaryOperatorTest.compute(2, 3, binaryOperator1);
        System.out.println(compute);
        System.out.println("==============");

        binaryOperator1 = (a, b) -> a + b;
        compute = BinaryOperatorTest.compute(2, 3, binaryOperator1);
        System.out.println(compute);
        System.out.println("==============");

        Comparator<Integer> comparator = (a, b) -> a - b;
        Integer min = BinaryOperator.minBy(comparator).apply(1, 2);
        System.out.println(min);
        System.out.println("==============");

        min = BinaryOperator.minBy((Integer a, Integer b) -> {

            return a -b ;
        }).apply(1, 2);
        System.out.println(min);
        System.out.println("==============");


        System.out.println("==============");

        System.out.println("==============");

        System.out.println("==============");

        System.out.println("==============");

        System.out.println("==============");

        System.out.println("==============");

        System.out.println("==============");



    }

    public static int compute(int a, int b, BinaryOperator<Integer> binaryOperator) {

        Integer result = binaryOperator.apply(a, b);

        return result;

    }
}
