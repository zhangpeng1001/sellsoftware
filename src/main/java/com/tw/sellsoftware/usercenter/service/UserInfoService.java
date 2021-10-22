package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserInfoService {

    private final UserInfoMapper userInfoMapper;

    public UserInfoService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public UserInfo getUserByUserName(String userName) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        return userInfoMapper.selectUserInfo(userInfo);
    }

    public UserInfo getUserByNameOrPhoneOrEmail(UserInfo userInfo) {
        return userInfoMapper.getUserByNameOrPhoneOrEmail(userInfo);
    }

    public int register(UserInfo userInfo) {
        return userInfoMapper.insertUserInfo(userInfo);
    }
}
