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

import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/userRegister")
    public ResponseEntity userRegister(@RequestBody PurchaseParam purchaseParam) {
        Optional<String> optional = purchaseService.purchase(purchaseParam);
        if (optional.isPresent()) {
            return new ResponseEntity(optional.get(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("The purchase is successful and you can use it", HttpStatus.OK);
    }

}
