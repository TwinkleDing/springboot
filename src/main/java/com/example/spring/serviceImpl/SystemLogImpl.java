package com.example.spring.serviceImpl;

import com.example.spring.bean.SystemLog;
import com.example.spring.dao.MenuRouterDao;
import com.example.spring.dao.SystemLogDao;
import com.example.spring.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TwinkleDing
 */
@Service
public class SystemLogImpl implements SystemLogService {

    private SystemLogDao systemLogDao = null;

    @Autowired
    public void menuRouterController(SystemLogDao systemLogDao) {
        this.systemLogDao = systemLogDao;
    }

    /**
     * 获取日志列表
     *
     * @param start 开始下标
     * @param end   结束下标
     * @return 日志列表
     */
    @Override
    public List<SystemLog> getSystemLogList(int start, int end) {
        return systemLogDao.getSystemLogList(start, end);
    }

    /**
     * 日志数量
     *
     * @return 日志数量
     */
    @Override
    public int getSystemLogTotal() {
        return systemLogDao.getSystemLogTotal();
    }

    /**
     * 删除日志
     *
     * @param id 日志id
     * @return 删除结果
     */
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

    /**
     * 批量删除
     *
     * @param idList id列表
     * @return 删除结果
     */
    @Override
    public boolean deleteLogSelect(String[] idList) {
        boolean flag = false;
        try {
            systemLogDao.deleteLogSelect(idList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 全部删除
     *
     * @return 删除结果
     */
    @Override
    public boolean deleteLogAll() {
        boolean flag = false;
        try {
            systemLogDao.deleteLogAll();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
