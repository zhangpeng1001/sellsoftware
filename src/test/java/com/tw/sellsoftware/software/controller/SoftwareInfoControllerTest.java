package com.tw.sellsoftware.software.controller;

import com.tw.sellsoftware.software.domain.SoftwareInfo;
import com.tw.sellsoftware.software.service.SoftwareInfoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value = SoftwareInfoController.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class SoftwareInfoControllerTest {

    @InjectMocks
    private SoftwareInfoController softwareInfoController;

    @Mock
    private SoftwareInfoService softwareInfoService;

    @Test
    void getSoftwareInfoForsuccess() {
//        List<SoftwareInfo> list = new ArrayList<>();
//        Optional<List<SoftwareInfo>> softList = Optional.of(list);
//        Mockito.when(softwareInfoService.getSoftwareInfo(Mockito.any())).thenReturn(softList);
//        assertEquals(softwareInfoController.getSoftwareInfo(0, 10).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getSoftwareInfoForError() {
//        Optional<List<SoftwareInfo>> softList = Optional.empty();
//        Mockito.when(softwareInfoService.getSoftwareInfo(Mockito.any())).thenReturn(softList);
//        assertEquals(softwareInfoController.getSoftwareInfo(0, 10).getStatusCode(), HttpStatus.NOT_FOUND);
    }
}