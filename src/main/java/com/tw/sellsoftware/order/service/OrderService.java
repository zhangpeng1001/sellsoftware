package com.tw.sellsoftware.order.service;

import com.tw.sellsoftware.order.domain.OrderInfo;
import com.tw.sellsoftware.order.mapper.OrderInfoMapper;
import com.tw.sellsoftware.utils.CommonUtils;
import com.tw.sellsoftware.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderInfoMapper orderInfoMapper;

    public OrderService(OrderInfoMapper orderInfoMapper) {
        this.orderInfoMapper = orderInfoMapper;
    }

    public Optional<List<OrderInfo>> getHistoryOrderInfo(PageInfo pageInfo, HttpServletRequest request) throws Exception {
        return Optional.ofNullable(orderInfoMapper.queryOrderList(pageInfo, CommonUtils.getCurrentUserId(request)));
    }

}
