package com.tw.sellsoftware.order.domain;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseParam {

    private double discount;

    private BigDecimal orderPrice;

    List<OrderDetailParam> orderDetailList;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public List<OrderDetailParam> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetailParam> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
