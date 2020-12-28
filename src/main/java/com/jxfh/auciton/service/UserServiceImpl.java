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
        User u= (User) userDao.userLogin(username,password);
        if (u!=null){
            //使用request对象的getSession()获取session
           // HttpSession session = request.getSession();
            //session.setAttribute();
            return u;
        }
        return null;
    }


}
