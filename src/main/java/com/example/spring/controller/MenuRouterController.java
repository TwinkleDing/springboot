package com.example.spring.controller;

import com.example.spring.bean.MenuRouter;
import com.example.spring.service.MenuRouterService;
import com.example.spring.utils.JSONResult;
import com.example.spring.utils.ZoneUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
@Slf4j
public class MenuRouterController {
    @Autowired
    private MenuRouterService menuRouterService;

    @RequestMapping(value = "/menuRouter", method = RequestMethod.GET)
    public JSONResult<List<MenuRouter>> getRouterList() {
        List<MenuRouter> list = menuRouterService.getRouterList();
        List<MenuRouter> result = ZoneUtils.buildTree2(list);
        log.info(String.valueOf(result));
        return JSONResult.successGet(result);
    }
}
