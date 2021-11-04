package com.tw.sellsoftware.usercenter.domain;

import java.time.LocalDateTime;

public class LoginToken {
    private Integer id;

    private int userId;

    private String userLoginToken;

    private LocalDateTime updateTime;

    public LoginToken() {
    }

    public LoginToken(int userId, String userLoginToken) {
        this.userId = userId;
        this.userLoginToken = userLoginToken;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserLoginToken() {
        return userLoginToken;
    }

    public void setUserLoginToken(String userLoginToken) {
        this.userLoginToken = userLoginToken;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}