package com.example.spring.controller;

import com.example.spring.bean.SystemLog;
import com.example.spring.bean.TableTest;
import com.example.spring.service.TableTestService;
import com.example.spring.utils.JSONResult;
import com.example.spring.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author TwinkleDing
 */
@RestController
@RequestMapping(value = "/api")
public class TableTestController {

    private final TableTestService tableTestService;

    @Autowired
    public TableTestController(TableTestService tableTestService) {
        this.tableTestService = tableTestService;
    }

    /**
     * 获取列表数据
     * @param number 第几页
     * @param size 每页数量
     * @return 列表
     */
    @RequestMapping(value = "/tableTest", method = RequestMethod.GET)
    public JSONResult<Page<TableTest>> getList(@RequestParam(value = "number", required = true) int number, @RequestParam(value = "size", required = true) int size) {
        List<TableTest> list = tableTestService.getList((number - 1) * size, size);
        int total = tableTestService.getListTotal();
        Page<TableTest> page = new Page<>();
        page.setNumber(number);
        page.setPageSize(size);
        page.setTotal(total);
        page.setList(list);
        return JSONResult.successGet(page);
    }
}
