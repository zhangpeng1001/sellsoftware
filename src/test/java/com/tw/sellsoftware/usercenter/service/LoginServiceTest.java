package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.vo.LoginUserInfo;
import com.tw.sellsoftware.utils.SellSoftwareException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class LoginServiceTest {

    private final String USER_NAME = "testUser";

    private final String PASS_WORD = "123456";

    @InjectMocks
    private LoginService loginService;

    @Mock
    private UserInfoService userInfoService;

    @Test
    void userLoginForSuccess() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword(PASS_WORD);
        Mockito.when(userInfoService.getUserByUserName(USER_NAME)).thenReturn(userInfo);
        assertNotEquals(null, loginService.userLogin(getLoginUserInfo()));
    }

    @Test
    void userLoginFailureOfUserNotExist() {
        Mockito.when(userInfoService.getUserByUserName(USER_NAME)).thenReturn(null);
        assertThrows(SellSoftwareException.class, () -> loginService.userLogin(getLoginUserInfo()));
    }

    @Test
    void userLoginFailureOfErrorPassword() {
        Mockito.when(userInfoService.getUserByUserName(USER_NAME)).thenReturn(new UserInfo());
        assertThrows(SellSoftwareException.class, () -> loginService.userLogin(getLoginUserInfo()));
    }

    private LoginUserInfo getLoginUserInfo() {
        LoginUserInfo userInfo = new LoginUserInfo();
        userInfo.setUserName(USER_NAME);
        userInfo.setPassword(PASS_WORD);
        return userInfo;
    }
}