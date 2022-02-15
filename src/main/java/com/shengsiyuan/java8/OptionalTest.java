package com.shengsiyuan.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * @ClassName OptionalTest
 * @Description
 * @Date 2019/10/22 4:08 PM
 * @Version v1.0
 **/
public class OptionalTest {

    @Test
    public void orElseThrow() throws Exception {
        Optional<Object> empty = Optional.empty();
        empty.orElseThrow(() -> new RuntimeException("test"));
    }

    @Test
    public void map() {
        Optional<Object> empty = Optional.ofNullable(null);
//        Optional<Object> empty = Optional.empty();
//        Optional<Object> empty = Optional.of("test");
        Optional<String> s1 = empty.map(o -> {
            System.out.println("111");
            return o.toString();
        });
        System.out.println(s1.orElse("empty"));
    }

    @Test
    public void flatMap() throws Exception {
        Optional<String> empty = Optional.of("test");
//        Optional<Object> empty = Optional.empty();
//        Object o = empty.flatMap(str -> str.length()).get();

        Optional<Person1> person = Optional.of(new Person1());
//        Optional<Person1> person = Optional.empty();
//        Optional<Car1> car = Optional.of(new Car1());
        Optional<Car1> car = Optional.empty();
        Optional<Insurance> insurance = nullSafe(person, car);
        System.out.println(insurance.orElse(new Insurance("empty")));
    }

    private Optional<Insurance> nullSafe(Optional<Person1> person, Optional<Car1> car) {
        Optional<Insurance> insurance = person.flatMap(p -> {
                    System.out.println("1111");
                    Optional<Insurance> in = car.map(c -> new Insurance("test"));
                    return in;
                }
        );
        return insurance;
    }


    public static void main(String[] args) {

//        Optional<String> optional = Optional.of("hello");
        Optional<String> optional = Optional.empty();
//        Optional<String> optional = Optional.ofNullable("hello");

        // 虽然可以直接调用get方法，但是如果optional为null的话，直接调用get会抛出异常
        System.out.println(optional.get());

        // 和原来的方式先判断null再使用的方式其实使用一样的，不建议使用
//        if (optional.isPresent()) {
//            System.out.println(optional.get());
//        }

        // 应该使用这种方式使用Optional
        // 当optional中的值存在时才进行值的操作，这里是输出操作
//        optional.ifPresent(item -> System.out.println(item));
//
//        // 当optional中的值不存在时使用其他的值，这里其他的值为world
//        System.out.println(optional.orElse("world"));
//
//        // 当optional中的值不存在时使用提供给orElseGet方法参数的Supplier进行获取
//        System.out.println(optional.orElseGet(() -> "你好"));

    }
}

class Person1 {
    private Optional<Car1> car1;

    public Optional<Car1> getCar1() {
        return car1;
    }

    public void setCar1(Optional<Car1> car1) {
        this.car1 = car1;
    }
}

class Car1 {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}

class Insurance {
    public Insurance() {

    }

    public Insurance(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "name='" + name + '\'' +
                '}';
    }
}
