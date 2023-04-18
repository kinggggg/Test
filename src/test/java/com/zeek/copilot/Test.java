package com.zeek.copilot;

public class Test {

    public static void main(String[] args) {
        // 写一个匹配ip地址的正则表达式
        String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
        // 测试这个正则表达式是否正确
        String ip = "300.1.1.1";
        System.out.println(ip.matches(regex));
    }


}
