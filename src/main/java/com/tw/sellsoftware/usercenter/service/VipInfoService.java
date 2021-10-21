package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.VipInfo;
import com.tw.sellsoftware.usercenter.mapper.VipInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class VipInfoService {

    private final VipInfoMapper vipInfoMapper;

    public VipInfoService(VipInfoMapper vipInfoMapper) {
        this.vipInfoMapper = vipInfoMapper;
    }


    public VipInfo selectVipInfoById(Integer id) {
        return vipInfoMapper.selectVipInfoById(id);
    }

    public VipInfo getRandomVipInfo() {
        return vipInfoMapper.getRandomVipInfo();
    }

}
