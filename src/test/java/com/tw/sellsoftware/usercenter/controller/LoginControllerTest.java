package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private LoginService loginService;

    private MockHttpServletRequest request;

    private MockHttpSession session;

    @Test
    void userLoginForSuccess() {
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        session = new MockHttpSession();
        Mockito.when(loginService.userLogin(Mockito.any())).thenReturn(new UserInfo());
        assertEquals(HttpStatus.OK, loginController.userLogin(new LoginUserInfo(), request).getStatusCode());
    }

    @Test
    void userLoginForFail() {
        Mockito.when(loginService.userLogin(Mockito.any())).thenThrow(new SellSoftwareException(SellSoftwareExceptionEnum.USER_NOT_EXIST));
        assertThrows(SellSoftwareException.class, () -> loginController.userLogin(new LoginUserInfo(), request));
    }
}