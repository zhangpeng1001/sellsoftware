package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService {

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
    }
}
