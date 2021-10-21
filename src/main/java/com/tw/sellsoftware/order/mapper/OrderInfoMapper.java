package com.tw.sellsoftware.order.mapper;

import com.tw.sellsoftware.order.domain.OrderInfo;
import com.tw.sellsoftware.utils.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoMapper {

    int insertOrderInfo(OrderInfo orderInfo);

    List<OrderInfo> queryOrderList(@Param("pageInfo") PageInfo pageInfo, @Param("userId") int userId);
}