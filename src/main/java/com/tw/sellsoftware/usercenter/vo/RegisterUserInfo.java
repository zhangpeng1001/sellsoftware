package com.tw.sellsoftware.usercenter.vo;

import javax.validation.constraints.NotEmpty;

public class RegisterUserInfo {

    @NotEmpty(message = "UserName can't be empty")
    private String userName;

    @NotEmpty(message = "Email can't be empty")
    private String email;

    @NotEmpty(message = "Phone can't be empty")
    private String phone;

    @NotEmpty(message = "Password can't be empty")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}