package com.zeek.javatest.integer;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import com.zeek.javatest.collection.arraylist.Person;

/**
 * Created by weibo_li on 2016/12/28.
 */
public class JavaTest {

    @Test
    public void computeIfAbsent_test() {
        Map<String, HashSet<String>> map1 = new HashMap<>();
        // computeIfAbsent方法：判断Map中是否存在值为fruits的key，若不存在的话，以fruits为key以genValue函数
        // 的返回值value放入到Map中；若Map中之前存在key为fruits的话，直接使用对应的value
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("apple");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("orange");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("pear");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("banana");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("water");
        System.out.println(map1);
    }

    static HashSet<String> genValue(String str) {
        return new HashSet<String>();
    }

    @Test
    public void order() {
        //Map<String, Integer> map = new HashMap<>();
//        Map<String, Integer> map = new LinkedHashMap<>();
        // 使用三个参数的构造法方法来指定 accessOrder 参数的值
        Map<String, Integer> map = new LinkedHashMap<>(10,0.75f,true);


        map.put("老大", 1);
        map.put("老二", 2);
        map.put("老三", 3);
        map.put("老四", 4);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator iter1 = entrySet.iterator();


        while (iter1.hasNext()) {
            Map.Entry entry = (Map.Entry) iter1.next();
            System.out.print("key:  " + entry.getKey() + "   ");
            System.out.println("value:  " + entry.getValue());
        }

        System.out.println("老三的值为：" + map.get("老三"));
        System.out.println("老大的值为：" + map.put("老大",1000));

        Iterator iter2 = entrySet.iterator();
        while (iter2.hasNext()) {
            // 遍历时，需先获取entry，再分别获取key、value
            Map.Entry entry = (Map.Entry) iter2.next();
            System.out.print("key:  " + entry.getKey() + "   ");
            System.out.println("value:  " + entry.getValue());
        }



    }

    @Test
    public void test() {
        Map<String, Map<String, String>> certificationOrganizationCodeMap = new HashMap<>();

        Map<String, String> qiyeJobCodeMap = new HashMap<>();
        qiyeJobCodeMap.put("0101", "法务");
        qiyeJobCodeMap.put("0102", "公司律师");
        qiyeJobCodeMap.put("0103", "高管");
        qiyeJobCodeMap.put("0104", "工作人员");
        certificationOrganizationCodeMap.put("01", qiyeJobCodeMap);

        //法院
        qiyeJobCodeMap = new HashMap<>();
        qiyeJobCodeMap.put("0201", "法官");
        qiyeJobCodeMap.put("0202", "书记员");
        qiyeJobCodeMap.put("0203", "工作人员");
        certificationOrganizationCodeMap.put("02", qiyeJobCodeMap);


    }

    @Test
    public void integer_equals_test() {
        Integer i = 127;
        Integer j = 127;
        if(i==j){
            System.out.println("i==j is equal");
        }else {
            System.out.println("i==j is not equal");
        }
    }


    @Test
    public void getAndUpdate_test() {
        AtomicInteger atomicInteger = new AtomicInteger(20);

//        int i = atomicInteger.addAndGet(5);
//        System.out.println(i);
//
//        int i1 = atomicInteger.accumulateAndGet(20, Integer::max);
//        System.out.println(i1);

        int andUpdate = atomicInteger.getAndUpdate(i -> {
            return 30;
        });
        System.out.println(andUpdate);
        System.out.println(atomicInteger);
    }
}
