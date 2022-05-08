package com.zeek.mockito.lesson10;

public class DefaultNumberCompare<T extends Number> implements Compare<T>{

    private final boolean great;

    public DefaultNumberCompare(boolean great) {
        this.great = great;
    }

    @Override
    public boolean compare(T expected, T actual) {
        Class<?> clazz = actual.getClass();
        if (clazz == Integer.class) {
            return great ? (Integer) actual > (Integer) expected : (Integer) actual < (Integer) expected;
        } else if (clazz == Short.class) {
            return great ? (Short) actual > (Short) expected : (Short) actual < (Short) expected;
        } else if (clazz == Byte.class) {
            return great ? (Byte) actual > (Byte) expected : (Byte) actual < (Byte) expected;
        } else if (clazz == Double.class) {
            return great ? (Double) actual > (Double) expected : (Double) actual < (Double) expected;
        } else if (clazz == Float.class) {
            return great ? (Float) actual > (Float) expected : (Float) actual < (Float) expected;
        } else if (clazz == Long.class) {
            return great ? (Long) actual > (Long) expected : (Long) actual < (Long) expected;
        } else {
            throw new AssertionError("The number type " + clazz + " not supported");
        }
    }
}
