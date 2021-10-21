package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserInfoService userInfoService;

    public Optional<String> userLogin(UserInfo userInfo, HttpServletRequest request) {
        UserInfo userInfoForDB = userInfoService.getUserByUserName(userInfo.getUserName());
        if(userInfoForDB == null){
            return Optional.of("User does not exist!");
        }
        if(!userInfo.getPassword().equals(userInfoForDB.getPassword())){
            return Optional.of("Password error!");
        }
        request.getSession().setAttribute("userInfo",userInfoForDB);
        return Optional.empty();
    }
}
