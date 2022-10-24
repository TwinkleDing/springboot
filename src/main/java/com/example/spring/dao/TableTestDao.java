package com.example.spring.dao;

import com.example.spring.bean.TableTest;
import org.apache.ibatis.annotations.*;

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
     * 右连接，，以右表为主表查询
     * // @Select("SELECT * FROM test_table t RIGHT JOIN quantity_name q ON q.quantity = t.quantity WHERE name LIKE #{searchName} ORDER BY sort LIMIT #{start} , #{end}")
     * 左连接，以左表为主表查询
     * // @Select("SELECT * FROM quantity_name q  LEFT JOIN test_table t ON q.quantity = t.quantity WHERE name LIKE #{searchName} ORDER BY sort LIMIT #{start} , #{end}")
     * 所有联查
     * //  @Select("SELECT * FROM quantity_name q, test_table t WHERE q.quantity = t.quantity AND name LIKE #{searchName} ORDER BY sort LIMIT #{start} , #{end}")
     */
    @Select("SELECT * FROM quantity_name q, test_table t WHERE q.quantity = t.quantity AND name LIKE #{searchName} ORDER BY sort LIMIT #{start} , #{end}")
    List<TableTest> getList(int start, int end, String searchName);

    /**
     * 获取反序列表
     *
     * @param start      起始页码
     * @param end        终止页码
     * @param searchName 搜索条件
     * @return 返回列表
     */
    @Select("SELECT * FROM quantity_name q, test_table t WHERE q.quantity = t.quantity AND name LIKE #{searchName} ORDER BY sort DESC LIMIT #{start} , #{end}")
    List<TableTest> getListDesc(int start, int end, String searchName);

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
    void volumeIncrease(@Param("list") List<TableTest> list);

    /**
     * 批量删除
     *
     * @param idList id列表
     */
    void batchDelete(@Param("idList") String[] idList);

    /**
     * 获取quantityName
     *
     * @param quantity quantity
     * @return quantityName
     */
    @Select("SELECT b.`name` FROM test_table a, quantity_name b WHERE a.quantity = #{quantity} AND b.quantity = #{quantity}")
    String getQuantityName(int quantity);
}
