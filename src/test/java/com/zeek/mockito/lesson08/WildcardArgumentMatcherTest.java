package com.zeek.mockito.lesson08;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WildcardArgumentMatcherTest {

    @Mock
    private SimpleService simpleService;

    @Test
    public void vildcardMethod1() {
        when(simpleService.method1(anyInt(), anyString(), anyCollection(), isA(Serializable.class))).thenReturn(100);
        int result = simpleService.method1(1, "Alex", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(100));

        result = simpleService.method1(1, "Wang", Collections.emptySet(), "MockitoForJava");
        assertThat(result, equalTo(100));
    }

    /**
     * 实现返回的结果与指定一个具体的参数值时有关
     */
    @Test
    public void vildcardMethodWithSpec() {
        // 这行必须要在第一行; 如果放到最后的话, 全部就会走-1; 因为这个wildcard是其他两个vildcard的全集!!
        when(simpleService.method1(anyInt(),  anyString(), anyCollection(), isA(Serializable.class))).thenReturn(-1);
        // 所有的参数必须符合vildcard形式; 因此字符串常量"Alex"是非法的, 必须使用eq方法
        when(simpleService.method1(anyInt(),  eq("Alex"), anyCollection(), isA(Serializable.class))).thenReturn(100);
        when(simpleService.method1(anyInt(), eq("Wang"), anyCollection(), isA(Serializable.class))).thenReturn(200);

        int result = simpleService.method1(1, "Alex", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(100));

        result = simpleService.method1(1, "Wang", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(200));

        result = simpleService.method1(1, "xxx", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(0));
    }

    @Test
    public void vildcardMethod2() {
        doNothing().when(simpleService).method2(anyInt(), anyString(), anyCollection(), isA(Serializable.class));
        List<Object> list = Collections.emptyList();
        simpleService.method2(1, "Alex", list, "Mockito");
        // 这样测试用的不是同一个List
//        verify(simpleService, times(1)).method2(1, "Alex", Collections.emptyList(), "Mockito");
        verify(simpleService, times(1)).method2(1, "Alex", list, "Mockito");
        // verify时同样需要遵循所有的参数都要符合vildcard形式, 即, 要用eq方法
        verify(simpleService, times(1)).method2(anyInt(), eq("Wang"), anyCollection(), isA(Serializable.class));
    }

    @After
    public void destroy() {
        reset(simpleService);
    }

}
