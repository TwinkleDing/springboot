package com.example.spring.utils;


import org.springframework.http.HttpStatus;

public class Message<T> {

    String status;
    //向前端返回的内容
    String message;

    T data;

    public Message() {
    }

    public Message(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public Message(String status, String message, T data) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public static <T> Message<T> custom(String status, String message, T data) {
        return new Message(status, message, data);
    }

    public static <T> Message<T> custom(String status, String message) {
        return new Message(status, message);
    }

    public static HttpStatus num2HttpStatus(String code) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        for (HttpStatus httpStatus : HttpStatus.values()) {
            boolean b = Integer.parseInt(code) == httpStatus.value();
            if (b) {
                return httpStatus;
            }
        }
        return status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

