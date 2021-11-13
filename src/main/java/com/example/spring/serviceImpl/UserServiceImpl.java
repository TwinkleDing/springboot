package com.example.spring.serviceImpl;

import com.example.spring.bean.UserBean;
import com.example.spring.dao.UserMapper;
import com.example.spring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Resource
    private UserMapper userMapper;

    @Override
    public UserBean loginIn(String userName, String userId) {
        return userMapper.getInfo(userName, userId);
    }
}
