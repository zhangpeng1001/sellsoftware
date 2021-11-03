package com.tw.sellsoftware.order.service;

import com.tw.sellsoftware.order.mapper.OrderInfoMapper;
import com.tw.sellsoftware.utils.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class OrderServiceTest {

    private final int userId = 1;

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderInfoMapper orderInfoMapper;

    @Test
    void getHistoryOrderInfoForList() {
        Mockito.when(orderInfoMapper.queryOrderList(Mockito.any(), Mockito.anyInt())).thenReturn(new ArrayList<>());
        assertTrue(orderService.getHistoryOrderInfo(new PageInfo(), userId).isPresent());
    }

    @Test
    void getHistoryOrderInfoForNull() {
        Mockito.when(orderInfoMapper.queryOrderList(Mockito.any(), Mockito.anyInt())).thenReturn(null);
        assertFalse(orderService.getHistoryOrderInfo(new PageInfo(), userId).isPresent());
    }

}