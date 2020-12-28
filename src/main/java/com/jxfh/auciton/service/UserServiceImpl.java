package com.jxfh.auciton.service;

import com.jxfh.auciton.dao.UserDao;
import com.jxfh.auciton.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User userLogin(String username, String password) {
        User user = userDao.userLogin(username, password);
        return user;
    }

    @Override
    public int addUser(User user) {
        //用户名是否存在 存在的话返回0 及失败
        int countUsername = userDao.countUsername(user.getUsername());
        if (countUsername > 0) {
            return 0;
        }
        //注册用户
        int i = userDao.addUser(user);
        return i;
    }


}
