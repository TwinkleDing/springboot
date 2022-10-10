package com.example.spring.service;

import com.example.spring.bean.SystemLog;

import java.util.List;

public interface SystemLogService {
    /**
     * 获取日志列表
     *
     * @return 日志列表
     */
    List<SystemLog> getSystemLogList(int start, int end);

    /**
     * 获取日志长度
     *
     * @return 日志列表长度
     */
    int getSystemLogTotal();
}
