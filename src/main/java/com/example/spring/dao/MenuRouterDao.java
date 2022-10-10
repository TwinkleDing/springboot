package com.example.spring.dao;

import com.example.spring.bean.MenuRouter;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuRouterDao {
    /**
     * 获取路由信息
     */
    @Select("select * FROM menu_router")
    List<MenuRouter> getRouterList();
}
