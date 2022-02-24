package com.shengsiyuan.java8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @ClassName FunctionTest
 * @Description
 * @Author liweibo
 * @Date 2019/10/15 7:24 PM
 * @Version v1.0
 **/
public class FunctionTest2 {

    public static void main(String[] args) {

        FunctionTest2 test = new FunctionTest2();

        System.out.println(test.compute(2, value -> value * 3, value -> value * value));

        System.out.println(test.compute2(2, value -> value * 3, value -> value * value));

        System.out.println(test.compute3(2,3, (t,u) -> t + u));

        System.out.println(test.compute4(2, 3, (t, u) -> t * u, t -> t + 2));

    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {

        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {

        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a , int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    public int compute4(int a , int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}
