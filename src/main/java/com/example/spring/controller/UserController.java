package com.example.spring.controller;

import com.example.spring.bean.User;
import com.example.spring.service.MenuRouterService;
import com.example.spring.service.UserService;
import com.example.spring.utils.JSONResult;
import com.example.spring.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TwinkleDing
 */
@Slf4j
@RestController
@RequestMapping(value = "/auth/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 注册
     *
     * @param user 用户信息
     * @return 注册结果
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JSONResult<Boolean> addUser(@RequestBody User user) {
        System.out.println("注册用户：");
        boolean flag = userService.addUser(user);
        if (flag) {
            return JSONResult.successMsg("注册成功！");
        } else {
            return JSONResult.failedMsg("注册失败，账号可能重复！");
        }
    }

    /**
     * 修改用户
     *
     * @param user 用户信息
     * @return 修改结果
     */
    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    public boolean updateUser(@RequestBody User user) {
        System.out.println("更新数据：");
        return userService.updateUser(user);
    }

    /**
     * 删除用户
     *
     * @param id id
     * @return 删除结果
     */
    @RequestMapping(value = "/userDelete", method = RequestMethod.POST)
    public boolean delete(@RequestParam(value = "id", required = true) int id) {
        System.out.println("删除数据：");
        return userService.deleteUser(id);
    }

    /**
     * 登录
     *
     * @param user 用户信息
     * @return 登录结果
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONResult<String> findByUserName(@RequestBody User user) {
        System.out.println("查询数据：" + user.getUsername());
        String userName = user.getUsername();
        String password = user.getPassword();
        String userId = userService.findUserByNamePassword(userName, password);
        if (userId == null) {
            return JSONResult.failedMsg("登录失败，账号或密码错误！");
        } else {
            Map<String, Object> info = new HashMap<>();
            info.put("username", userName);
            info.put("password", password);
            String token = JwtUtil.sign(userId, info);
            return JSONResult.success(token, "登录成功！");
        }
    }

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @RequestMapping(value = "/userAll", method = RequestMethod.GET)
    public JSONResult<List<User>> findByUserAge() {
        System.out.println("查询所有数据:");
        List<User> list = userService.findAll();
        return JSONResult.successGet(list);
    }
}
