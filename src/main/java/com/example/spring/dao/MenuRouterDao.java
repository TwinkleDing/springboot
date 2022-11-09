package com.example.spring.dao;

import com.example.spring.bean.MenuRouter;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author TwinkleDing
 */
@Mapper
public interface MenuRouterDao {

    /**
     * 获取路由信息
     *
     * @return List 路由列表
     */
    @Select("SELECT * FROM menu_router ORDER BY menu_id")
    List<MenuRouter> getRouterList();
}
