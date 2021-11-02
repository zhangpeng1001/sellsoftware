package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.domain.UserVipRelation;
import com.tw.sellsoftware.usercenter.vo.RegisterUserInfo;
import com.tw.sellsoftware.utils.SellSoftwareException;
import com.tw.sellsoftware.utils.enums.SellSoftwareExceptionEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService {

    private final UserInfoService userInfoService;

    private final VipInfoService vipInfoService;

    public RegisterService(UserInfoService userInfoService, VipInfoService vipInfoService) {
        this.userInfoService = userInfoService;
        this.vipInfoService = vipInfoService;
    }

    @Transactional
    public void userRegister(RegisterUserInfo registerUserInfo) {
        userDataValidate(registerUserInfo);
        register(registerUserInfo);
    }

    private void register(RegisterUserInfo registerUserInfo) {
        UserInfo userInfo = new UserInfo(registerUserInfo);
        userInfoService.register(userInfo);
        userInfoService.insertUserVipRelation(getUserVipRelation(userInfo.getId()));
    }

    private UserVipRelation getUserVipRelation(Integer userId){
        UserVipRelation userVipRelation = new UserVipRelation();
        userVipRelation.setUserId(userId);
        userVipRelation.setVipId(vipInfoService.getRandomVipInfo().getId());
        return userVipRelation;
    }

    private void userDataValidate(RegisterUserInfo registerUserInfo) {
        UserInfo userInfoForDB = userInfoService.getUserByNameOrPhoneOrEmail(registerUserInfo.getUserName(), registerUserInfo.getPhone(), registerUserInfo.getEmail());
        if (userInfoForDB != null && registerUserInfo.getUserName().equals(userInfoForDB.getUserName())) {
            throw new SellSoftwareException(SellSoftwareExceptionEnum.USER_NAME_EXIST);
        }
        if (userInfoForDB != null && registerUserInfo.getPhone().equals(userInfoForDB.getPhone())) {
            throw new SellSoftwareException(SellSoftwareExceptionEnum.USER_PHONE_EXIST);
        }
        if (userInfoForDB != null && registerUserInfo.getEmail().equals(userInfoForDB.getEmail())) {
            throw new SellSoftwareException(SellSoftwareExceptionEnum.USER_EMAIL_EXIST);
        }
    }
}
