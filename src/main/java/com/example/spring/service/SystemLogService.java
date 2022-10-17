package com.example.spring.service;

import com.example.spring.bean.SystemLog;

import java.util.List;

/**
 * @author TwinkleDing
 */
public interface SystemLogService {

    /**
     * 获取日志列表
     *
     * @param start 开始下标
     * @param end   结束下标
     * @return 日志列表
     */
    List<SystemLog> getSystemLogList(int start, int end);

    /**
     * 获取日志长度
     *
     * @return 日志列表长度
     */
    int getSystemLogTotal();

    /**
     * 删除指定日志
     *
     * @param id 日志id
     * @return 是否删除成功
     */
    boolean deleteLog(String id);

    /**
     * 删除选中日志
     *
     * @param idList id列表
     * @return 是否删除成功
     */
    boolean deleteLogSelect(String[] idList);

    /**
     * 删除全部日志
     *
     * @return 是否删除成功
     */
    boolean deleteLogAll();
}
