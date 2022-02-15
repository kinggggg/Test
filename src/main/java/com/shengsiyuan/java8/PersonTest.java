package com.shengsiyuan.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {

    public static void main(String[] args) {

        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> persons = Arrays.asList(person1, person2, person3);
        List<Person> personResult = PersonTest.getPersonsByUsername("zhangsan", persons);
        personResult.forEach(person -> System.out.println(person.getUsername()));

        System.out.println("===========================");

        personResult = PersonTest.getPersonsByAge(23, persons);
        personResult.forEach(person -> System.out.println(person.getUsername()));

        System.out.println("===========================");

        personResult = PersonTest.getPersonsByAge2(23, persons, (age, personList) -> personList.stream().filter(person -> person.getAge() > 23).collect(Collectors.toList()));
        personResult.forEach(person -> System.out.println(person.getUsername()));


    }

    public static List<Person> getPersonsByUsername(String username, List<Person> persons) {
        return persons.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
    }

    public static List<Person> getPersonsByAge(int age, List<Person> persons) {

        /**
         * 当定义BiFunction时，首先要知道其apply方法使用方式
         * BiFunction的类定义为
         * BiFunction<T, U, R>
         * 其apply方法的签名为
         * R apply(T t, U u);
         * 其中T和U为输入参数，R为返回值！只要明确了这一点，就可以马上定义出BiFunction的泛型类型，
         * 即，第一个泛型类型为Integer（第一个输入参数），第二个泛型类型为List<Person>（第二个输入参数），第三个泛型类型为List<Person>(为返回执行类型)
         */
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) ->
                personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());

        return biFunction.apply(age, persons);
    }

    public static List<Person> getPersonsByAge2(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, persons);
    }
}
