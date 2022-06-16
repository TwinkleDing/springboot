package com.example.spring.serviceImpl;

import com.example.spring.bean.User;
import com.example.spring.dao.UserDao;
import com.example.spring.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUser(User user) {
        boolean flag = false;
        String username = findUserByName(user.getUsername(), user.getPassword());
        try {
            String s = UUID.randomUUID().toString();//用来生成数据库的主键id非常不错。。
            String id = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
            user.setId(id);
            userDao.addUser(user);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag = false;
        try {
            userDao.updateUser(user);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean flag = false;
        try {
            userDao.deleteUser(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public String findUserByName(String userName, String password) {
        return userDao.findByName(userName, password);
    }


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
