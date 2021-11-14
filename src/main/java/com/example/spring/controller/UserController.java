package com.example.spring.controller;

import com.example.spring.bean.User;
import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        System.out.println("注册用户：");
        return userService.addUser(user);
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
    public User findByUserName(@RequestParam(value = "userName", required = true) String userName, @RequestParam(value = "password", required = true) String password) {
        System.out.println("查询数据：");
        return userService.findUserByName(userName, password);
    }

    @RequestMapping(value = "/userAll", method = RequestMethod.GET)
    public List<User> findByUserAge() {
        System.out.println("查询所有数据:");
        return userService.findAll();
    }
}
