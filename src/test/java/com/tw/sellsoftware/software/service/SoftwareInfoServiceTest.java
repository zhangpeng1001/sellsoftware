package com.tw.sellsoftware.software.service;

import com.tw.sellsoftware.software.domain.SoftwareInfo;
import com.tw.sellsoftware.software.mapper.SoftwareInfoMapper;
import com.tw.sellsoftware.utils.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class SoftwareInfoServiceTest {

    private final int softwareId = 1;

    @InjectMocks
    private SoftwareInfoService softwareInfoService;

    @Mock
    private SoftwareInfoMapper softwareInfoMapper;

    @Test
    void querySoftwareByIdForSoftwareInfo() {
        Mockito.when(softwareInfoMapper.querySoftwareById(Mockito.any())).thenReturn(new SoftwareInfo());
        assertNotNull(softwareInfoService.querySoftwareById(softwareId));
    }

    @Test
    void querySoftwareByIdForNull() {
        Mockito.when(softwareInfoMapper.querySoftwareById(Mockito.any())).thenReturn(null);
        assertFalse(softwareInfoService.querySoftwareById(softwareId).isPresent());
    }

    @Test
    void getSoftwareInfoForSoftwareInfoList() {
        List<SoftwareInfo> list = new ArrayList<>();
        list.add(new SoftwareInfo());
        Mockito.when(softwareInfoMapper.querySoftwareInfo(Mockito.any())).thenReturn(list);
        assertTrue(softwareInfoService.getSoftwareInfo(new PageInfo()).size() > 0);
    }

    @Test
    void getSoftwareInfoForEmpty() {
        Mockito.when(softwareInfoMapper.querySoftwareInfo(Mockito.any())).thenReturn(new ArrayList<>());
        assertFalse(softwareInfoService.getSoftwareInfo(new PageInfo()).size() > 0);
    }
}