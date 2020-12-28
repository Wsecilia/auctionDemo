package com.jxfh.auciton.service;

import com.jxfh.auciton.pojo.User;

public interface UserService  {

    /**
     * 登录
     */
    User userLogin(String username, String password);
}
