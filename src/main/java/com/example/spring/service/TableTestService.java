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
     * @param start      起始页码
     * @param end        结束页码
     * @param searchName 搜索条件
     * @param sort       排序方式
     * @param quantity   排序方式
     * @return 返回列表
     */
    List<TableTest> getList(int start, int end, String searchName, String sort, String quantity);

    /**
     * 获取列表总数量
     *
     * @param start      起始页码
     * @param end        结束页码
     * @param searchName 搜索条件
     * @param sort       排序方式
     * @param quantity   排序方式
     * @return 列表总数量
     */
    int getListTotal(int start, int end, String searchName, String sort, String quantity);

    /**
     * 添加数据
     *
     * @param tableTest 添加的数据
     * @return 是否添加成功
     */
    boolean addTable(TableTest tableTest);

    /**
     * 修改数据
     *
     * @param tableTest 修改数据
     * @return 是否修改成功
     */
    boolean updateTable(TableTest tableTest);

    /**
     * 批量新增
     *
     * @param list 列表
     * @return 是否添加成功
     */
    boolean volumeInsertTable(List<TableTest> list);

    /**
     * 批量删除
     *
     * @param list id列表
     * @return 删除结果
     */
    boolean batchDelete(String[] list);
}
