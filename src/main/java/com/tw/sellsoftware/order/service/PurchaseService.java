package com.tw.sellsoftware.order.service;

import com.tw.sellsoftware.order.domain.OrderDetail;
import com.tw.sellsoftware.order.domain.OrderDetailParam;
import com.tw.sellsoftware.order.domain.OrderInfo;
import com.tw.sellsoftware.order.domain.PurchaseParam;
import com.tw.sellsoftware.order.mapper.OrderDetailMapper;
import com.tw.sellsoftware.order.mapper.OrderInfoMapper;
import com.tw.sellsoftware.software.domain.SoftwareInfo;
import com.tw.sellsoftware.software.mapper.SoftwareInfoMapper;
import com.tw.sellsoftware.software.service.SoftwareInfoService;
import com.tw.sellsoftware.usercenter.domain.UserVipRelation;
import com.tw.sellsoftware.usercenter.domain.VipInfo;
import com.tw.sellsoftware.usercenter.mapper.UserVipRelationMapper;
import com.tw.sellsoftware.usercenter.mapper.VipInfoMapper;
import com.tw.sellsoftware.usercenter.service.UserVipRelationService;
import com.tw.sellsoftware.usercenter.service.VipInfoService;
import com.tw.sellsoftware.utils.CommonUtils;
import com.tw.sellsoftware.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseService {

    private final UserVipRelationService userVipRelationService;

    private final VipInfoService vipInfoService;

    private final SoftwareInfoService softwareInfoService;

    private final OrderInfoMapper orderInfoMapper;

    private final OrderDetailMapper orderDetailMapper;

    public PurchaseService(UserVipRelationService userVipRelationService, VipInfoService vipInfoService, SoftwareInfoService softwareInfoService, OrderInfoMapper orderInfoMapper, OrderDetailMapper orderDetailMapper) {
        this.userVipRelationService = userVipRelationService;
        this.vipInfoService = vipInfoService;
        this.softwareInfoService = softwareInfoService;
        this.orderInfoMapper = orderInfoMapper;
        this.orderDetailMapper = orderDetailMapper;
    }

    public void purchaseSoftware(PurchaseParam purchaseParam, HttpServletRequest request) throws Exception {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(CommonUtils.getCurrentUserId(request));
        orderInfo.setOrderStatus(Constant.ORDER_STATUS_INIT);
        orderInfo.setOrderPrice(purchaseParam.getOrderPrice());
        orderInfo.setPayTime(LocalDateTime.now());
        orderInfo.setCreateTime(LocalDateTime.now());
        orderInfoMapper.insertOrderInfo(orderInfo);
        List<OrderDetail> list = new ArrayList();
        for (OrderDetailParam detailParam : purchaseParam.getOrderDetailList()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderInfo.getId());
            orderDetail.setUserId(CommonUtils.getCurrentUserId(request));
            orderDetail.setSoftwareId(detailParam.getSoftwareId());
            orderDetail.setSoftwarePrice(detailParam.getSoftwarePrice());
            orderDetail.setDiscount(new BigDecimal(purchaseParam.getDiscount()));
            orderDetail.setCreateTime(LocalDateTime.now());
            list.add(orderDetail);
        }
        orderDetailMapper.insertDetailBatch(list);
    }

    public Optional<String> purchaseParamValidate(PurchaseParam purchaseParam, HttpServletRequest request) throws Exception {
        if (purchaseParam == null || purchaseParam.getOrderPrice() == null || purchaseParam.getOrderDetailList() == null || purchaseParam.getOrderDetailList().isEmpty()) {
            return Optional.of("Request parameter error!");
        }
        if (purchaseParam.getDiscount() > 1 || purchaseParam.getDiscount() <= 0) {
            return Optional.of("Request parameter error!");
        } else if (purchaseParam.getDiscount() < 1) {
            UserVipRelation userVipRelation = userVipRelationService.selectByUserId(CommonUtils.getCurrentUserId(request));
            if (userVipRelation == null) {
                return Optional.of("You are not a vip user,so cannot enjoy a discount!");
            }
            VipInfo vipInfo = vipInfoService.selectVipInfoById(userVipRelation.getVipId());
            if (vipInfo == null || vipInfo.getDiscount() == null) {
                return Optional.of("You are not a vip user,so cannot enjoy a discount!");
            }
            if (BigDecimal.valueOf(purchaseParam.getDiscount()).compareTo(vipInfo.getDiscount()) != 0) {
                return Optional.of("Your membership level does not match the discount!");
            }
        }
        return Optional.empty();
    }

    public Optional<String> dataSafetyValidate(PurchaseParam purchaseParam) {
        SoftwareInfo softwareInfo = null;
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderDetailParam detailParam : purchaseParam.getOrderDetailList()) {
            softwareInfo = softwareInfoService.querySoftwareById(detailParam.getSoftwareId());
            if (softwareInfo == null || softwareInfo.getSoftwarePrice() == null) {
                return Optional.of("Request parameter error!");
            }
            if (detailParam.getSoftwarePrice().compareTo(softwareInfo.getSoftwarePrice()) != 0) {
                return Optional.of("Request parameter error!");
            }
            totalPrice = totalPrice.add(softwareInfo.getSoftwarePrice());
        }
        totalPrice = totalPrice.multiply(new BigDecimal(purchaseParam.getDiscount())).setScale(2, BigDecimal.ROUND_DOWN);
        if (purchaseParam.getOrderPrice().compareTo(totalPrice) != 0) {
            return Optional.of("Request parameter error!");
        }
        return Optional.empty();
    }

}
