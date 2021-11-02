package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.service.RegisterService;
import com.tw.sellsoftware.usercenter.vo.RegisterUserInfo;
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
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class RegisterControllerTest {


    @InjectMocks
    private RegisterController registerController;

    @Mock
    private RegisterService registerService;

    @Test
    void userRegisterForSuccess() {
        Mockito.doNothing().when(registerService).userRegister(Mockito.any());
        assertEquals(registerController.userRegister(new RegisterUserInfo()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void userRegisterFailure() {
        Mockito.doThrow(new SellSoftwareException(SellSoftwareExceptionEnum.USER_NAME_EXIST)).when(registerService).userRegister(Mockito.any());
        assertThrows(SellSoftwareException.class, () -> registerController.userRegister(new RegisterUserInfo()));
    }
}