package com.tw.sellsoftware.utils;

import com.tw.sellsoftware.order.service.PayService;
import com.tw.sellsoftware.usercenter.domain.VipInfo;
import com.tw.sellsoftware.usercenter.service.VipInfoService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

    public static String getCurrentUserId() {
        //TODO need to obtain current user ID from session/redis
        return "";
    }

    public static boolean payResult(BigDecimal payPrice) {
        PayService payService = price -> {
            if (price.doubleValue() > 0) {
                return true;
            } else {
                return false;
            }
        };
        return payService.pay(payPrice);
    }
}
