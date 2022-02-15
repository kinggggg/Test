package com.shengsiyuan.java8;

import java.util.List;

/**
 * @ClassName Company
 * @Description
 * @Author liweibo
 * @Date 2019/10/22 4:26 PM
 * @Version v1.0
 **/
public class Company {

    String name;

    List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
