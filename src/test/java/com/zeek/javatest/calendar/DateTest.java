package com.zeek.javatest.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

/**
 * Created by weibo_li on 2017/4/25.
 */
public class DateTest {

    @Test
    public void utcTest() throws ParseException {
        dateToUtc(new Date());
    }

    public void dateToUtc(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat sdfutc = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        TimeZone utc = TimeZone.getTimeZone("UTC");
        sdfutc.setTimeZone(utc);

//        sdfutc.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println("北京时间: " + sdf.format(date));
        System.out.println("北京时间: " + sdf.parse(sdf.format(date)).getTime());
        System.out.println("UTC时间: " + sdfutc.format(date));
        System.out.println("UTC时间: " + sdfutc.parse(sdfutc.format(date)).getTime());
        System.out.println("----------");
        /**
         * Instant.now() 默认是utc时间2024-01-15T07:07:00.082Z
         * Instant.now() 转换成上海时间,带时区信息2024-01-15T15:07:00.082+08:00[Asia/Shanghai]
         * Instant.now() 转换成上海时间,不带时区信息2024-01-15T15:07:00.082
         */
        Instant now = Instant.now();
        System.out.println("Instant.now() 默认是utc时间" + now);
        TimeZone shanghai = TimeZone.getTimeZone("Asia/Shanghai");
        ZonedDateTime zonedDateTimeOfShanghai = now.atZone(shanghai.toZoneId());
        System.out.println("Instant.now() 转换成上海时间,带时区信息" + zonedDateTimeOfShanghai);
        System.out.println("Instant.now() 转换成上海时间,不带时区信息" + zonedDateTimeOfShanghai.toLocalDateTime());

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
    public void test1() {

        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(date1 == date2);
        System.out.println(date1);
        System.out.println("----------1");
        System.out.println();

        LocalDateTime local = LocalDateTime.now();
        System.out.println(local.toLocalDate());
        System.out.println(local.toLocalTime());
        ZoneId zoneId = ZoneId.of("Europe/Rome");
        ZonedDateTime zonedDateTime =  local.atZone(zoneId);
        System.out.println(zonedDateTime);
        System.out.println("----------2");
        System.out.println();

        Instant instant = Instant.now();
        System.out.println(instant.toEpochMilli());
        System.out.println("----------3");
        System.out.println();



    }
}
