package com.zeek.javatest.calendar;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * @ClassName JavaTest
 * @Description Java基础知识测试
 * @Author weibo_li
 * @Date 2018/9/19 上午9:52
 **/
public class JavaTest {

    @Test
    public void getAndUpdate_test() {
        AtomicInteger atomicInteger = new AtomicInteger(20);

        int i = atomicInteger.addAndGet(5);
        System.out.println(i);

        int i1 = atomicInteger.accumulateAndGet(40, Integer::max);
        System.out.println(i1);

        int andUpdate = atomicInteger.getAndUpdate(iii -> {
            return 30;
        });
        System.out.println(andUpdate);
        System.out.println(atomicInteger);
    }

    @Test
    public void integer_equals_test() {
        Integer i = 127;
        Integer j = 127;
        if (i == j) {
            // JVM初始化时整形的常量池范围为 -128~127，
            // 因此在这个范围内的整形包装类值的引用都是同一个
            System.out.println("i==j is equal");
        } else {
            System.out.println("i==j is not equal");
        }

        Integer ii = 128;
        Integer jj = 128;
        if (ii == jj) {
            // 不在 -128~127范围内的整形包装类值的引用不是同一个
            System.out.println("ii==jj is equal");
        } else {
            System.out.println("ii==jj is not equal");
        }
    }

    /**
     * computeIfAbsent方法：判断Map中是否存在值为fruits的key，若不存在的话，以fruits为key以genValue函数
     * 的返回值value放入到Map中；若Map中之前存在key为fruits的话，直接使用对应的value
     */
    @Test
    public void computeIfAbsent_test() {
        Map<String, HashSet<String>> map1 = new HashMap<>();
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

    /**
     * 字符串比较 常量池内容
     * <p>
     * String s1 = "a"; String s2 = s1 + "b";
     * <p>
     * 这里s1是一个字符串常量，而s2是通过将s1与另一个字符串常量"b"拼接而成的。由于字符串是不可变的，Java在拼接字符串时会创建一个新的字符串对象，即"ab"。此时，s2引用的是新创建的字符串对象。
     * <p>
     * 当你使用==比较两个对象时，它比较的是对象的引用地址，而不是对象的内容。因此，s2 == "ab"比较的是s2引用的对象和字符串常量池中的"ab"对象是否是同一个对象，由于s2是通过拼接生成的新对象，所以比较结果为false。
     * <p>
     * String s3 = "a" + "b";
     * <p>
     * 在这里，"a" + "b"的拼接在编译时会被优化成一个字符串常量"ab"。因此，s3引用的是字符串常量池中的"ab"对象。
     * <p>
     * 当你使用==比较s3和"ab"时，由于s3引用的是字符串常量池中的"ab"，比较结果为true。因为在编译时，字符串常量的拼接结果会被优化并直接放入常量池，而不是在运行时进行拼接。
     * <p>
     * 总的来说，第一个值为false是因为s2引用的是通过拼接生成的新对象，而第二个值为true是因为s3引用的是编译时优化的字符串常量。
     */
    @Test
    public void string_compare_instant_pool() {
        String s1 = "a";
        String s2 = s1 + "b";
        String s3 = "a" + "b";
        System.out.println(s2 == "ab");//false
        System.out.println(s3 == "ab");//true
    }

    @Test
    public void random_test() {
        SecureRandom random = new SecureRandom();
        int value = random.nextInt(5) + 1;
        System.out.println(value);

        // 生成1-5之间的随机数
        int random1 = RandomUtils.nextInt(0, 5) + 1;
        System.out.println(random1);
    }

    @Test
    public void date_test_01() throws Exception {

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
    public void date_test_02() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.HOUR_OF_DAY, cale.get(Calendar.HOUR_OF_DAY) - 1);
        String nowTime = sdf.format(cale.getTime());
        System.out.println(nowTime);

    }

    @Test
    public void getFormerHour() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cale = null;
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        int day = cale.get(Calendar.DATE);
        int hour = cale.get(Calendar.HOUR_OF_DAY) - 1;
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

    long until(LocalDate endDate) {
        return LocalDate.now().until(endDate, ChronoUnit.DAYS);
    }
}
