package com.jxfh.auciton.dao;

import com.jxfh.auciton.pojo.User;

import java.util.List;

public interface UserDao {

    /**
     * 登录
     */
    List<User> userLogin(String username, String password);



}
