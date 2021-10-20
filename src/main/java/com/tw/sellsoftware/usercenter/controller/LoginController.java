package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/userLogin")
    public ResponseEntity userLogin(@RequestBody UserInfo userInfo) {
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUserName()) || !StringUtils.hasLength(userInfo.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Optional<String> optional = loginService.userLogin(userInfo);
        if (optional.isPresent()) {
            return new ResponseEntity(optional.get(), HttpStatus.OK);
        }
        return ResponseEntity.ok().build();
    }
}
