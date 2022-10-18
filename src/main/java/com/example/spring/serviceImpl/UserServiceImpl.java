package com.example.spring.serviceImpl;

import com.example.spring.bean.User;
import com.example.spring.dao.UserDao;
import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author TwinkleDing
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao = null;

    @Autowired
    public void menuRouterController(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 用户信息
     *
     * @param user 用户信息
     * @return 添加结果
     */
    @Override
    public boolean addUser(User user) {
        boolean flag = false;
        String username = findUserByName(user.getUsername());
        System.out.println("更新数据id：" + username);
        if (username != null) {
            return false;
        }
        try {
            //用来生成数据库的主键id非常不错。。
            String s = UUID.randomUUID().toString();
            String id = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
            user.setId(id);
            userDao.addUser(user);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 用户信息
     *
     * @param user 用户信息
     * @return 修改结果
     */
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

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 删除结果
     */
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

    /**
     * 查找用户名称
     *
     * @param userName 用户名称
     * @return 用户名称
     */
    @Override
    public String findUserByName(String userName) {
        return userDao.findByName(userName);
    }

    /**
     * 登录
     *
     * @param userName 用户名称
     * @param password 密码
     * @return 登录结果
     */
    @Override
    public String findUserByNamePassword(String userName, String password) {
        return userDao.findUserByNamePassword(userName, password);
    }


    /**
     * 用户列表
     *
     * @return 列表
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
