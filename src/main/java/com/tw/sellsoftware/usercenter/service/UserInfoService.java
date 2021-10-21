package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.mapper.UserInfoMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

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
