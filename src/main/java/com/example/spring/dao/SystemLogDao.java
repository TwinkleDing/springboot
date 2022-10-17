package com.example.spring.dao;

import com.example.spring.bean.SystemLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author TwinkleDing
 */
@Mapper
public interface SystemLogDao {

    /**
     * 获取日志列表
     * // @Select("select * FROM sys_log where id > #{start} order by id limit #{end}")
     *
     * @param start 开始下标
     * @param end   结束下标
     */
    @Select("select * FROM sys_log LIMIT #{start} , #{end}")
    List<SystemLog> getSystemLogList(int start, int end);

    /**
     * 获取日志数量
     *
     * @return 日志的总数量
     */
    @Select("select count(id) from sys_log")
    int getSystemLogTotal();

    /**
     * 删除日志
     *
     * @param id id
     */
    @Delete("delete from sys_log where id=#{id}")
    void deleteLog(String id);

    /**
     * 批量删除
     *
     * @param idList i列表
     */
    void deleteLogSelect(@Param("idList") String[] idList);

    /**
     * 全部删除
     */
    @Delete("truncate table sys_log")
    void deleteLogAll();
}
