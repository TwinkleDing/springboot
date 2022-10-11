package com.example.spring.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JSONResult<T> extends ResponseEntity<Message<T>> {

    public JSONResult(HttpStatus status) {
        super(status);
    }

    public JSONResult(int code, String msg, T data) {
        super(Message.custom(code, msg, data), Message.num2HttpStatus(code));
    }

    public JSONResult(int code, String msg) {
        super(Message.custom(code, msg), Message.num2HttpStatus(code));
    }

    public static <T> JSONResult<T> success(T data) {
        return new JSONResult<>(200, "操作成功！", data);
    }

    public static <T> JSONResult<T> success(T data, String msg) {
        return new JSONResult<>(200, msg, data);
    }

    public static <T> JSONResult<T> successMsg(String msg) {
        return new JSONResult<>(200, msg);
    }

    public static <T> JSONResult<T> successGet(T data) {
        return new JSONResult<>(200, "查询成功！", data);
    }

    public static <T> JSONResult<T> successAdd(T data) {
        return new JSONResult<>(200, "添加成功！", data);
    }

    public static <T> JSONResult<T> successEdit(T data) {
        return new JSONResult<>(200, "修改成功！", data);
    }

    public static <T> JSONResult<T> successDelete(T data) {
        return new JSONResult<>(200, "删除成功！", data);
    }

    public static <T> JSONResult<T> failed(T data) {
        return new JSONResult<>(500, "操作失败！", data);
    }

    public static <T> JSONResult<T> failed(T data, String msg) {
        return new JSONResult<>(500, msg, data);
    }

    public static <T> JSONResult<T> failedMsg(String msg) {
        return new JSONResult<>(500, msg);
    }

    public static <T> JSONResult<T> failedGet(T data) {
        return new JSONResult<>(500, "查询失败！", data);
    }

    public static <T> JSONResult<T> failedAdd(T data) {
        return new JSONResult<>(500, "添加失败！", data);
    }

    public static <T> JSONResult<T> failedEdit(T data) {
        return new JSONResult<>(500, "修改失败！", data);
    }

    public static <T> JSONResult<T> failedDelete(T data) {
        return new JSONResult<>(500, "删除失败！", data);
    }

    public static <T> JSONResult<T> custom(int code, String msg, T data) {
        return new JSONResult<>(code, msg, data);
    }
}
