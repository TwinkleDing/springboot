package com.example.spring.controller;

import com.example.spring.bean.SystemLog;
import com.example.spring.service.SystemLogService;
import com.example.spring.utils.JSONResult;
import com.example.spring.utils.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author TwinkleDing
 */
@RestController
@RequestMapping(value = "/api/")
@Slf4j
public class SystemLogController {

    private final SystemLogService systemLogService;

    @Autowired
    public SystemLogController(SystemLogService systemLogService) {
        this.systemLogService = systemLogService;
    }

    /**
     * 获取日志列表
     *
     * @param number 页码
     * @param size   每页数量
     * @return 日志列表
     */
    @RequestMapping(value = "/systemLog", method = RequestMethod.GET)
    public JSONResult<Page<SystemLog>> getSystemLogList(@RequestParam(value = "number", required = true) int number, @RequestParam(value = "size", required = true) int size) {
        List<SystemLog> list = systemLogService.getSystemLogList((number - 1) * size, size);
        int total = systemLogService.getSystemLogTotal();
        Page<SystemLog> page = new Page<>();
        page.setNumber(number);
        page.setPageSize(size);
        page.setTotal(total);
        page.setList(list);
        return JSONResult.successGet(page);
    }

    /**
     * 删除日志
     *
     * @param id 日志id
     * @return 删除结果
     */
    @RequestMapping(value = "/systemLog", method = RequestMethod.DELETE)
    public JSONResult<String> deleteLog(@RequestBody String id) {
        boolean deleteFlag = systemLogService.deleteLog(id);
        return getStringJSONResult(deleteFlag);
    }

    /**
     * 批量删除
     *
     * @param idList id列表
     * @return 删除结果
     */
    @RequestMapping(value = "/systemLog/deleteSelect", method = RequestMethod.DELETE)
    public JSONResult<String> deleteLogSelect(@RequestBody String[] idList) {
        log.info(Arrays.toString(idList));
        boolean deleteFlag = systemLogService.deleteLogSelect(idList);
        return getStringJSONResult(deleteFlag);
    }

    /**
     * 全部删除
     *
     * @return 删除结果
     */
    @RequestMapping(value = "/systemLog/deleteAll", method = RequestMethod.DELETE)
    public JSONResult<String> deleteLogAll() {
        boolean deleteFlag = systemLogService.deleteLogAll();
        return getStringJSONResult(deleteFlag);
    }

    private static JSONResult<String> getStringJSONResult(boolean deleteFlag) {
        if (deleteFlag) {
            return JSONResult.successDelete();
        } else {
            return JSONResult.failedDelete();
        }
    }
}
