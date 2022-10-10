package com.example.spring.dao;

import com.example.spring.bean.SystemLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SystemLogDao {
    /**
     * 获取日志列表
     */
//    @Select("select * FROM sys_log LIMIT #{start} , #{end}")
    @Select("select * FROM sys_log where id > #{start} order by id limit #{end}")
    List<SystemLog> getSystemLogList(int start, int end);

    @Select("select count(*) from sys_log")
    int getSystemLogTotal();
}
