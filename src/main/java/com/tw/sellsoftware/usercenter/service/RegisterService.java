package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegisterService {

    @Autowired
    private UserInfoService userInfoService;

    public Optional<String> userRegister(UserInfo userInfo) {
        Optional<String> optional = userDataValidate(userInfo);
        if(optional.isPresent()){
            return optional;
        }
        userInfoService.register(userInfo);
        return Optional.empty();
    }

    private Optional<String> userDataValidate(UserInfo userInfo) {
        if(StringUtils.isEmpty(userInfo.getUserName())){
            return Optional.of("UserName is empty!");
        }
        if(StringUtils.isEmpty(userInfo.getPhone())){
            return Optional.of("User phone is empty!");
        }
        if(StringUtils.isEmpty(userInfo.getEmail())){
            return Optional.of("User Email is empty!");
        }
        if(StringUtils.isEmpty(userInfo.getPassword())){
            return Optional.of("User Password is empty!");
        }
        UserInfo userInfoForDB = userInfoService.getUserByPhoneOrEmail(userInfo);
        if(userInfoForDB != null && !StringUtils.isEmpty(userInfoForDB.getPhone())){
            return Optional.of("User phone already exists!");
        }
        if(userInfoForDB != null && !StringUtils.isEmpty(userInfoForDB.getEmail())){
            return Optional.of("User Email already exists!");
        }
        return Optional.empty();
    }

}
