package com.zeek.javatest.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by weibo_li on 2017/4/25.
 */
public class DateTest {

    @Test
    public void md5Test() {

    }

    @Test
    public void DateTest() throws ParseException {
        Long now = System.currentTimeMillis();
        long preValue = 3;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault());
        LocalDateTime beforeDays = localDateTime.plusDays(-preValue);
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 格式化的日期字符串,类似 2021-06-30
        String onlyDate = ftf.format(beforeDays);
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDateTimeString = onlyDate + " " + "00:00:00";
        long startTime = dateTimeFormat.parse(startDateTimeString).getTime();
        System.out.println("startTime= " + startTime);
        String endDateTimeString = onlyDate + " " + "23:59:59";
        long endTime = dateTimeFormat.parse(endDateTimeString).getTime();
        System.out.println("endTime= " + endTime);
    }

    @Test
    public void test4() {

        System.out.println(LocalDateTime.now());

    }

    @Test
    public void test3() {
        System.out.println(System.currentTimeMillis());
        System.out.println(this.parseTimeStamp2DateString(System.currentTimeMillis()));
    }

    public String parseTimeStamp2DateString(long timeStamp) {
        SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String result;
        try {
            result = format.format(timeStamp);
        } catch (Exception e) {
            return "" ;
        }

        return result;
    }

    @Test
    public void test2() {

        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test1() {

        Date date1 = new Date();
        Date date2 = new Date();



        System.out.println(date1 == date2);
    }
}
