package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.domain.VipInfo;
import com.tw.sellsoftware.usercenter.vo.RegisterUserInfo;
import com.tw.sellsoftware.utils.SellSoftwareException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class RegisterServiceTest {

    private final String USER_NAME = "testUser";

    private final String USER_PHONE = "13109248765";

    private final String USER_EMAIL = "12306@163.com";

    @InjectMocks
    private RegisterService registerService;

    @Mock
    private UserInfoService userInfoService;

    @Mock
    private VipInfoService vipInfoService;

    @Test
    void userRegisterForSuccess() {
        Mockito.when(userInfoService.getUserByNameOrPhoneOrEmail(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(new UserInfo());
        Mockito.when(userInfoService.register(Mockito.any())).thenReturn(1);
        Mockito.when(userInfoService.insertUserVipRelation(Mockito.any())).thenReturn(1);
        Mockito.when(vipInfoService.getRandomVipInfo()).thenReturn(new VipInfo());
        registerService.userRegister(getRegisterUserInfo());
    }

    @Test
    void userRegisterForFailureOfUserNameExist() {
        UserInfo userInfoForDB = new UserInfo();
        userInfoForDB.setUserName(USER_NAME);
        Mockito.when(userInfoService.getUserByNameOrPhoneOrEmail(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(userInfoForDB);
        assertThrows(SellSoftwareException.class, () -> registerService.userRegister(getRegisterUserInfo()));
    }

    @Test
    void userRegisterForFailureOfPhoneNumExist() {
        UserInfo userInfoForDB = new UserInfo();
        userInfoForDB.setPhone(USER_PHONE);
        Mockito.when(userInfoService.getUserByNameOrPhoneOrEmail(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(userInfoForDB);
        assertThrows(SellSoftwareException.class, () -> registerService.userRegister(getRegisterUserInfo()));
    }

    @Test
    void userRegisterForFailureOfEmailExist() {
        UserInfo userInfoForDB = new UserInfo();
        userInfoForDB.setEmail(USER_EMAIL);
        Mockito.when(userInfoService.getUserByNameOrPhoneOrEmail(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(userInfoForDB);
        assertThrows(SellSoftwareException.class, () -> registerService.userRegister(getRegisterUserInfo()));
    }

    private RegisterUserInfo getRegisterUserInfo() {
        RegisterUserInfo userInfo = new RegisterUserInfo();
        userInfo.setUserName(USER_NAME);
        userInfo.setPhone(USER_PHONE);
        userInfo.setEmail(USER_EMAIL);
        return userInfo;
    }
}