package com.example.spring.service;

import com.example.spring.bean.TableTest;

import java.util.List;

/**
 * @author TwinkleDing
 */
public interface TableTestService {

    /**
     * 获取列表
     *
     * @param start 起始页码
     * @param end   结束页码
     * @return 返回列表
     */
    List<TableTest> getList(int start, int end);

    /**
     * 获取列表总数量
     *
     * @return 列表总数量
     */
    int getListTotal();
}
