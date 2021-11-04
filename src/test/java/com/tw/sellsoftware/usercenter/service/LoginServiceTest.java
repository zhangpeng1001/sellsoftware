package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.LoginToken;
import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.mapper.LoginTakenMapper;
import com.tw.sellsoftware.usercenter.vo.LoginUserInfo;
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
class LoginServiceTest {

    private final String USER_NAME = "testUser";

    private final String PASS_WORD = "123456";

    @InjectMocks
    private LoginService loginService;

    @Mock
    private UserInfoService userInfoService;

    @Mock
    private LoginTakenMapper loginTakenMapper;

    @Test
    void userLoginForSuccess() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setPassword(PASS_WORD);
        Mockito.when(userInfoService.getUserByUserName(USER_NAME)).thenReturn(userInfo);
        Mockito.when(loginTakenMapper.insertLoginToken(Mockito.any())).thenReturn(1);
        assertTrue(loginService.userLogin(getLoginUserInfo()).length() > 0);
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

    @Test
    void getLoginTokenByTokenSuccess(){
        Mockito.when(loginTakenMapper.getLoginTokenByToken(Mockito.any())).thenReturn(new LoginToken());
        assertTrue(loginService.getLoginTokenByToken("").isPresent());
    }

    @Test
    void getLoginTokenByTokenOfNull(){
        Mockito.when(loginTakenMapper.getLoginTokenByToken(Mockito.any())).thenReturn(null);
        assertFalse(loginService.getLoginTokenByToken("").isPresent());
    }

    private LoginUserInfo getLoginUserInfo() {
        LoginUserInfo userInfo = new LoginUserInfo();
        userInfo.setUserName(USER_NAME);
        userInfo.setPassword(PASS_WORD);
        return userInfo;
    }
}