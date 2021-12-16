package com.zeek.javatest.javabase.innerclass;

import java.util.List;

import org.junit.Test;

public class JavaBaseTest {

    @Test
    public void instanceofTest(){
        
        Person person = new Person();
        // System.out.println(person instanceof String);
        // List list = (List)person;
        System.out.println(person instanceof List);
    }
    
}

class Person {

}
