package com.tw.sellsoftware.utils;

import com.tw.sellsoftware.utils.enums.SellSoftwareExceptionEnum;

public class SellSoftwareException extends RuntimeException{

    private SellSoftwareExceptionEnum exceptionEnum;

    public SellSoftwareException(SellSoftwareExceptionEnum exceptionEnum){
        super(exceptionEnum.getErrorMsg());
        this.exceptionEnum = exceptionEnum;
    }
}
