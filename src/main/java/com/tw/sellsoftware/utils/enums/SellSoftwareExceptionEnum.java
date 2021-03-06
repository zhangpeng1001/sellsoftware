package com.tw.sellsoftware.utils.enums;

public enum SellSoftwareExceptionEnum {

    //common model
    PAGE_NUM_ERROR("pageNum parameter error!"),
    PAGE_SIZE_ERROR("pageSize parameter error!"),
    REQUEST_PARAMETER_ERROR("Request parameter error!"),
    //login model
    USER_OR_PASSWORD_ERROR("User or password error!"),
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
