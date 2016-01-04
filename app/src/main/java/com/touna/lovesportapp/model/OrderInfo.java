package com.touna.lovesportapp.model;

/**
 * created by collin on 2016-01-04.
 */
public class OrderInfo {
    private String id = null;
    private String stadiumName = null;
    private String state = null;
    private String code = null;
    private String startTime = null;
    private String stadiumNumber = null;
    private String money = null;

    public OrderInfo(String id, String stadiumName, String state, String code, String startTime, String stadiumNumber, String money) {
        this.id = id;
        this.stadiumName = stadiumName;
        this.state = state;
        this.code = code;
        this.startTime = startTime;
        this.stadiumNumber = stadiumNumber;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStadiumNumber() {
        return stadiumNumber;
    }

    public void setStadiumNumber(String stadiumNumber) {
        this.stadiumNumber = stadiumNumber;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
