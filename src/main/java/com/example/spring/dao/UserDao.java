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
    @Insert("insert into user(password,username,id) values (#{password},#{username},#{id})")
    void addUser(User user);

    /**
     * 修改数据
     *
     * @param user 修改的用户信息
     */
    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除数据
     *
     * @param id 删除的用户id
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(int id);

    /**
     * 根据查询数据
     *
     * @param userName 查询的用户名称
     * @return 返回查询到的用户名称
     */
    @Select("select username from user where username=#{userName}")
    String findByName(@Param("userName") String userName);

    /**
     * 根据查询数据
     *
     * @param userName 登录的用户名称
     * @param password 用户密码
     * @return 返回查询到的数据
     */
    @Select("select username from user where username=#{userName} AND password=#{password}")
    String findUserByNamePassword(@Param("userName") String userName, @Param("password") String password);

    /**
     * 查询所有数据
     *
     * @return 返回全部用户信息
     */
    @Select("select id,email,password,username FROM user")
    List<User> findAll();
}