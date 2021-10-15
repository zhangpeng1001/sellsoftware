package com.tw.sellsoftware.order.service;

import com.tw.sellsoftware.order.domain.OrderInfo;
import com.tw.sellsoftware.order.domain.PurchaseParam;
import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.domain.VipInfo;
import com.tw.sellsoftware.usercenter.service.UserInfoService;
import com.tw.sellsoftware.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private UserInfoService UserInfoService;

    @Autowired
    private OrderService orderService;

    public Optional<String> purchase(PurchaseParam purchaseParam) {
        VipInfo vipInfo = getVipInfo();
        if (purchaseParam.isHaveDiscount()) {
            Optional<String> valid = haveDiscountValid(purchaseParam, vipInfo);
            if (valid.isPresent()) {
                return valid;
            }
        }
        BigDecimal payPrice = calucatePrice(purchaseParam, vipInfo);
        boolean payResult = CommonUtils.payResult(payPrice);
        seveOrderInfo(purchaseParam, payResult, payPrice);
        if (!payResult) {
            return Optional.of("Pay failed,please try again!");
        }
        return Optional.empty();
    }

    private VipInfo getVipInfo() {
        UserInfo userInfo = UserInfoService.getUserByUserId(CommonUtils.getCurrentUserId());
        return CommonUtils.getVipInfos().stream().filter(vipInfo -> vipInfo.getVipGrade().equals(userInfo.getVipGrade())).findFirst().orElse(null);
    }

    private Optional<String> haveDiscountValid(PurchaseParam purchaseParam, VipInfo vipInfo) {
        if (purchaseParam.getDiscount() > 1) {
            return Optional.of("Request parameter error!");
        }
        if (vipInfo == null) {
            return Optional.of("You are not a vip user,so cannot enjoy a discount!");
        }
        if (purchaseParam.getDiscount() != vipInfo.getDiscount()) {
            return Optional.of("Your membership level does not match the discount!");
        }
        return Optional.empty();
    }

    private BigDecimal calucatePrice(PurchaseParam purchaseParam, VipInfo vipInfo) {
        BigDecimal price = purchaseParam.getUnitPrice().multiply(BigDecimal.valueOf(purchaseParam.getPurchaseAmount()));
        if (purchaseParam.isHaveDiscount() && vipInfo != null) {
            return price.multiply(BigDecimal.valueOf(vipInfo.getDiscount()));
        }
        return price;
    }

    private void seveOrderInfo(PurchaseParam purchaseParam, boolean payResult, BigDecimal payPrice) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(CommonUtils.getCurrentUserId());
        orderInfo.setSoftwareId(purchaseParam.getSoftwareId());
        orderInfo.setOrderStatus(payResult == true ? "0" : "1");
        orderInfo.setOrderPrice(payPrice);
        orderInfo.setDiscount(purchaseParam.getDiscount());
        orderInfo.setPayTime(LocalDateTime.now());
        orderService.saveOrderInfo(orderInfo);
    }

}
