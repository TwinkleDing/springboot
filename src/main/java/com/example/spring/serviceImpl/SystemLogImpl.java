package com.example.spring.serviceImpl;

import com.example.spring.bean.SystemLog;
import com.example.spring.dao.SystemLogDao;
import com.example.spring.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemLogImpl implements SystemLogService {

    @Autowired
    private SystemLogDao systemLogDao;

    @Override
    public List<SystemLog> getSystemLogList(int start, int end) {
        return systemLogDao.getSystemLogList(start, end);
    }

    @Override
    public int getSystemLogTotal() {
        return systemLogDao.getSystemLogTotal();
    }

    @Override
    public boolean deleteLog(String id) {
        boolean flag = false;
        try {
            systemLogDao.deleteLog(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
