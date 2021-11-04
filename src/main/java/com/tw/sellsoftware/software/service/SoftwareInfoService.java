package com.tw.sellsoftware.software.service;

import com.tw.sellsoftware.software.domain.SoftwareInfo;
import com.tw.sellsoftware.software.mapper.SoftwareInfoMapper;
import com.tw.sellsoftware.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SoftwareInfoService {

    private final SoftwareInfoMapper softwareInfoMapper;

    public SoftwareInfoService(SoftwareInfoMapper softwareInfoMapper) {
        this.softwareInfoMapper = softwareInfoMapper;
    }

    public Optional<SoftwareInfo> querySoftwareById(int softwareId) {
        return Optional.ofNullable(softwareInfoMapper.querySoftwareById(softwareId));
    }

    public List<SoftwareInfo> getSoftwareInfo(PageInfo pageInfo) {
        return softwareInfoMapper.querySoftwareInfo(pageInfo);
    }

}
