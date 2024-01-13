package com.zeek.javatest.collection.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.zeek.javatest.domain.User;

/**
 * Created by weibo_li on 2017/4/25.
 */
public class ArrayListTest {

    @Test
    public void removeAllTest() {
        List<String> list1 = new ArrayList<>();
        list1.add("https://pic3.58cdn.com.cn/p1/big/n_v27f82a9ee3c1b43849d6422187d4c593b.jpg");
        list1.add("https://pic3.58cdn.com.cn/p1/big/n_v27f82a9ee3c1b43849d6422187d4c593b.jpg2");


        List<String> list2 = Arrays.asList("https://pic3.58cdn.com.cn/p1/big/n_v27f82a9ee3c1b43849d6422187d4c593b.jpg2");

        list1.removeAll(list2);
        System.out.println(list1);
    }

    @Test
    public void name() {
        String url = "http://www.baidu.com/atc?test=a";
        Pattern pattern = Pattern.compile("http.*?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\\.?");
        Matcher matcher = pattern.matcher(url);
        String s = matcher.replaceFirst("");
        System.out.println(s);

    }

    @Test
    public void removeTest2() {
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);

        Iterator<Integer> it = integers.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            System.out.println(next);
            integers.add(3, 3);
        }
    }

    @Test
    public void removeTest() {
        List<Integer> integers = new ArrayList<>();
        integers.remove(-1);

    }

    // 数组拷贝: 如果数组中是对象的话, 数组拷贝的也是数组中对象的引用
    @Test
    public void copyTest2() {

        int[] source = new int[2];
        source[0] = 1;
        source[1] = 2;

        int[] target;
        target = Arrays.copyOf(source, 2);
        target[0]=3;

        System.out.println(source[0]);

    }

    @Test
    public void copyTest() {
        Person p1 = new Person(10, "tom");
        Person p2 = new Person(20, "jerry");
        Person[] source = new Person[2];
        source[0] = p1;
        source[1] = p2;

        Person[] target;
        target = Arrays.copyOf(source, 2);
        target[0].setAge(30);

        System.out.println(source[0].getAge());

    }

    @Test
    public void sizeTest() throws Exception {

        List<String> list = new ArrayList<>(20);
        list.add("a");

        System.out.println(list.size());

        String[] strs = {"a", "b"};
        System.out.println(strs.length);

        String[] strs2 = new String[9];
        strs2[0] = "a" ;
        strs2[1] = "b" ;
        System.out.println(strs2.length);

    }

    /**
     * @Description: ArrayList面试
     * @Author: liweibo
     * @Date: 2018/11/2 下午1:57
     * @Version: v1.0
     *
     * @Param
     *
     * @Return: void
     **/
    @Test
    public void test9() throws Exception {

        List<String> list = new ArrayList<>();
        list.add("a");

        list.forEach(e -> {
            System.out.println(e);
        });

        list.remove(0);

        List<String> strings = Collections.synchronizedList(list);


    }

    @Test
    public void test8() throws Exception {

        String ip = "127.0.0.1" ;
        System.out.println(ip.hashCode());

    }

    @Test
    public void test7() throws Exception {

        double f = 2.0;

        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("k1", "v1"));
        System.out.println(map.put("k1", "v1"));

    }

    @Test
    public void test6() throws Exception {

        //静态初始化数组
        String[] array1 = new String[] {
                "a",
                "b"
        };
        printArray(array1);

        //动态初始化数组
        String[] array2 = new String[2];
        printArray(array2);

        String[] array3;
//        System.out.println(array3);

        //静态初始化与动态初始化不能混合使用
//        String[] array3 = new String[5] {
//
//        };

        Integer i;
        // FIXME: 2018/3/7 编译错误，i没有初始化；通过Person对象的方式不用显示初始化，为什么？
//        System.out.println(i);

        System.out.println("------------------");
        Person person = new Person();
//        System.out.println(person.age);




    }

    @Test
    public void test5() {
        String[] arrays = new String[] { "1", "2", "3" };
        List<String> list = Arrays.asList(arrays);
        System.out.println(list);
        System.out.println(list.getClass());
        List<String> list2 = new ArrayList<String>(list);
        list2.add(0, "0");
        System.out.println(list2);
        System.out.println(list.getClass());
    }

    @Test
    public void test4() {
        List<String> lists = new ArrayList();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");
        lists.add("5");

        List<String> rems = new ArrayList();
        rems.add("1");
        rems.add("2");
        rems.add("5");

        lists.removeAll(rems);
        System.out.println(lists);
    }

    @Test
    public void test3() {
        List<User> usersList = new ArrayList<>();
        User one = new User("1", "张三");
        usersList.add(one) ;
        usersList.add(one) ;
        usersList.add(one) ;
        usersList.add(new User("2", "lisi")) ;

        usersList.stream().forEach(user -> {
            System.out.println(user.toString());
        });

        System.out.println("=======================");

        Set<User> usersSet = new HashSet<>();
        usersSet.addAll(usersList);
        usersList.clear();
        usersList.addAll(usersSet);

        usersList.stream().forEach(user -> {
            System.out.println(user.toString());
        });




    }

    @Test
    public void test2() {
        List<User> users = new ArrayList<>();
        User one = new User("1", "zhangsan");
        users.add(one) ;
        users.add(new User("2", "lisi")) ;

        List<User> users1 = users.subList(0, 1);
        users1.stream().forEach(user -> {
            user.setId("3");
            System.out.println(user.toString());
        });

        users1.clear();

        System.out.println("=======================");

        users.stream().forEach(user -> {
            System.out.println(user.toString());
        });


    }

    @Test
    public void test1() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");

        strings.add(3, "3");

        System.out.println(strings);
    }

    private void printArray(String[] array) {
        if (array == null) {
            System.out.println("array is null");
        }else {
            Arrays.stream(array).forEach(element -> {
                System.out.println(element);
            });
        }
    }
}
