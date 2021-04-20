package com.liuyk.asimple.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class UriStatistic {

    private int id;
    private Integer oaId;
    private String account;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date ctime;
    private Integer hour;
    private Integer minutes;
    private Integer day;
    private String url;
    private Date creatTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOaId() {
        return oaId;
    }

    public void setOaId(Integer oaId) {
        this.oaId = oaId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
