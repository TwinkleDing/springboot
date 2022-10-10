package com.example.spring.controller;

import com.example.spring.bean.SystemLog;
import com.example.spring.service.SystemLogService;
import com.example.spring.utils.JSONResult;
import com.example.spring.utils.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
@Slf4j
public class SystemLogController {
    @Autowired
    private SystemLogService systemLogService;

    @RequestMapping(value = "/systemLog", method = RequestMethod.GET)
    public JSONResult<Page<SystemLog>> getSystemLogList(@RequestParam(value = "number", required = true) int number, @RequestParam(value = "size", required = true) int size) {
        List<SystemLog> list = systemLogService.getSystemLogList((number - 1) * size, size);
        int total = systemLogService.getSystemLogTotal();
        Page<SystemLog> page = new Page<>();
        page.setNumber(number);
        page.setPageSize(size);
        page.setTotal(total);
        page.setList(list);
        return JSONResult.success(page);
    }
}
