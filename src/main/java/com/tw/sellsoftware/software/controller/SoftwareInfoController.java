package com.tw.sellsoftware.software.controller;

import com.tw.sellsoftware.software.domain.SoftwareInfo;
import com.tw.sellsoftware.software.service.SoftwareInfoService;
import com.tw.sellsoftware.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/software")
public class SoftwareInfoController {

    @Autowired
    private SoftwareInfoService softwareInfoService;

    @GetMapping("/list/{pageNum}/{pageSize}")
    public ResponseEntity getSoftwareInfo(@PathVariable int pageNum, @PathVariable int pageSize) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        Optional<List<SoftwareInfo>> softwareList = softwareInfoService.getSoftwareInfo(pageInfo);
        return softwareList.isPresent()
                ? ResponseEntity.ok(softwareList.get())
                : ResponseEntity.notFound().build();
    }
}
