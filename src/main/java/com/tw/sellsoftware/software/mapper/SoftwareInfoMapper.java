package com.tw.sellsoftware.software.mapper;

import com.tw.sellsoftware.software.domain.SoftwareInfo;
import com.tw.sellsoftware.utils.PageInfo;

import java.util.List;

public interface SoftwareInfoMapper {

    List<SoftwareInfo> querySoftwareInfo(PageInfo pageInfo);

    int deleteByPrimaryKey(Integer id);

    int insert(SoftwareInfo record);

    int insertSelective(SoftwareInfo record);

    SoftwareInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SoftwareInfo record);

    int updateByPrimaryKey(SoftwareInfo record);
}