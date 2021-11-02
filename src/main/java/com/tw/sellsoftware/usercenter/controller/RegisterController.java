package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.service.RegisterService;
import com.tw.sellsoftware.usercenter.vo.RegisterUserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/userRegister")
    public ResponseEntity userRegister(@Validated @RequestBody RegisterUserInfo registerUserInfo) {
        registerService.userRegister(registerUserInfo);
        return ResponseEntity.ok().build();
    }
}
