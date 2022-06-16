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

    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    public JSONResult<Boolean> addUser(@RequestBody User user) {
        System.out.println("注册用户：");
        boolean flag = userService.addUser(user);
        return JSONResult.success(flag);
    }

    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    public boolean updateUser(@RequestBody User user) {
        System.out.println("更新数据：");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/userDelete", method = RequestMethod.POST)
    public boolean delete(@RequestParam(value = "id", required = true) int Id) {
        System.out.println("删除数据：");
        return userService.deleteUser(Id);
    }


    @RequestMapping(value = "/userGet", method = RequestMethod.POST)
    public JSONResult<String> findByUserName(@RequestBody User user) {
        System.out.println("查询数据：" + user.getUsername());
        String userName = user.getUsername();
        String password = user.getPassword();
        String username = userService.findUserByNamePassword(userName, password);
        return JSONResult.success(username);
    }

    @RequestMapping(value = "/userAll", method = RequestMethod.GET)
    public JSONResult<List<User>> findByUserAge() {
        System.out.println("查询所有数据:");
        List<User> list =  userService.findAll();
        return JSONResult.success(list);
    }
}
