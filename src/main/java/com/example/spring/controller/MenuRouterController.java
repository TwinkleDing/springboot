package com.example.spring.controller;

import com.example.spring.bean.MenuRouter;
import com.example.spring.service.MenuRouterService;
import com.example.spring.utils.JSONResult;
import com.example.spring.utils.ZoneUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author TwinkleDing
 */
@RestController
@RequestMapping(value = "/api/")
public class MenuRouterController {

    private final MenuRouterService menuRouterService;

    @Autowired
    public MenuRouterController(MenuRouterService menuRouterService) {
        this.menuRouterService = menuRouterService;
    }

    /**
     * 获取路由列表
     *
     * @return 路由列表
     */
    @RequestMapping(value = "/menuRouter", method = RequestMethod.GET)
    public JSONResult<List<MenuRouter>> getRouterList() {
        List<MenuRouter> list = menuRouterService.getRouterList();
        List<MenuRouter> result = ZoneUtils.buildTree2(list);
        return JSONResult.successGet(result);
    }
}
