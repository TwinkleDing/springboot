package com.example.spring.service;

import com.example.spring.bean.UserBean;

public interface UserService {
    UserBean loginIn(String userName, String userId);
}
