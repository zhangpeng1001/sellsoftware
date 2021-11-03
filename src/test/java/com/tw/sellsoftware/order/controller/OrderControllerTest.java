package com.tw.sellsoftware.order.controller;

import com.tw.sellsoftware.order.service.OrderService;
import com.tw.sellsoftware.usercenter.domain.UserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class OrderControllerTest {

    private final int page_num = 0;
    private final int page_size = 10;
    private final int userId = 1;

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    private MockHttpServletRequest request;

    @Test
    void getHistoryOrderInfoForList() {
        Mockito.when(orderService.getHistoryOrderInfo(Mockito.any(), Mockito.anyInt())).thenReturn(Optional.of(new ArrayList<>()));
        assertNotNull(orderController.getHistoryOrderInfo(page_num, page_size, request).getBody());
    }

    @Test
    void getSoftwareInfoForNull() {
        Mockito.when(orderService.getHistoryOrderInfo(Mockito.any(), Mockito.anyInt())).thenReturn(Optional.empty());
        assertNull(orderController.getHistoryOrderInfo(page_num, page_size, request).getBody());
    }

    @BeforeEach
    public void initHttpServletRequest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        request = new MockHttpServletRequest();
        request.getSession().setAttribute("userInfo", userInfo);
    }
}
