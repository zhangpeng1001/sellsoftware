package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserInfoService userInfoService;

    public Optional<String> userLogin(UserInfo userInfo) {
        UserInfo userInfoForDB = userInfoService.getUserByUserName(userInfo.getUserName());
        if(userInfoForDB == null){
            return Optional.of("User does not exist!");
        }
        if(!userInfo.getPassword().equals(userInfoForDB.getPassword())){
            return Optional.of("Password error!");
        }
        return Optional.empty();
    }
}
