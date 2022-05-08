package com.zeek.mockito.lesson10;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;

/**
 * 自定义Matcher
 */
public class CompareNumber<T extends Number> extends BaseMatcher<T> {

    private final T value;

    private final Compare<T> COMPARE;

    public CompareNumber(T value, boolean great) {
        this.value = value;
        COMPARE = new DefaultNumberCompare<>(great);
    }

    @Override
    public boolean matches(Object actual) {
        return COMPARE.compare(value, (T) actual);
    }

    @Factory
    public static <T extends Number> CompareNumber<T> gt(T value) {
        return new CompareNumber<>(value, true);
    }

    @Factory
    public static <T extends Number> CompareNumber<T> lt(T value) {
        return new CompareNumber<>(value, false);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("compare two number failed");
    }
}
