package com.zeek.mockito.lesson09;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class AssertMatcherTest {

    @Test
    public void test() {
        int i = 10;
        // 旧的写法, 已经不推荐了
        Assert.assertEquals(i, 10);

        assertThat(i, equalTo(10));
        assertThat(i, not(equalTo(20)));
        assertThat(i, is(10));
        assertThat(i, is(not(20)));
    }

    @Test
    public void test2() {
        double price = 23.45;
        assertThat(price, either(equalTo(23.45)).or(equalTo(23.54)));
        assertThat(price, both(equalTo(23.45)).and(not(equalTo(23.54))));

        assertThat(price, anyOf(is(23.45), is(23.23)));

        assertThat(Stream.of(1, 2, 3).anyMatch(i -> i > 2), equalTo(true));
    }

    @Test
    public void test3() {
        double price = 23.45;
        assertThat("失败的信息提示" , price, either(equalTo(1.0)).or(equalTo(2.0)));
    }
}
