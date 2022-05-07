package com.zeek.mockito.lesson03;

import static org.mockito.Mockito.mock;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.zeek.mockito.common.Account;
import com.zeek.mockito.common.AccountDao;

public class MockByRuleTest {

    @Rule
    // todo 什么意思???
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private AccountDao accountDao;

    @Test
    public void testMock() {
//        AccountDao accountDao = mock(AccountDao.class);
        Account account = accountDao.findAccount("x", "x");
        System.out.println(account);
    }
}
