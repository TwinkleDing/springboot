package com.example.spring.dao;

import com.example.spring.bean.SystemLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SystemLogDao {
    /**
     * 获取日志列表
     */
    @Select("select * FROM sys_log LIMIT #{start} , #{end}")
//    上面方法简单，但是数据量过多容易卡顿，下列方法性能更好，但是要设置主键或唯一索引
//    @Select("select * FROM sys_log where id > #{start} order by id limit #{end}")
    List<SystemLog> getSystemLogList(int start, int end);

    @Select("select count(id) from sys_log")
    int getSystemLogTotal();

    @Delete("delete from sys_log where id=#{id}")
    void deleteLog(String id);

    @Delete("delete from sys_log where id in (#{idList})")
    void deleteLogSelect(@Param("idList") String[] idList);

    @Delete("truncate table sys_log")
    void deleteLogAll();
}
