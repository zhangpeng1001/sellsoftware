package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.domain.RegisterUserInfo;
import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.service.RegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/userRegister")
    public ResponseEntity userRegister(@Validated @RequestBody RegisterUserInfo registerUserInfo) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(registerUserInfo,userInfo);
        Optional<String> optional = registerService.userRegister(userInfo);
        if (optional.isPresent()) {
            return new ResponseEntity(optional.get(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().build();
    }
}
