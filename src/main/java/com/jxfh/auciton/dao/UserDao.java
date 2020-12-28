package com.jxfh.auciton.dao;

import com.jxfh.auciton.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 登录
     */
    User userLogin(@Param("username") String username,@Param("password") String password);


    int countUsername(@Param("username") String username);

    int addUser(User user);
}
