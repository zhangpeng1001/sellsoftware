package com.tw.sellsoftware.usercenter.domain;

import com.tw.sellsoftware.usercenter.vo.RegisterUserInfo;

public class UserInfo {
    private Integer id;

    private String userName;

    private String email;

    private String phone;

    private String password;

    public UserInfo() {
    }

    public UserInfo(RegisterUserInfo registerUserInfo) {
        this.userName = registerUserInfo.getUserName();
        this.email = registerUserInfo.getEmail();
        this.phone = registerUserInfo.getPhone();
        this.password = registerUserInfo.getPassword();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}