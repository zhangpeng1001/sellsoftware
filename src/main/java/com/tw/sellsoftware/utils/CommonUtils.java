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

    public static List<VipInfo> getVipInfos() {
        VipInfoService vipInfoService = () -> {
            List<VipInfo> list = new ArrayList<>();
            VipInfo vipInfo = new VipInfo();
            vipInfo.setId("1");
            vipInfo.setDiscount(0.8d);
            vipInfo.setVipGrade("1");
            list.add(vipInfo);
            VipInfo vipInfo1 = new VipInfo();
            vipInfo1.setId("2");
            vipInfo1.setDiscount(0.6d);
            vipInfo1.setVipGrade("2");
            list.add(vipInfo1);
            return list;
        };
        return vipInfoService.getVipInfo();
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
