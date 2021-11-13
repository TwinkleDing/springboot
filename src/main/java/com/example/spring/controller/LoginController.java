package com.example.spring.controller;


import com.example.spring.bean.UserBean;
import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String userName, String userId) {
        UserBean userBean = userService.loginIn(userName, userId);
        if (userBean != null) {
            return "success";
        } else {
            return "error";
        }
    }
}
