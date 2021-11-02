package com.tw.sellsoftware.usercenter.vo;

import javax.validation.constraints.NotEmpty;

public class LoginUserInfo {

    @NotEmpty(message = "UserName can't be empty")
    private String userName;

    @NotEmpty(message = "Password can't be empty")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}