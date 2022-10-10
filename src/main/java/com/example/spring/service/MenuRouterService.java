package com.example.spring.service;

import com.example.spring.bean.MenuRouter;

import java.util.List;


public interface MenuRouterService {
    /**
     * 获取路由列表
     *
     * @return 路由列表
     */
    List<MenuRouter> getRouterList();
}
