package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.domain.LoginUserInfo;
import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(loginUserInfo,userInfo);
        Optional<String> optional = loginService.userLogin(userInfo,request);
        if (optional.isPresent()) {
            return new ResponseEntity(optional.get(), HttpStatus.OK);
        }
        return ResponseEntity.ok().build();
    }
}
