package com.me.jdk9;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Java9Tester {
      public static void main(String[] args) {
            System.out.println("Hello World!");

            System.out.println("List.of 工厂方法");
            List.of("a", "b", "c")
                        .forEach(System.out::println);

            System.out.println("Set.of工厂方法");
            Set.of("a", "b", "c")
                        .forEach(System.out::println);

            System.out.println("Map.of工厂方法");
            Map.of("a", 1, "b", 2, "c", 3)
                        .forEach((k, v) -> System.out.println(k + ":" + v));

            Map.ofEntries(Map.entry("a", 1), Map.entry("b", 2), Map.entry("c", 3))
                        .forEach((k, v) -> System.out.println(k + ":" + v));
      }
}