package com.zeek.mockito.lesson10;

public interface Compare<T extends Number> {

    boolean compare(T expected, T actual);
}
