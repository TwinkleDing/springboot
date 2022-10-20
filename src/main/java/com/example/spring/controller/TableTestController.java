package com.example.spring.controller;

import com.example.spring.bean.TableTest;
import com.example.spring.service.TableTestService;
import com.example.spring.utils.JSONResult;
import com.example.spring.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     *
     * @param number 第几页
     * @param size   每页数量
     * @return 列表
     */
    @RequestMapping(value = "/tableTest", method = RequestMethod.GET)
    public JSONResult<Page<TableTest>> getList(@RequestParam(value = "number", required = true) int number,
                                               @RequestParam(value = "size", required = true) int size,
                                               @RequestParam(value = "searchName", required = false) String searchName) {
        List<TableTest> list = tableTestService.getList((number - 1) * size, size, searchName);
        int total = tableTestService.getListTotal();
        Page<TableTest> page = new Page<>();
        page.setNumber(number);
        page.setPageSize(size);
        page.setTotal(total);
        page.setList(list);
        return JSONResult.successGet(page);
    }

    /**
     * 新增修改
     *
     * @param tableTest 数据
     * @return 操作结果
     */
    @RequestMapping(value = "/tableTest", method = RequestMethod.POST)
    public JSONResult<String> addTable(@RequestBody TableTest tableTest) {
        boolean flag = false;
        if (tableTest.getId() == null) {
            flag = tableTestService.addTable(tableTest);
        } else {
            flag = tableTestService.updateTable(tableTest);
        }
        if (flag) {
            return JSONResult.success();
        } else {
            return JSONResult.failed();
        }
    }

    @RequestMapping(value = "/tableVolume", method = RequestMethod.POST)
    public JSONResult<String> volumeInsertTable(@RequestBody List<TableTest> list) {
        boolean flag = false;
        flag = tableTestService.volumeInsertTable(list);
        if (flag) {
            return JSONResult.success();
        } else {
            return JSONResult.failed();
        }
    }
}
