package com.tw.sellsoftware.utils;

import com.tw.sellsoftware.usercenter.domain.UserInfo;

import javax.servlet.http.HttpServletRequest;

public class CommonUtils {

    public static int getCurrentUserId(HttpServletRequest request) throws Exception {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        if(userInfo == null){
            throw new Exception("userInfo is null!");
        }
        return userInfo.getId();
    }

}
