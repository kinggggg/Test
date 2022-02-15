package com.shengsiyuan.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateTest2.conditionFilter(list, item -> item % 2 == 0);
        System.out.println("===================");
        PredicateTest2.conditionFilter(list, item -> true);
        System.out.println("===================");
        PredicateTest2.conditionFilter2(list, item -> item > 5, item -> item % 2 == 0);

        String test = null;
        if ("test".equals(test)) {
            System.out.println("test is null");
        }

        System.out.println("===================");
        boolean result = PredicateTest2.isEqual("test").test("test");
        System.out.println(result);




    }

    public static void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(item -> predicate.test(item)).forEach(integer -> System.out.println(integer));
    }

    public static void conditionFilter2(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        // 注意negate方法的调用： predicate1.and(predicate2)的返回值是一个Predicate，并且其实现test方法逻辑为(t) -> test(t) && other.test(t)，当
        // 调用了negate方法后，negate方法返回值也为Predicate，但是其实现的test方法的逻辑为!test(t)，其实际上为!(test(t) && other.test(t))
        list.stream().filter(item -> predicate1.and(predicate2).negate().test(item)).forEach(integer -> System.out.println(integer));
    }

    public static Predicate<String> isEqual(Object object) {
        return Predicate.isEqual(object);
    }


}
