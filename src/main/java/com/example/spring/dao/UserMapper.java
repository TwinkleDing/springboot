package com.example.spring.dao;

import com.example.spring.bean.UserBean;

public interface UserMapper {
    UserBean getInfo(String userName, String userId);
}
