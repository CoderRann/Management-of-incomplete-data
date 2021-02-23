package com.hr.crm.settings.service;

import com.hr.crm.exception.LoginException;
import com.hr.crm.settings.domain.User;

import java.util.List;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
