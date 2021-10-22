package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    private final UserInfoMapper userInfoMapper;

    public UserInfoService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public UserInfo getUserByUserName(String userName) {
        return userInfoMapper.getUserByUserName(userName);
    }

    public UserInfo getUserByNameOrPhoneOrEmail(String userName, String phone, String email) {
        return userInfoMapper.getUserByNameOrPhoneOrEmail(userName, phone, email);
    }

    public int register(UserInfo userInfo) {
        return userInfoMapper.insertUserInfo(userInfo);
    }
}
