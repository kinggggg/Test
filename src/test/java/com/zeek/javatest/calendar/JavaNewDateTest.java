package com.zeek.javatest.calendar;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * Created by weibo_li on 2017/2/15.
 */
public class JavaNewDateTest {

    @Test
    public void test1() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.get(ChronoField.YEAR));
    }

    @Test
    public void test2() {
        ZoneOffset of = ZoneOffset.of("-05:00");
        LocalDateTime localDateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        LocalDateTime localDateTime1 = localDateTime;
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime1, of);
        System.out.println(offsetDateTime);

    }
}
