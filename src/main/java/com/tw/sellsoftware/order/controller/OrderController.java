package com.tw.sellsoftware.order.controller;

import com.tw.sellsoftware.order.domain.OrderInfo;
import com.tw.sellsoftware.order.service.OrderService;
import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.utils.Constant;
import com.tw.sellsoftware.utils.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/list/{pageNum}/{pageSize}")
    public ResponseEntity getHistoryOrderInfo(@PathVariable int pageNum, @PathVariable int pageSize, HttpServletRequest request) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        Optional<List<OrderInfo>> orderList = orderService.getHistoryOrderInfo(pageInfo,(Integer)request.getAttribute(Constant.USER_ID));
        return orderList.map(orderInfos -> ResponseEntity.ok(orderInfos)).orElseGet(() -> ResponseEntity.ok(null));
    }
}
