package com.example.spring.dao;

import com.example.spring.bean.TableTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author TwinkleDing
 */
@Mapper
public interface TableTestDao {

    /**
     * 获取列表
     * @param start 起始页码
     * @param end 终止页码
     * @return 返回列表
     */
    @Select("select * from test_table")
    List<TableTest> getList(int start, int end);

    /**
     * 获取数量
     *
     * @return 总数量
     */
    @Select("select count(id) from test_table")
    int getListTotal();
}
