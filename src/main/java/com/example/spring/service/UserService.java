package com.example.spring.service;

import com.example.spring.bean.User;

import java.util.List;

public interface UserService {
    /**
     * 新增用户
     *
     */
    boolean addUser(User user);

    /**
     * 修改用户
     *
     */
    boolean updateUser(User user);


    /**
     * 删除用户
     *
     */
    boolean deleteUser(int id);

    /**
     * 根据名字查询用户信息
     *
     */
    String findUserByName(String userName);

    /**
     * 查询名字和密码是否正确
     *
     */
    String findUserByNamePassword(String userName, String password);


    /**
     * 查询所有数据
     *
     */
    List<User> findAll();
}
