package com.zeek.mockito.quickstart;

import javax.servlet.http.HttpServletRequest;

import com.zeek.mockito.common.Account;
import com.zeek.mockito.common.AccountDao;

public class AccountLoginController {

    private final AccountDao accountDao;

    public AccountLoginController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String login(HttpServletRequest request) {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        try {
            Account account = accountDao.findAccount(username, password);
            if (account == null) {
                return "/login";
            } else {
                return "/index";
            }
        }catch (Exception e) {
            return "/505";
        }
    }
}
