package com.example.spring.dao;


import com.example.spring.bean.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 新增数据
     */
    @Insert("insert into user(password,username) values (#{password},#{username})")
    void addUser(User user);

    /**
     * 修改数据
     */
    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除数据
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(int id);

    /**
     * 根据查询数据
     *
     */
    @Select("select id,email,password,username from user where username=#{userName} AND password=#{password")
    User findByName(@Param("userName") String userName, @Param("password") String password);

    /**
     * 查询所有数据
     */
    @Select("select id,email,password,username FROM user")
    List<User> findAll();
}