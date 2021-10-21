package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.service.LoginService;
import com.tw.sellsoftware.usercenter.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class RegisterControllerTest {


    @InjectMocks
    private RegisterController registerController;

    @Mock
    private RegisterService registerService;

    @Test
    void userRegisterForSuccess() {
//        UserInfo userInfo = new UserInfo();
//        Mockito.when(registerService.userRegister(userInfo)).thenReturn(Optional.empty());
//        assertEquals(registerController.userRegister(userInfo).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void userRegisterForFail() {
//        UserInfo userInfo = null;
//        assertEquals(registerController.userRegister(userInfo).getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
//        userInfo = new UserInfo();
//        Mockito.when(registerService.userRegister(userInfo)).thenReturn(Optional.of("error msg"));
//        assertEquals(registerController.userRegister(userInfo).getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}