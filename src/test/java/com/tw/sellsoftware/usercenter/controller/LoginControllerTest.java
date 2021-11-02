package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.service.LoginService;
import com.tw.sellsoftware.usercenter.vo.LoginUserInfo;
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
        Mockito.when(loginService.userLogin(Mockito.any(),Mockito.any())).thenReturn(Optional.empty());
        assertEquals(HttpStatus.OK,loginController.userLogin(new LoginUserInfo(),request).getStatusCode());
    }

    @Test
    void userLoginForFail() {
        Mockito.when(loginService.userLogin(Mockito.any(),Mockito.any())).thenReturn(Optional.of("error msg"));
        assertEquals(HttpStatus.BAD_REQUEST,loginController.userLogin(new LoginUserInfo(),request).getStatusCode());
    }
}