package com.tw.sellsoftware.software.controller;

import com.tw.sellsoftware.software.service.SoftwareInfoService;
import com.tw.sellsoftware.utils.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/software")
public class SoftwareInfoController {

    private final SoftwareInfoService softwareInfoService;

    public SoftwareInfoController(SoftwareInfoService softwareInfoService) {
        this.softwareInfoService = softwareInfoService;
    }

    @GetMapping("/list/{pageNum}/{pageSize}")
    public ResponseEntity getSoftwareInfo(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        return softwareInfoService.getSoftwareInfo(pageInfo).map(softwareInfoList -> ResponseEntity.ok(softwareInfoList)).orElse(ResponseEntity.ok(null));
    }
}
