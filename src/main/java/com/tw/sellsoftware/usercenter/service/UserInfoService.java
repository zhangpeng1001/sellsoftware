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

    public UserInfo getUserByPhoneOrEmail(UserInfo userInfo) {
        return userInfoMapper.getUserByPhoneOrEmail(userInfo);
    }

    public int register(UserInfo userInfo) {
        userInfo.setCreateTime(LocalDate.now());
        userInfo.setUpdateTime(LocalDate.now());
        return userInfoMapper.insertUserInfo(userInfo);
    }
}
