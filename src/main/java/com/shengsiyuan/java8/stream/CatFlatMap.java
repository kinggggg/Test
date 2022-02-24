package com.shengsiyuan.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2021-02-01
 */
public class CatFlatMap {

    public CatFlatMap(){}

    public CatFlatMap(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private Integer age;

    private NickName nickName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public NickName getNickName() {
        return nickName;
    }

    public void setNickName(NickName nickName) {
        this.nickName = nickName;
    }
}

class NickName {
    private List<String> names = new ArrayList<>();

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
