package com.tw.sellsoftware.order.controller;

import com.tw.sellsoftware.order.domain.OrderInfo;
import com.tw.sellsoftware.order.service.OrderService;
import com.tw.sellsoftware.software.controller.SoftwareInfoController;
import com.tw.sellsoftware.software.domain.SoftwareInfo;
import com.tw.sellsoftware.software.service.SoftwareInfoService;
import com.tw.sellsoftware.utils.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @Test
    void getHistoryOrderInfoForsuccess() {
        List<OrderInfo> list = new ArrayList<>();
        Optional<List<OrderInfo>> softList = Optional.of(list);
        Mockito.when(orderService.getHistoryOrderInfo(Mockito.any())).thenReturn(softList);
        assertEquals(orderController.getHistoryOrderInfo(0, 10).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getSoftwareInfoForError() {
        Optional<List<OrderInfo>> softList = Optional.empty();
        Mockito.when(orderService.getHistoryOrderInfo(Mockito.any())).thenReturn(softList);
        assertEquals(orderController.getHistoryOrderInfo(0, 10).getStatusCode(), HttpStatus.NOT_FOUND);
    }
}