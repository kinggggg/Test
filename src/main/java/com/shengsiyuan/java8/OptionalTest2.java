package com.shengsiyuan.java8;

import java.util.*;

/**
 * @ClassName OptionalTest2
 * @Description
 * @Author liweibo
 * @Date 2019/10/22 4:28 PM
 * @Version v1.0
 **/
public class OptionalTest2 {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setName("zhangsan");

        Employee employee2 = new Employee();
        employee2.setName("lisi");

        Company company = new Company();
//        Company company = null;
        company.setName("company1");

        List<Employee> employees = Arrays.asList(employee, employee2);
//        company.setEmployees(employees);

        // 样板代码，非常好
        // 如果Optional中的company为null的话返回一个空的List集合
        // 如果company中的employees为null的话，返回一个空的List集合
        // 如果company中的employees不为null的话直接输出
        Optional<Company> optional = Optional.ofNullable(company);
        System.out.println(optional.map(theCompany -> theCompany.getEmployees()).orElse(Collections.emptyList()));


    }

    // Optional通常用于方法的返回值；不建议将Optional用作方法参数是类的属性，因为Optional没有实现序列化接口无法序列化
    public static void test(Optional optional) {

    }
}
