package com.zeek.mockito.lesson03;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DeepMockTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private Lesson03Service lesson03Service;

    @Mock
    private Lesson03 lesson03;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeepMock() {
//        Lesson03 lesson03 = lesson03Service.get();
//        lesson03.foo(); // 空指针异常. 因为只对Lesson03Service进行了mock

        // 这种方式不简约
//        when(lesson03Service.get()).thenReturn(lesson03);
//        Lesson03 lesson03 = lesson03Service.get();
//        lesson03.foo();

        // 配合 Answers.RETURNS_DEEP_STUBS 可以实现 deep mock
        lesson03Service.get().foo();
    }
}
