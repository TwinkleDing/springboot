package com.example.spring.service;

import com.example.spring.bean.User;

import java.util.List;

/**
 * @author TwinkleDing
 */
public interface UserService {

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return 是否添加成功
     */
    boolean addUser(User user);

    /**
     * 修改用户
     *
     * @param user 用户信息
     * @return 是否修改成功
     */
    boolean updateUser(User user);


    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 是否删除成功
     */
    boolean deleteUser(int id);

    /**
     * 根据名字查询用户信息
     *
     * @param userName 用户名称
     * @return 用户名称
     */
    String findUserByName(String userName);

    /**
     * 查询名字和密码是否正确
     *
     * @param userName 用户名称
     * @param password 密码
     * @return 用户名称
     */
    String findUserByNamePassword(String userName, String password);


    /**
     * 查询所有数据
     *
     * @return 用户列表
     */
    List<User> findAll();
}
