package com.tw.sellsoftware.order.service;

import java.math.BigDecimal;

@FunctionalInterface
public interface PayService {

    boolean pay(BigDecimal price);
}
