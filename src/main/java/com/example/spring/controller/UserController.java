package com.example.spring.controller;

import com.example.spring.bean.User;
import com.example.spring.service.UserService;
import com.example.spring.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public JSONResult<Boolean> addUser(@RequestBody User user) {
        System.out.println("注册用户：");
        boolean flag = userService.addUser(user);
        if (flag) {
            return JSONResult.successMsg("注册成功！");
        } else {
            return JSONResult.failedMsg("注册失败，账号可能重复！");
        }
    }

    @RequestMapping(value = "/api/userUpdate", method = RequestMethod.POST)
    public boolean updateUser(@RequestBody User user) {
        System.out.println("更新数据：");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/api/userDelete", method = RequestMethod.POST)
    public boolean delete(@RequestParam(value = "id", required = true) int Id) {
        System.out.println("删除数据：");
        return userService.deleteUser(Id);
    }


    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public JSONResult<String> findByUserName(@RequestBody User user) {
        System.out.println("查询数据：" + user.getUsername());
        String userName = user.getUsername();
        String password = user.getPassword();
        String hasUserName = userService.findUserByNamePassword(userName, password);
        if (hasUserName == null) {
            return JSONResult.failedMsg("登录失败，账号或密码错误！");
        } else {
            return JSONResult.success(hasUserName, "登录成功！");
        }
    }

    @RequestMapping(value = "/api/userAll", method = RequestMethod.GET)
    public JSONResult<List<User>> findByUserAge() {
        System.out.println("查询所有数据:");
        List<User> list = userService.findAll();
        return JSONResult.success(list);
    }
}
