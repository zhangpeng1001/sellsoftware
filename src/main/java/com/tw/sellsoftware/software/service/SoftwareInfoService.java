package com.tw.sellsoftware.software.service;

import com.tw.sellsoftware.software.domain.SoftwareInfo;
import com.tw.sellsoftware.utils.PageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SoftwareInfoService {

    public SoftwareInfo querySoftwareById(String softwareId) {
        //TODO query software data from DB
        return new SoftwareInfo();
    }

    public Optional<List<SoftwareInfo>> getSoftwareInfo(PageInfo pageInfo) {
        return Optional.ofNullable(querySoftwareInfo(pageInfo));
    }

    private List<SoftwareInfo> querySoftwareInfo(PageInfo pageInfo) {
        //TODO query software data from DB
        return new ArrayList<>();
    }


}
