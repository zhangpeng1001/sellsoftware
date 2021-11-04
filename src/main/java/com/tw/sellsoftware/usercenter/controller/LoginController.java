package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.service.LoginService;
import com.tw.sellsoftware.usercenter.vo.LoginUserInfo;
import com.tw.sellsoftware.utils.SellSoftwareException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/userLogin")
    public ResponseEntity userLogin(@Validated @RequestBody LoginUserInfo loginUserInfo) {
        try {
            String token = loginService.userLogin(loginUserInfo);
            return new ResponseEntity(token, HttpStatus.OK);
        } catch (SellSoftwareException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
