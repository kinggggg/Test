package com.zeek.mockito.common;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.zeek.mockito.quickstart.AccountLoginController;

@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {

    private AccountDao accountDao;

    private HttpServletRequest request;

    private AccountLoginController accountLoginController;

    @Before
    public void setUp() {
        this.accountDao = Mockito.mock(AccountDao.class);
        this.request = Mockito.mock(HttpServletRequest.class);
        this.accountLoginController = new AccountLoginController(accountDao);
    }

    @Test
    public void testLoginSuccess() {
        Account account = new Account();
        when(request.getParameter("username")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);

        assertThat(accountLoginController.login(request), equalTo("/index"));
    }

    @Test
    public void testLoginFailure() {
        when(request.getParameter("username")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("1234561");
        when(accountDao.findAccount(anyString(), anyString())).thenReturn(null);

        assertThat(accountLoginController.login(request), equalTo("/login"));
    }

    @Test
    public void testLogin505() {
        when(request.getParameter("username")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("1234561");
        when(accountDao.findAccount(anyString(), anyString())).thenThrow(UnsupportedOperationException.class);

        assertThat(accountLoginController.login(request), equalTo("/505"));
    }

}
