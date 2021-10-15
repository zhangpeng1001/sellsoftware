package com.tw.sellsoftware.order.service;

import com.tw.sellsoftware.order.domain.OrderInfo;
import com.tw.sellsoftware.utils.CommonUtils;
import com.tw.sellsoftware.utils.PageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    public void saveOrderInfo(OrderInfo orderInfo) {
        //TODO save OrderInfo data to DB
    }

    public Optional<List<OrderInfo>> getHistoryOrderInfo(PageInfo pageInfo) {
        return Optional.ofNullable(queryOrderInfo(pageInfo, CommonUtils.getCurrentUserId()));
    }

    private List<OrderInfo> queryOrderInfo(PageInfo pageInfo, String userId) {
        //TODO query OrderInfo data from DB
        return new ArrayList<>();
    }
}
