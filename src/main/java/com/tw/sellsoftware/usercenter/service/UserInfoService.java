package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.mapper.UserInfoMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserByUserId(String userId) {
        //TODO query user data from DB, condition is userId
        return new UserInfo();
    }

    public UserInfo getUserByUserName(String userName) {
        //TODO query user data from DB, condition is userName
        return new UserInfo();
    }

    public UserInfo getUserByPhoneOrEmail(UserInfo userInfo) {
        //TODO query user data from DB, condition is phone or email
        return new UserInfo();
    }

    public void register(UserInfo userInfo) {
        //TODO insert user data to DB
        userInfoMapper.insertSelective(userInfo);
    }
}
