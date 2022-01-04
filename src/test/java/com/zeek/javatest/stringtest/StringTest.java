package com.zeek.javatest.stringtest;

import com.zeek.javatest.parent.Parent;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by weibo_li on 2017/3/20.
 */
public class StringTest {

    @Test
    public void trim() throws InterruptedException {
        String str = " a bc " ;
        String s = trimRight(str);
        System.out.println(s);
    }

    /**
     * 去右空格
     * @param str
     * @return
     */
    public String trimRight(String str) {
        if (str == null || str.equals("")) {
            return str;
        } else {
            return str.replaceAll("[ ]+$", "");
        }
    }

    @Test
    public void arrayTest() {

        String[] str = ".".split("\\.");
        System.out.println(str[0]);

    }

    @Test
    public void stringPoolTest() {

        String str1 = "abc" ;
        String str2 = "abc" ;

        System.out.println(str1 == str2);

        String str3 = new String("def") ;
        String str4 = new String("def") ;
        System.out.println(str3 == str4);

    }

    @Test
    public void test() {

        String str = "用户id,sessionid,自定义1,自定义2,昵称,注册省,注册市,最后登录时间,手机号,注册ip,登录ip,注册ip数,登录ip数,登录sessionid数,用户黑名单,sessionid黑名单,手机号黑名单,ip流量黑名单,手机号蚁盾评分,ip蚁盾评分,同盾手机号&ip评分" ;
        int i = str.indexOf("sessionid,");
        int j = str.indexOf("昵称,");
        String[] split = str.split(",");
        int m = 0;
        int n = 0;
        for (int k = 0; k < split.length; k++) {
            if(split[k].equals("sessionid")) {
                m = k;
            }
            if(split[k].equals("昵称")) {
                n = k;
            }
        }
        System.out.println(m);
        System.out.println(n);



        List<String> strings = Arrays.asList(split);
        List<String> strings1 = strings.subList(m + 1, n);
        System.out.println(strings1);

        System.out.println(i);
        System.out.println(j);
        System.out.println(str.indexOf("昵称,"));
        System.out.println(str.substring(i + "sessionid,".length(), j));
    }

    @Test
    public void nullTest() {
        String str = "26194708,,,,,,,,,,,,,,,,,,,," ;
        String[] split = str.split(",", 50);
        System.out.println(split);
    }

    @Test
    public void joinTest() {
        List<String> strings = Arrays.asList("a", "b");

        System.out.println(StringUtils.join(strings, ","));


    }

    @Test
    public void indexOfTest() {
        String str = "abcdefgh" ;

        System.out.println(str.indexOf("h"));

        System.out.println(str.indexOf("h") + 1);
        System.out.println(str.substring(str.indexOf("h") + 1, str.length()).length());


    }

    @Test
    public void indexOfTest2() {
        String str = "acde" ;
        String keyword = "c" ;
        computingHitResult(str, keyword);
    }

    public String computingHitResult(String str, String keyword) {

        if(str != null && !"".equals(str) && keyword != null && !"".equals(keyword)) {
            int keywordLength = keyword.length();//关键字长度
            StringBuffer result = new StringBuffer();//结果字符串
            StringBuffer leftStr = new StringBuffer();//左侧字符串
            StringBuffer rightStr = new StringBuffer();//右侧字符串
            int leftLength = 0;//左侧长度
            int rightLength = 0;//右侧长度
            int startIndex = str.indexOf(keyword); System.out.println("startIndex:" + startIndex); //关键字开始位置
            int endIndex = startIndex + keywordLength; System.out.println("endIndex:" + endIndex);//关键字结束位置

            leftLength = endIndex; System.out.println("leftLength:" + leftLength);
            rightLength = str.substring(endIndex, str.length()).length(); System.out.println("rightLength:" + rightLength);

            //左侧，右侧均大于25
            if(leftLength > WordCount.AVERAGECOUNT && rightLength > WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(endIndex - WordCount.AVERAGECOUNT, endIndex));
                rightStr.append(str.substring(endIndex, endIndex + WordCount.AVERAGECOUNT));
            }

            //左侧小于25，右侧大于25
            if(leftLength < WordCount.AVERAGECOUNT && rightLength > WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(0, endIndex));
                int lack = WordCount.AVERAGECOUNT - leftStr.length();
                rightStr.append(str.substring(endIndex, Math.min(endIndex + WordCount.AVERAGECOUNT + lack, str.length())));//从右侧补齐字数
            }

            //左侧大于25，右侧小于25
            if(leftLength > WordCount.AVERAGECOUNT && rightLength < WordCount.AVERAGECOUNT) {
                rightStr.append(str.substring(endIndex, str.length()));
                int lack = WordCount.AVERAGECOUNT - rightStr.length();
                leftStr.append(str.substring(Math.max(0, endIndex - WordCount.AVERAGECOUNT - lack), endIndex));//从左侧补齐字数
            }

            //左侧，右侧均小于25
            if(leftLength < WordCount.AVERAGECOUNT && rightLength < WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(0, endIndex));
                rightStr.append(str.substring(endIndex, str.length()));
            }

            //左侧等于25，右侧大于25
            if(leftLength == WordCount.AVERAGECOUNT && rightLength > WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(0, endIndex));
                rightStr.append(str.substring(endIndex, endIndex + WordCount.AVERAGECOUNT));
            }

            //左侧等于25，右侧小于25
            if(leftLength == WordCount.AVERAGECOUNT && rightLength < WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(0, endIndex));
                rightStr.append(str.substring(endIndex, str.length()));
            }

            //左侧大于25，右侧等于25
            if(leftLength > WordCount.AVERAGECOUNT && rightLength == WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(endIndex - WordCount.AVERAGECOUNT, endIndex));
                rightStr.append(str.substring(endIndex, str.length()));
            }

            //左侧小于25，右侧等于25
            if(leftLength < WordCount.AVERAGECOUNT && rightLength == WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(0, endIndex));
                rightStr.append(str.substring(endIndex, str.length()));
            }

            //左侧，右侧均等于25
            if(leftLength == WordCount.AVERAGECOUNT && rightLength == WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(0, endIndex));
                rightStr.append(str.substring(endIndex, str.length()));
            }


            result.append(leftStr).append(rightStr);

            System.out.println("leftStr:" + leftStr);
            System.out.println("rightStr:" + rightStr);
            System.out.println("result:" + result);

        }


        return "" ;
    }

}
