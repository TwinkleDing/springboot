package com.example.spring.dao;


import com.example.spring.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author TwinkleDing
 */
@Mapper
public interface UserDao {

    /**
     * 新增数据
     *
     * @param user 新注册的用户信息
     */
    @Insert("INSERT INTO user(password,username,id) VALUES (#{password},#{username},#{id})")
    void addUser(User user);

    /**
     * 修改数据
     *
     * @param user 修改的用户信息
     */
    @Update("UPDATE user SET username=#{username},password=#{password} WHERE id=#{id}")
    void updateUser(User user);

    /**
     * 删除数据
     *
     * @param id 删除的用户id
     */
    @Delete("DELETE FROM user WHERE id=#{id}")
    void deleteUser(int id);

    /**
     * 根据查询数据
     *
     * @param userName 查询的用户名称
     * @return 返回查询到的用户名称
     */
    @Select("SELECT username FROM user WHERE username=#{userName}")
    String findByName(@Param("userName") String userName);

    /**
     * 根据查询数据
     *
     * @param userName 登录的用户名称
     * @param password 用户密码
     * @return 返回查询到的数据
     */
    @Select("SELECT username FROM user WHERE username=#{userName} AND password=#{password}")
    String findUserByNamePassword(@Param("userName") String userName, @Param("password") String password);

    /**
     * 查询所有数据
     *
     * @return 返回全部用户信息
     */
    @Select("SELECT id,email,password,username FROM user")
    List<User> findAll();
}