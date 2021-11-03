package com.tw.sellsoftware.software.controller;

import com.tw.sellsoftware.software.service.SoftwareInfoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        Mockito.when(softwareInfoService.getSoftwareInfo(Mockito.any())).thenReturn(Optional.of(new ArrayList<>()));
        assertNotNull(softwareInfoController.getSoftwareInfo(page_num, page_size).getBody());
    }

    @Test
    void getSoftwareInfoForNull() {
        Mockito.when(softwareInfoService.getSoftwareInfo(Mockito.any())).thenReturn(Optional.empty());
        assertNull(softwareInfoController.getSoftwareInfo(page_num, page_size).getBody());
    }
}