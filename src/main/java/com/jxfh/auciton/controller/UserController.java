package com.jxfh.auciton.controller;

import com.jxfh.auciton.pojo.RestResult;
import com.jxfh.auciton.pojo.User;
import com.jxfh.auciton.service.UserService;
import com.jxfh.auciton.util.WebUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by pc on 2020/12/28.
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;
    //执行登录
    @RequestMapping(value = "/to_login",method = RequestMethod.POST)
    public RestResult login(@RequestParam(name = "username", required = false) String username, @RequestParam(name =
            "password", required = false) String password, HttpServletRequest request) {
        if(StringUtils.isAnyBlank(username,password)){
            return WebUtils.paramError("参数不能为空");
        }
        User user = userService.userLogin(username, password);
        if(user!=null){
            //request.getSession().setAttribute("userInfo",user);
            return WebUtils.ok(user);
        }
        return WebUtils.paramError("用户名或密码错误");
    }

    //注册用户信息
    @RequestMapping(value = "/add_user",method = RequestMethod.POST)
    public RestResult login(User user) {
        int i=userService.addUser(user);
        return WebUtils.ok(i);
    }
}
