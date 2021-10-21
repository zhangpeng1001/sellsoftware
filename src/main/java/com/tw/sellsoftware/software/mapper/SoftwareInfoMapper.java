package com.tw.sellsoftware.software.mapper;

import com.tw.sellsoftware.software.domain.SoftwareInfo;
import com.tw.sellsoftware.utils.PageInfo;

import java.util.List;

public interface SoftwareInfoMapper {

    List<SoftwareInfo> querySoftwareInfo(PageInfo pageInfo);

    SoftwareInfo querySoftwareById(Integer id);

}