package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
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

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/userLogin")
    public ResponseEntity userLogin(@Validated @RequestBody LoginUserInfo loginUserInfo, HttpServletRequest request) {
        UserInfo userInfo = loginService.userLogin(loginUserInfo);
        request.getSession().setAttribute("userInfo", userInfo);
        return new ResponseEntity(HttpStatus.OK);
    }
}
