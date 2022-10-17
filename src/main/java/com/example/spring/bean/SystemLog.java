package com.example.spring.bean;

/**
 * @author TwinkleDing
 */
public class SystemLog {

    private String id;

    private String log_content;

    private String userid;

    private String username;

    private String ip;

    private String method;

    private String cost_time;

    private String create_by;

    private String create_time;

    private int log_type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogContent() {
        return log_content;
    }

    public void setLogContent(String logContent) {
        this.log_content = logContent;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCostTime() {
        return cost_time;
    }

    public void setCostTime(String cost_time) {
        this.cost_time = cost_time;
    }

    public String getCreateBy() {
        return create_by;
    }

    public void setCreateBy(String create_by) {
        this.create_by = create_by;
    }

    public String getCreateTime() {
        return create_time;
    }

    public void setCreateTime(String create_time) {
        this.create_time = create_time;
    }

    public int getLogType() {
        return log_type;
    }

    public void setLogType(int log_type) {
        this.log_type = log_type;
    }
}
