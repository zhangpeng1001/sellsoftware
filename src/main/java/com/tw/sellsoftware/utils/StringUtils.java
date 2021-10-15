package com.tw.sellsoftware.utils;

public class StringUtils {

    public static boolean isEmpty(String value){
        if(value == null || value.isEmpty()){
            return true;
        }
        return false;
    }
}
