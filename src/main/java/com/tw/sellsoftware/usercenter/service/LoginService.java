package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.vo.LoginUserInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class LoginService {

    private final UserInfoService userInfoService;

    public LoginService(UserInfoService userInfoService){
        this.userInfoService = userInfoService;
    }

    public Optional<String> userLogin(LoginUserInfo userInfo, HttpServletRequest request) {
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
