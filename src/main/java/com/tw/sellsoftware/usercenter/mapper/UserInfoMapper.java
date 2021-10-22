package com.tw.sellsoftware.usercenter.mapper;

import com.tw.sellsoftware.usercenter.domain.UserInfo;

public interface UserInfoMapper {

    UserInfo selectUserInfo(UserInfo userInfo);

    UserInfo getUserByNameOrPhoneOrEmail(UserInfo userInfo);

    int insertUserInfo(UserInfo record);
}