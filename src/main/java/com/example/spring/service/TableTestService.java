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
     * @param searchName 搜索条件
     * @return 返回列表
     */
    List<TableTest> getList(int start, int end, String searchName);

    /**
     * 获取列表总数量
     *
     * @return 列表总数量
     */
    int getListTotal();

    /**
     * 添加数据
     *
     * @param tableTest 添加的数据
     * @return 是否添加成功
     */
    boolean addTable(TableTest tableTest);

    /**
     *  修改数据
     * @param tableTest 修改数据
     * @return 是否修改成功
     */
    boolean updateTable(TableTest tableTest);
}