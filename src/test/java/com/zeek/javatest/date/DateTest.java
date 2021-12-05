package com.zeek.javatest.date;

import com.google.common.base.Stopwatch;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by weibo_li on 2017/4/25.
 */
public class DateTest {

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
    public void stopWatch() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();

        System.out.println("11111");
        Thread.sleep(1000);
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));

        System.out.println("22222");
        Thread.sleep(2000);
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));
        stopwatch.stop();

    }

    @Test
    public void md5Test() {
        Set<Integer> ids = new HashSet<>();
        ids.add(12);
        ids.add(10);
        ids.add(13);
        List<Integer> collect = ids.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        String raw = StringUtils.join(collect, ",");
        String r = DigestUtils.md5Hex(raw);
        System.out.println(r.length());
        System.out.println(r);
    }

    @Test
    public void sort() {
        Set<Integer> ids = new HashSet<>();
        ids.add(12);
        ids.add(10);
        ids.add(13);
        List<Integer> collect = ids.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(StringUtils.join(collect, ","));
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
