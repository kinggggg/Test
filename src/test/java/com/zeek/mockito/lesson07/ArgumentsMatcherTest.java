package com.zeek.mockito.lesson07;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

// 下面测试方法中使用的都是静态导入方式, 因此不需要这个注解
//@RunWith(MockitoJUnitRunner.class)
public class ArgumentsMatcherTest {

    @Test
    public void basicTest() throws Exception {
        List<Integer> list = mock(ArrayList.class);

//        when(list.get(0)).thenReturn(100);
        // 和上面等价
        when(list.get(eq(0))).thenReturn(100);
        assertThat(list.get(0), equalTo(100));

        assertThat(list.get(1), equalTo(null));
    }

    /**
     * isA, any
     */
    @Test
    public void testComplex() {
        Foo foo = mock(Foo.class);
        when(foo.function(isA(Parent.class))).thenReturn(100);


        int result = foo.function(new Child1());
        assertThat(result, equalTo(100));
        result = foo.function(new Child2());
        assertThat(result, equalTo(100));
    }

    @Test
    public void testComplex2() {
        Foo foo = mock(Foo.class);
        when(foo.function(isA(Child1.class))).thenReturn(100);

        int result = foo.function(new Child1());
        assertThat(result, equalTo(100));
        result = foo.function(new Child2());
        assertThat(result, equalTo(0));

        reset(foo);
    }

    @Test
    public void testComplex3() {
        Foo foo = mock(Foo.class);

        when(foo.function(any(Child1.class))).thenReturn(100);
        int result = foo.function(new Child2());
        //FIXME 视频中这里是通过的; 但是自己的电脑上这里不通过: actual 0, expect 100
        assertThat(result, equalTo(100));
    }



    static class Foo {
        int function(Parent p) {
            return p.work();
        }
    }

    interface Parent {
        int work();
    }

    class Child1 implements Parent {

        @Override
        public int work() {
            throw new RuntimeException();
        }
    }

    class Child2 implements Parent {

        @Override
        public int work() {
            throw new RuntimeException();
        }
    }

}
