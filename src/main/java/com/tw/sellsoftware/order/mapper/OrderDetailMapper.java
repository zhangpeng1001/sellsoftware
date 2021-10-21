package com.tw.sellsoftware.order.mapper;

import com.tw.sellsoftware.order.domain.OrderDetail;

import java.util.List;

public interface OrderDetailMapper {

    int insert(OrderDetail record);

    void insertDetailBatch(List<OrderDetail> list);
}