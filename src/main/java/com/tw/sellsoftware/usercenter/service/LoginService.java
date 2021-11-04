package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.LoginToken;
import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.mapper.LoginTakenMapper;
import com.tw.sellsoftware.usercenter.vo.LoginUserInfo;
import com.tw.sellsoftware.utils.SellSoftwareException;
import com.tw.sellsoftware.utils.enums.SellSoftwareExceptionEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService {

    private final UserInfoService userInfoService;

    private final LoginTakenMapper loginTakenMapper;

    public LoginService(UserInfoService userInfoService,LoginTakenMapper loginTakenMapper) {
        this.userInfoService = userInfoService;
        this.loginTakenMapper = loginTakenMapper;
    }

    public String userLogin(LoginUserInfo userInfo) {
        UserInfo userInfoForDB = userInfoService.getUserByUserName(userInfo.getUserName());
        if (userInfoForDB == null) throw new SellSoftwareException(SellSoftwareExceptionEnum.USER_OR_PASSWORD_ERROR);
        if (!userInfo.getPassword().equals(userInfoForDB.getPassword()))
            throw new SellSoftwareException(SellSoftwareExceptionEnum.USER_OR_PASSWORD_ERROR);
        String token = UUID.randomUUID().toString();
        loginTakenMapper.insertLoginToken(new LoginToken(userInfoForDB.getId(),token));
        return token;
    }
}
