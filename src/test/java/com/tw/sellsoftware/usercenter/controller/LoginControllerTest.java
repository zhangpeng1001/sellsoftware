package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.domain.LoginUserInfo;
import com.tw.sellsoftware.usercenter.service.LoginService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private LoginService loginService;

    private MockHttpServletRequest request;

    @Before
    void beforeMethod(){
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
    }

    @Test
    void userLoginForSuccess() {
        LoginUserInfo userInfo = new LoginUserInfo();
        userInfo.setUserName("testUser");
        userInfo.setPassword("123456");
        Mockito.when(loginService.userLogin(Mockito.any(),Mockito.any())).thenReturn(Optional.empty());
        assertEquals(loginController.userLogin(userInfo,request).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void userLoginForFail() {
        LoginUserInfo userInfo = new LoginUserInfo();
        userInfo.setUserName("testUser");
        userInfo.setPassword("123456");
        Mockito.when(loginService.userLogin(Mockito.any(),Mockito.any())).thenReturn(Optional.of("error msg"));
        assertEquals(loginController.userLogin(userInfo,request).getBody(), "error msg");
    }
}