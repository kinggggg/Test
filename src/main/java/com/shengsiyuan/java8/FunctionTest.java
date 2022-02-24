package com.shengsiyuan.java8;

import java.util.function.Function;

/**
 * @ClassName FunctionTest
 * @Description
 * @Author liweibo
 * @Date 2019/10/15 7:24 PM
 * @Version v1.0
 **/
public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();

        System.out.println(functionTest.compute(1, value -> 2 * value));
    }

    public int compute(int a, Function<Integer, Integer> function) {
        Integer result = function.apply(a);

        return result;
    }
}
