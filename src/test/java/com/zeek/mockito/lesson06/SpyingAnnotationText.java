package com.zeek.mockito.lesson06;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class SpyingAnnotationText {

    @Spy
    private List<String> list = new ArrayList<>();

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSpy() throws Exception {
        List<String> realList = new ArrayList<>();
        List<String> list = spy(realList);

        list.add("Mockito");
        list.add("PowerMock");

        assertThat(list.get(0), equalTo("Mockito"));
        assertThat(list.get(1), equalTo("PowerMock"));
        assertThat(list.isEmpty(), equalTo(false));

        // 只有指定了stubbing后对应的方法才会被mock, 其他的方式调用均是真实的调用
        when(list.isEmpty()).thenReturn(true);
        when(list.size()).thenReturn(0);

        assertThat(list.get(0), equalTo("Mockito"));
        assertThat(list.get(1), equalTo("PowerMock"));
        assertThat(list.isEmpty(), equalTo(true));
        assertThat(list.size(), equalTo(0));

    }
}
