package com.zeek.mockito.lesson08;

import java.io.Serializable;
import java.util.Collection;

public class SimpleService {

    public int method1(int i, String str, Collection<?> coll, Serializable serializable) {
        throw new RuntimeException();
    }

    public void method2(int i, String str, Collection<?> coll, Serializable serializable) {
        throw new RuntimeException();
    }
}
