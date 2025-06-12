package com.zeek.javatest.base;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class JavaBaseTest {

    @Test
    public void lru_test() {
        //构建一个阈值为 3 的 LruCache 类
        LruCache<String,Integer> lruCache = new LruCache<>(3);


        lruCache.putValue("老大", 1);
        lruCache.putValue("老二", 2);
        lruCache.putValue("老三", 3);

        lruCache.getValue("老大");

        //超过指定 阈值 3 再次添加元素的 将会删除最近最少访问的节点
        lruCache.putValue("老四", 4);

        System.out.println("lruCache = " + lruCache);
    }

    @Test
    public void linkedHashMap_test() {

        //Map<String, Integer> map = new HashMap<>();
        //Map<String, Integer> map = new LinkedHashMap<>();
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
}
