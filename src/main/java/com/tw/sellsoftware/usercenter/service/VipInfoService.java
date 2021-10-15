package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.VipInfo;

import java.util.List;

@FunctionalInterface
public interface VipInfoService {

    List<VipInfo> getVipInfo();
}
