package com.tw.sellsoftware.utils.enums;

public enum SellSoftwareExceptionEnum {

    //login model
    USER_NOT_EXIST("User does not exist!"),
    USER_PASSWORD_ERROR("Password error!"),
    //register model
    USER_NAME_EXIST("User name already exists!"),
    USER_PHONE_EXIST("User phone already exists!"),
    USER_EMAIL_EXIST("User Email already exists!");

    private String errorMsg;

    SellSoftwareExceptionEnum(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
