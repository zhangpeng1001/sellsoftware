package com.tw.sellsoftware.software.controller;

import com.tw.sellsoftware.software.domain.SoftwareInfo;
import com.tw.sellsoftware.software.service.SoftwareInfoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class SoftwareInfoControllerTest {

    private final int page_num = 0;
    private final int page_size = 10;

    @InjectMocks
    private SoftwareInfoController softwareInfoController;

    @Mock
    private SoftwareInfoService softwareInfoService;

    @Test
    void getSoftwareInfoForSoftwareInfoList() {
        List<SoftwareInfo> list = new ArrayList<>();
        list.add(new SoftwareInfo());
        Mockito.when(softwareInfoService.getSoftwareInfo(Mockito.any())).thenReturn(list);
        assertTrue(((List<SoftwareInfo>) softwareInfoController.getSoftwareInfo(page_num, page_size).getBody()).size() > 0);
    }

    @Test
    void getSoftwareInfoForEmpty() {
        Mockito.when(softwareInfoService.getSoftwareInfo(Mockito.any())).thenReturn(Collections.emptyList());
        assertFalse(((List<SoftwareInfo>) softwareInfoController.getSoftwareInfo(page_num, page_size).getBody()).size() > 0);

    }
}