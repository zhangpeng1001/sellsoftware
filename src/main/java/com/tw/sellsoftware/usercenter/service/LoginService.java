package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.vo.LoginUserInfo;
import com.tw.sellsoftware.utils.SellSoftwareException;
import com.tw.sellsoftware.utils.enums.SellSoftwareExceptionEnum;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserInfoService userInfoService;

    public LoginService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    public UserInfo userLogin(LoginUserInfo userInfo) {
        UserInfo userInfoForDB = userInfoService.getUserByUserName(userInfo.getUserName());
        if (userInfoForDB == null) throw new SellSoftwareException(SellSoftwareExceptionEnum.USER_NOT_EXIST);
        if (!userInfo.getPassword().equals(userInfoForDB.getPassword()))
            throw new SellSoftwareException(SellSoftwareExceptionEnum.USER_PASSWORD_ERROR);
        return userInfoForDB;
    }
}
