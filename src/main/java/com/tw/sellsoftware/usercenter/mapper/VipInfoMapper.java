package com.tw.sellsoftware.usercenter.mapper;

import com.tw.sellsoftware.usercenter.domain.VipInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VipInfoMapper {

    VipInfo selectVipInfoById(Integer id);

    VipInfo getRandomVipInfo();

}