package com.example.spring.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JSONResult<T> extends ResponseEntity<Message> {

    public JSONResult(HttpStatus status) {
        super(status);
    }

    public JSONResult(String code, String msg, T data) {
        super(Message.custom(code, msg, data), Message.num2HttpStatus(code));
    }

    public JSONResult(String code, String msg) {
        super(Message.custom(code, msg), Message.num2HttpStatus(code));
    }

    public static <T> JSONResult<T> success(T data) {
        return new JSONResult("200", "成功", data);
    }

    public static <T> JSONResult<T> failed(T data) {
        return new JSONResult("422", "失败", data);
    }

    public static <T> JSONResult<T> failMsg(String msg) {
        return new JSONResult("422", msg);
    }

    public static <T> JSONResult<T> custom(String code, String msg, T data) {
        return new JSONResult(code, msg, data);
    }
}
