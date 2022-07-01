package com.zeek.javatest.calendar;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName CalendarTest
 * @Description TODO
 * @Author weibo_li
 * @Date 2018/9/19 上午9:52
 **/
public class CalendarTest {

    @Test
    public void test01() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date date = new Date();
        System.out.println("当前的时间为：" + sdf.format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MINUTE, -1);
        System.out.println("减去1分钟的时间后: " + sdf.format(calendar.getTime()));

        calendar.add(Calendar.HOUR, 1);
        System.out.println("增加1小时的时间后: " + sdf.format(calendar.getTime()));

        //若增加24小时，日期也自动变化了，非常好
        calendar.add(Calendar.HOUR, 24);
        System.out.println("增加24小时的时间后: " + sdf.format(calendar.getTime()));

    }

    @Test
    public void test02() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.HOUR_OF_DAY, cale.get(Calendar.HOUR_OF_DAY) - 1);
        String nowTime = sdf.format(cale.getTime());
        System.out.println(nowTime);

    }

    @Test
    public void getFormerHour() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cale = null;
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        int day = cale.get(Calendar.DATE);
        int hour = cale.get(Calendar.HOUR_OF_DAY)-1;
        System.out.println(year + "-" + month + "-" + day + " " + hour + ":00:00");
        Date parse = format.parse(year + "-" + month + "-" + day + " " + hour + ":00:00");
        System.out.println(parse);
    }

    @Test
    public void dateSubtractTest() throws ParseException {
        Date date = new Date();
        LocalDate localDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
        System.out.println(localDate.toEpochDay() - LocalDate.now().toEpochDay() + "");
        System.out.println(until(localDate));

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = df.parse("2019-01-01 23:59:59");
        Date date2 = df.parse("2019-01-03 00:00:00");

        long diff = date1.getTime() - date2.getTime();//这样得到的差值是微秒级别
        long days = diff / (1000 * 60 * 60 * 24);
        System.out.println(days);
    }

    @Test
    public void name() throws ParseException {
        int expiringSoonDayCount = -334;//即将过期

        int expiringDayCount = -364;//当天过期

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        String time = sf.format(new Date());
        Date timeNow = sf.parse(time);
        Calendar c = Calendar.getInstance();
        c.setTime(timeNow);
        c.add(Calendar.DAY_OF_MONTH, expiringSoonDayCount);
        String expiringSoonDate = sf.format(c.getTime());
        c.setTime(timeNow);


    }

    long until(LocalDate endDate){
        return LocalDate.now().until(endDate, ChronoUnit.DAYS);
    }
}
