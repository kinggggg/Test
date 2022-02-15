package com.shengsiyuan.java8.methodreference;

import com.google.gson.Gson;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName MethodReferenceTest
 * @Description
 * @Author liweibo
 * @Date 2019/10/24 10:40 AM
 * @Version v1.0
 **/
public class MethodReferenceTest {

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 50);
        Student student4 = new Student("zhaoliu", 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        students.sort((studentParam1, studentParam2) ->
                        Student.compareStudentByScore(studentParam1, studentParam2));
//        students.forEach(student -> System.out.println(student.getScore()));

        // 静态方法引用
//        students.sort(Student::compareStudentByScore);
//        students.forEach(student -> System.out.println(student.getScore()));

//        StudentComparator studentComparator = new StudentComparator();
//        students.sort((studentParam1, studentParam2) -> studentComparator.compareStudentByscore(studentParam1, studentParam2));
//        students.forEach(student -> System.out.println(student.getScore()));

//        students.sort(studentComparator::compareStudentByscore);
//        students.forEach(student -> System.out.println(student.getScore()));

//        students.sort(Student::compareByScore);
//        students.forEach(student -> System.out.println(student.getScore()));

        List<String> cities = Arrays.asList("qingdao", "chongqing", "tianjin", "beijing");
//        Collections.sort(cities, (city1, city2) -> city1.compareTo(city2));
//        cities.forEach(city -> System.out.println(city));
        Collections.sort(cities, String::compareToIgnoreCase);
        cities.forEach(System.out::println);

        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        // 其实举的这个例子不是很好。因为Supplier中的T get();方法不接受参数只有返回值；
        // 而字符串空参数的构造方法new String()比较特殊，也是没有参数，但是其有返回值，返回值就是为新new出来的字符串
        System.out.println(methodReferenceTest.getString(String::new));

        System.out.println(methodReferenceTest.getString2("hello", String::new));

        Student student5 = new Student("name1", 11, true);
        Student student6 = new Student("name1", 11, false);
        List<Student> collect = Stream.of(student5, student6).filter(Student::isSex).collect(Collectors.toList());
        System.out.println(collect);

        Random random = new Random();
        int i = random.nextInt(1);
        System.out.println(i);
        OptionalInt first = random.ints(8, 11).findFirst();
        System.out.println(first.getAsInt());

        Map<String, Object> map = new HashMap<>();
        map.put("name", new Object());
        map.put("name1", new Object());
        System.out.println(map);
        System.out.println(new Gson().toJson(map));
    }
}
