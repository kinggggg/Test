package com.shengsiyuan.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @ClassName StreamTest
 * @Description
 * @Author liweibo
 * @Date 2019/10/24 7:15 PM
 * @Version v1.0
 **/
public class StreamTest {

    /**
     * 通过stream去重. String类实现了hashCode和equals方法
     */
    @Test
    public void test6() {

        CatFlatMap cat1 = new CatFlatMap("cat1", 20);
        NickName nickName = new NickName();
        nickName.getNames().add("cat1-name1");
        nickName.getNames().add("cat1-name2");
        cat1.setNickName(nickName);

        CatFlatMap cat2 = new CatFlatMap("cat1", 20);
        NickName nickName2 = new NickName();
        nickName2.getNames().add("cat1-name1");
        nickName2.getNames().add("cat2-name2");
        cat2.setNickName(nickName2);

        List<CatFlatMap> catFlatMaps = new ArrayList<>();
        catFlatMaps.add(cat1);
        catFlatMaps.add(cat2);

        List<List<String>> collect = catFlatMaps.stream().flatMap(catFlatMap -> Stream.of(catFlatMap.getNickName().getNames())).distinct().collect(Collectors.toList());
        List<String> collect1 = catFlatMaps.stream().flatMap(catFlatMap -> catFlatMap.getNickName().getNames().stream()).distinct().collect(Collectors.toList());
        System.out.println(collect1);


    }

    @Test
    public void test5() {
        List<Integer> strings1 = Arrays.asList("ab", "bc", "dc").stream().map(ele -> ele.length()).collect(Collectors.toList());
        strings1.forEach(System.out::println);

        System.out.println("=======");

        List<String> strings2 = Arrays.asList("ab", "abc", "bcd");
        // 第三个参数是覆盖规则: 当转换为map的时候如果存在相同的key话, key对应的value应该用哪个? 其中oldValue是先根据这个key获取的值, newValue是后根据这个key获取的值
        Map<Integer, String> toMap = strings2.stream().collect(Collectors.toMap(e -> e.length(), ele -> ele, (oldVal, newVal) -> oldVal));
        System.out.println(toMap);

        System.out.println("=======");

        List<String> strings3 = Arrays.asList("ab", "bc", "bc");
        // 按照元素本身(Function.identity())先分组, 然后将分组后每组的结果转换成List
        Map<String, List<String>> groupByToList = strings3.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.toList()));
        System.out.println(groupByToList);

        System.out.println("=======");

        List<String> strings4 = Arrays.asList("ab", "bc", "bc");
        // 按照元素本身(Function.identity())先分组, 然后将分组后的每组的元素进行比较获取最小的
        Map<String, Optional<String>> groupByMinBy = strings4.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.minBy((one, two) -> one.compareTo(two))));
        System.out.println(groupByMinBy);


    }

    @Test
    public void test4() {
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        stream.findFirst().ifPresent(System.out::println);

//        Stream.iterate(1, i -> i + 2).limit(6).forEach(System.out::println);
//
//        System.out.println("=============");
//
//        Stream.iterate(1, i -> i + 2)
//                .limit(6).filter(i -> i > 2)
//                .map(i -> i * 2)
//                .skip(4)
//                .reduce((one, two) -> one + two)
//                .ifPresent(System.out::println);
//
//        IntSummaryStatistics intSummaryStatistics = Stream.iterate(1, i -> i + 2)
//                .filter(i -> i > 2)
//                .mapToInt(item -> item * 2)
//                .summaryStatistics();
//        System.out.println(intSummaryStatistics.getMin());
//        System.out.println(intSummaryStatistics.getMax());
//        System.out.println(intSummaryStatistics.getAverage());
//        System.out.println(intSummaryStatistics.getCount());

        // 流类似打开文件一样，不能重复操作
//        Stream<Integer> stream = Stream.of(1, 3, 5);
//        System.out.println(stream.filter(i -> i > 2));
//        System.out.println(stream.findFirst());
    }

    @Test
    public void test3() {
        List<String> list = Arrays.asList("hello", "world", "helloworld");
//        list.stream().map(item -> item.toUpperCase()).forEach(System.out::println);
//        list.stream().map(String::toUpperCase).forEach(System.out::println);

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));

        stream.flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);
    }

    @Test
    public void test2() {
        Stream<String> stream = Stream.of("hello", "world", "helloworld");

        //lambda形式参数
//        String[] stringArray = stream.toArray(length -> new String[length]);
//        Arrays.asList(stringArray).forEach(System.out::println);
        // 方法引用形式参数
//        String[] stringArray = stream.toArray(String[]::new);
//        Arrays.asList(stringArray).forEach(System.out::println);

        // 使用JDK提供的方法
//        List<String> list = stream.collect(Collectors.toList());
        // 手动传递参数
//        List<String> list = stream.collect(() -> new ArrayList(), (theList, item) -> theList.add(item), (theList1, thelist2) -> theList1.addAll(thelist2));
        // 使用方法引用传递参数
//        List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        list.forEach(System.out::println);

        // 使用Collectors.toCollection就更加灵活，可以转换成任意的集合
//        转换成ArrayList
//        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
//        list.forEach(System.out::println);
//        转换成LinkedList
//        LinkedList<String> linkedList = stream.collect(Collectors.toCollection(LinkedList::new));
//        linkedList.forEach(System.out::println);
//        转换成HashSet
//        Collection<String> hashSet = stream.collect(Collectors.toCollection(HashSet::new));
//        hashSet.forEach(System.out::println);

//        String joining = stream.collect(Collectors.joining());
//        System.out.println(joining);
    }

    @Test
    public void test1() {
        Stream<String> stream1 = Stream.of("hello", "world", "hello world");

        String[] myArray = new String[]{"hello", "world", "hello world"};
        Stream<String> stream2 = Stream.of(myArray);

        Stream<String> stream3 = Arrays.stream(myArray);

        List<String> list =
                Arrays.asList(myArray);
        Stream<String> stream = list.stream();

        IntStream.of(new int[]{5, 6, 7}).forEach(System.out::println);

        System.out.println("==================");
        IntStream.range(3, 8).forEach(System.out::println);

        System.out.println("==================");

        IntStream.rangeClosed(3, 8).forEach(System.out::println);

        System.out.println("==================");

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(list1.stream().map(item -> item * 2).reduce(0, Integer::sum));

        System.out.println("==================");

        System.out.println("==================");

        System.out.println("==================");

        System.out.println("==================");

        System.out.println("==================");

        System.out.println("==================");

        boolean b = Arrays.asList("a", "cc").stream().anyMatch(ele -> ele.equals("c"));
        System.out.println(b);
    }
}
