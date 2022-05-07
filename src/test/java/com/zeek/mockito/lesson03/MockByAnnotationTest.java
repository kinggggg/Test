package com.zeek.mockito.lesson03;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.zeek.mockito.common.Account;
import com.zeek.mockito.common.AccountDao;

public class MockByAnnotationTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AccountDao accountDao;

    @Test
    public void testMock() {
        Account account = accountDao.findAccount("x", "x");
        System.out.println(account);
    }
}
