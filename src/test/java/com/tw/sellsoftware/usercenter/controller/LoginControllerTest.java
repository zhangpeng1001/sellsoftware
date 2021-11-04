package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.service.LoginService;
import com.tw.sellsoftware.usercenter.vo.LoginUserInfo;
import com.tw.sellsoftware.utils.SellSoftwareException;
import com.tw.sellsoftware.utils.enums.SellSoftwareExceptionEnum;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        Mockito.when(loginService.userLogin(Mockito.any())).thenReturn("");
        assertEquals(HttpStatus.OK, loginController.userLogin(new LoginUserInfo()).getStatusCode());
    }

    @Test
    void userLoginForFail() {
        Mockito.when(loginService.userLogin(Mockito.any())).thenThrow(new SellSoftwareException(SellSoftwareExceptionEnum.USER_OR_PASSWORD_ERROR));
        assertEquals(HttpStatus.BAD_REQUEST, loginController.userLogin(new LoginUserInfo()).getStatusCode());
    }
}