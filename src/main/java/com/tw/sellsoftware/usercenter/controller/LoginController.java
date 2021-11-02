package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.service.LoginService;
import com.tw.sellsoftware.usercenter.vo.LoginUserInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/userLogin")
    public ResponseEntity userLogin(@Validated @RequestBody LoginUserInfo loginUserInfo, HttpServletRequest request) {
        Optional<String> optional = loginService.userLogin(loginUserInfo,request);
        return optional.map(str -> new ResponseEntity(str, HttpStatus.BAD_REQUEST)).orElse(new ResponseEntity(HttpStatus.OK));
    }
}
