package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
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

    @Test
    void userLoginForSuccess() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("testUser");
        userInfo.setPassword("123456");
        Mockito.when(loginService.userLogin(userInfo)).thenReturn(Optional.empty());
        assertEquals(loginController.userLogin(userInfo).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void userLoginForFail() {
        UserInfo userInfo = null;
        assertEquals(loginController.userLogin(userInfo).getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        userInfo = new UserInfo();
        assertEquals(loginController.userLogin(userInfo).getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        userInfo.setUserName("testUser");
        assertEquals(loginController.userLogin(userInfo).getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        userInfo.setPassword("123456");
        Mockito.when(loginService.userLogin(userInfo)).thenReturn(Optional.of("error msg"));
        assertEquals(loginController.userLogin(userInfo).getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}