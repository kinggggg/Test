package com.zeek.mockito.lesson10;


import static org.hamcrest.CoreMatchers.both;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SimpleTest {

    @Test
    public void test() {
        assertThat(1, CompareNumber.lt(3));
        assertThat(10, CompareNumber.gt(5));
        assertThat(12, both(CompareNumber.gt(10)).and(CompareNumber.lt(13)));
    }
}
