package com.tw.sellsoftware.order.service;

import com.tw.sellsoftware.order.domain.OrderInfo;
import com.tw.sellsoftware.order.domain.PurchaseParam;
import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.domain.VipInfo;
import com.tw.sellsoftware.usercenter.service.UserInfoService;
import com.tw.sellsoftware.utils.CommonUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class PurchaseServiceTest {

    @InjectMocks
    private PurchaseService purchaseService;

    @Mock
    private UserInfoService userInfoService;

    @Mock
    private OrderService orderService;

    @Test
    void purchaseSoftwareSuccessForNoDiscount() {
//        Mockito.when(userInfoService.getUserByUserId(Mockito.anyString())).thenReturn(new UserInfo());
//        Mockito.doNothing().when(orderService).saveOrderInfo(Mockito.any());
//        assertEquals(purchaseService.purchaseSoftware(getPurchaseParam()).isPresent(), false);
    }

    @Test
    void purchaseSoftwareSuccessForDiscount() {
//        PurchaseParam purchaseParam = getPurchaseParam();
//        purchaseParam.setHaveDiscount(true);
//        purchaseParam.setDiscount(0.8d);
//        UserInfo userinfo = new UserInfo();
//        userinfo.setVipGrade("1");
//        Mockito.when(userInfoService.getUserByUserId(Mockito.anyString())).thenReturn(userinfo);
//        Mockito.doNothing().when(orderService).saveOrderInfo(Mockito.any());
//        assertEquals(purchaseService.purchaseSoftware(getPurchaseParam()).isPresent(), false);
    }

    @Test
    void purchaseSoftwareFailOfNoVipInfo() {
//        PurchaseParam purchaseParam = getPurchaseParam();
//        purchaseParam.setHaveDiscount(true);
//        purchaseParam.setDiscount(0.8d);
//        Mockito.when(userInfoService.getUserByUserId(Mockito.anyString())).thenReturn(new UserInfo());
//        Mockito.doNothing().when(orderService).saveOrderInfo(Mockito.any());
//        assertEquals(purchaseService.purchaseSoftware(purchaseParam).isPresent(), true);
    }

    @Test
    void purchaseSoftwareOfDiscountNotMatch() {
//        PurchaseParam purchaseParam = getPurchaseParam();
//        purchaseParam.setHaveDiscount(true);
//        purchaseParam.setDiscount(0.6d);
//        UserInfo userinfo = new UserInfo();
//        userinfo.setVipGrade("1");
//        Mockito.when(userInfoService.getUserByUserId(Mockito.anyString())).thenReturn(userinfo);
//        Mockito.doNothing().when(orderService).saveOrderInfo(Mockito.any());
//        assertEquals(purchaseService.purchaseSoftware(purchaseParam).isPresent(), true);
    }

    @Test
    void purchaseSoftwareOfDiscountError() {
//        PurchaseParam purchaseParam = getPurchaseParam();
//        purchaseParam.setHaveDiscount(true);
//        purchaseParam.setDiscount(1.2d);
//        UserInfo userinfo = new UserInfo();
//        userinfo.setVipGrade("1");
//        Mockito.when(userInfoService.getUserByUserId(Mockito.anyString())).thenReturn(userinfo);
//        Mockito.doNothing().when(orderService).saveOrderInfo(Mockito.any());
//        assertEquals(purchaseService.purchaseSoftware(purchaseParam).isPresent(), true);
    }

    private PurchaseParam getPurchaseParam() {
        PurchaseParam purchaseParam = new PurchaseParam();
        purchaseParam.setHaveDiscount(false);
        purchaseParam.setPurchaseAmount(2);
        purchaseParam.setSoftwareId("1");
        purchaseParam.setUnitPrice(BigDecimal.valueOf(1001));
        return purchaseParam;
    }
}