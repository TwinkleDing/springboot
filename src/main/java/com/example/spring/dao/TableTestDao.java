package com.example.spring.dao;

import com.example.spring.bean.TableTest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author TwinkleDing
 */
@Mapper
public interface TableTestDao {

    /**
     * 获取列表
     *
     * @param start      起始页码
     * @param end        终止页码
     * @param searchName 搜索条件
     * @return 返回列表
     */
    @Select("SELECT * FROM test_table WHERE name LIKE #{searchName} ORDER BY sort")
    List<TableTest> getList(int start, int end, String searchName);

    /**
     * 获取数量
     *
     * @return 总数量
     */
    @Select("SELECT count(sort) FROM test_table")
    int getListTotal();

    /**
     * 新增数据
     *
     * @param tableTest 数据
     */
    @Insert("INSERT INTO test_table(id, name, create_time, sort, content, quantity, state, type) VALUES (#{id}, #{name}, #{create_time}, #{sort}, #{content}, #{quantity}, #{state}, #{type})")
    void addTable(TableTest tableTest);

    /**
     * 修改数据
     *
     * @param tableTest 数据
     */
    @Update("UPDATE test_table SET name=#{name}, create_time=#{create_time}, content=#{content}, quantity=#{quantity}, state=#{state}, type=#{type} WHERE id=#{id}")
    void updateTable(TableTest tableTest);

    /**
     * 批量增加
     *
     * @param list 列表
     */
    void volumeIncrease(List<TableTest> list);
}
