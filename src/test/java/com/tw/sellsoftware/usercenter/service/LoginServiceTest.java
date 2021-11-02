package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.vo.LoginUserInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class LoginServiceTest {

    @InjectMocks
    private LoginService loginService;

    @Mock
    private UserInfoService userInfoService;

    private MockHttpServletRequest request;

    private MockHttpSession session;

    @Test
    void userLoginForSuccess() {
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        session = new MockHttpSession();
        session.setAttribute("","");
        LoginUserInfo userInfo = getUserInfo();
        Mockito.when(userInfoService.getUserByUserName("testUser")).thenReturn(getUserInfoForDB());
        assertEquals(loginService.userLogin(userInfo,request).isPresent(), false);
    }

    @Test
    void userLoginFailureOfUserNotExist() {
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        LoginUserInfo userInfo = getUserInfo();
        Mockito.when(userInfoService.getUserByUserName("testUser")).thenReturn(null);
        assertTrue(loginService.userLogin(userInfo, request).isPresent());
    }

    @Test
    void userLoginFailureOfErrorPassword() {
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        LoginUserInfo userInfo = getUserInfo();
        UserInfo userInfoForDB = new UserInfo();
        userInfoForDB.setPassword("abcde");
        Mockito.when(userInfoService.getUserByUserName("testUser")).thenReturn(userInfoForDB);
        assertTrue(loginService.userLogin(userInfo, request).isPresent());
    }

    private LoginUserInfo getUserInfo() {
        LoginUserInfo userInfo = new LoginUserInfo();
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