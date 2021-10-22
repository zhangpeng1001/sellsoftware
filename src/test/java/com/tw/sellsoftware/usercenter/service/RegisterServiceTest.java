package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
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
class RegisterServiceTest {

    @InjectMocks
    private RegisterService registerService;

    @Mock
    private UserInfoService userInfoService;

    @Test
    void userRegisterForSuccess() {
//        UserInfo userInfo = getUserInfo();
//        Mockito.when(userInfoService.getUserByPhoneOrEmail(userInfo)).thenReturn(new UserInfo());
//        assertEquals(registerService.userRegister(userInfo).isPresent(), false);
    }

    @Test
    void userRegisterForFail() {
//        UserInfo userInfo = new UserInfo();
//        assertEquals(registerService.userRegister(userInfo).isPresent(), true);
//        userInfo.setUserName("testUser");
//        assertEquals(registerService.userRegister(userInfo).isPresent(), true);
//        userInfo.setPhone("13109248765");
//        assertEquals(registerService.userRegister(userInfo).isPresent(), true);
//        userInfo.setEmail("12306@163.com");
//        assertEquals(registerService.userRegister(userInfo).isPresent(), true);
//        userInfo.setPassword("123456");
//        UserInfo userInfoForDB = new UserInfo();
//        userInfoForDB.setPhone("13109248764");
//        userInfoForDB.setEmail("12307@163.com");
//        Mockito.when(userInfoService.getUserByPhoneOrEmail(userInfo)).thenReturn(userInfoForDB);
//        assertEquals(registerService.userRegister(userInfo).isPresent(), true);
//        userInfoForDB.setPhone("");
//        Mockito.when(userInfoService.getUserByPhoneOrEmail(userInfo)).thenReturn(userInfoForDB);
//        assertEquals(registerService.userRegister(userInfo).isPresent(), true);
//        userInfoForDB.setEmail("");
//        Mockito.when(userInfoService.getUserByPhoneOrEmail(userInfo)).thenReturn(userInfoForDB);
//        assertEquals(registerService.userRegister(userInfo).isPresent(), false);
    }

    private UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("testUser");
        userInfo.setPhone("13109248765");
        userInfo.setEmail("12306@163.com");
        userInfo.setPassword("123456");
        return userInfo;
    }
}