package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.VipInfo;
import com.tw.sellsoftware.usercenter.mapper.VipInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VipInfoService {

    @Autowired
    private VipInfoMapper vipInfoMapper;


    public VipInfo selectVipInfoById(Integer id) {
        return vipInfoMapper.selectVipInfoById(id);
    }

    public VipInfo getRandomVipInfo() {
        return vipInfoMapper.getRandomVipInfo();
    }

}
