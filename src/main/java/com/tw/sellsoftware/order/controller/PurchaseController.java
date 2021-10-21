package com.tw.sellsoftware.order.controller;

import com.tw.sellsoftware.order.domain.PurchaseParam;
import com.tw.sellsoftware.order.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchaseSoftware")
    public ResponseEntity purchaseSoftware(@RequestBody PurchaseParam purchaseParam, HttpServletRequest request) throws Exception {
        Optional<String> optional = purchaseService.purchaseParamValidate(purchaseParam, request);
        if (optional.isPresent()) {
            return new ResponseEntity(optional.get(), HttpStatus.BAD_REQUEST);
        }
        optional = purchaseService.dataSafetyValidate(purchaseParam);
        if (optional.isPresent()) {
            return new ResponseEntity(optional.get(), HttpStatus.BAD_REQUEST);
        }
        purchaseService.purchaseSoftware(purchaseParam, request);
        return new ResponseEntity("The purchase is successful and you can use it", HttpStatus.OK);
    }

}
