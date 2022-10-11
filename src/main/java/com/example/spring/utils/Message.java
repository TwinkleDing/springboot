package com.example.spring.utils;


import org.springframework.http.HttpStatus;

public class Message<T> {

    int status;
    //向前端返回的内容
    String message;

    T data;

    public Message() {
    }

    public Message(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Message(int status, String message, T data) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public static <T> Message<T> custom(int status, String message, T data) {
        return new Message(status, message, data);
    }

    public static <T> Message<T> custom(int status, String message) {
        return new Message(status, message);
    }

    public static HttpStatus num2HttpStatus(int code) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        for (HttpStatus httpStatus : HttpStatus.values()) {
            boolean b = code == httpStatus.value();
            if (b) {
                return httpStatus;
            }
        }
        return status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

