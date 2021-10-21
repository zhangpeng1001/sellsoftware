package com.tw.sellsoftware.order.controller;

import com.tw.sellsoftware.order.domain.PurchaseParam;
import com.tw.sellsoftware.order.service.OrderService;
import com.tw.sellsoftware.order.service.PurchaseService;
import com.tw.sellsoftware.usercenter.domain.UserInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class PurchaseControllerTest {


    @InjectMocks
    private PurchaseController purchaseController;

    @Mock
    private PurchaseService purchaseService;

    @Test
    void purchaseSoftwareForSuccess() {
//        PurchaseParam purchaseParam = new PurchaseParam();
//        Mockito.when(purchaseService.purchaseSoftware(purchaseParam)).thenReturn(Optional.empty());
//        assertEquals(purchaseController.purchaseSoftware(purchaseParam).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void purchaseSoftwareForFail() {
//        PurchaseParam purchaseParam = new PurchaseParam();
//        Mockito.when(purchaseService.purchaseSoftware(purchaseParam)).thenReturn(Optional.of("error msg"));
//        assertEquals(purchaseController.purchaseSoftware(purchaseParam).getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}