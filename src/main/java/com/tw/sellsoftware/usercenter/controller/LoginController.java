package com.tw.sellsoftware.usercenter.controller;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.service.LoginService;
import com.tw.sellsoftware.usercenter.service.RegisterService;
import com.tw.sellsoftware.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/userLogin")
    public ResponseEntity userLogin(@RequestBody UserInfo userInfo) {
        if (userInfo == null || StringUtils.isEmpty(userInfo.getUserName()) || StringUtils.isEmpty(userInfo.getPassword())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        Optional<String> optional = loginService.userLogin(userInfo);
        if (optional.isPresent()) {
            return new ResponseEntity(optional.get(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().build();
    }
}
