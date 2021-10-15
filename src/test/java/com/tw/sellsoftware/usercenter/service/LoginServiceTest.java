package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class LoginServiceTest {

    @InjectMocks
    private LoginService loginService;

    @Mock
    private UserInfoService userInfoService;

    @Test
    void userLoginForSuccess() {
        UserInfo userInfo = getUserInfo();
        Mockito.when(userInfoService.getUserByUserName("testUser")).thenReturn(getUserInfoForDB());
        assertEquals(loginService.userLogin(userInfo).isPresent(), false);
    }

    @Test
    void userLoginForFail() {
        UserInfo userInfo = getUserInfo();
        Mockito.when(userInfoService.getUserByUserName("testUser")).thenReturn(null);
        assertEquals(loginService.userLogin(userInfo).isPresent(), true);
        UserInfo userInfoForDB = new UserInfo();
        userInfoForDB.setUserName("testUser");
        userInfoForDB.setPassword("abcde");
        Mockito.when(userInfoService.getUserByUserName("testUser")).thenReturn(userInfoForDB);
        assertEquals(loginService.userLogin(userInfo).isPresent(), true);
    }

    private UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("testUser");
        userInfo.setPassword("123456");
        return userInfo;
    }

    private UserInfo getUserInfoForDB() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("testUser");
        userInfo.setPassword("123456");
        return userInfo;
    }
}