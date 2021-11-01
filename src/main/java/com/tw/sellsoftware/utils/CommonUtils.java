package com.tw.sellsoftware.utils;

import com.tw.sellsoftware.usercenter.domain.UserInfo;

import javax.servlet.http.HttpServletRequest;

public class CommonUtils {

    public static int getCurrentUserId(HttpServletRequest request) {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        if (userInfo == null) {
            throw new NullPointerException("userInfo is null!");
        }
        return userInfo.getId();
    }

}
