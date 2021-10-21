package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.domain.UserVipRelation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class RegisterService {

    private final UserInfoService userInfoService;

    private final VipInfoService vipInfoService;

    private final UserVipRelationService userVipRelationService;

    public RegisterService(UserInfoService userInfoService, VipInfoService vipInfoService, UserVipRelationService userVipRelationService) {
        this.userInfoService = userInfoService;
        this.vipInfoService = vipInfoService;
        this.userVipRelationService = userVipRelationService;
    }

    public Optional<String> userRegister(UserInfo userInfo) {
        Optional<String> optional = userDataValidate(userInfo);
        if (optional.isPresent()) {
            return optional;
        }
        register(userInfo);
        return Optional.empty();
    }

    private void register(UserInfo userInfo) {
        userInfoService.register(userInfo);
        UserVipRelation userVipRelation = new UserVipRelation();
        userVipRelation.setUserId(userInfo.getId());
        userVipRelation.setVipId(vipInfoService.getRandomVipInfo().getId());
        userVipRelationService.insert(userVipRelation);
    }

    private Optional<String> userDataValidate(UserInfo userInfo) {
        UserInfo userInfoForDB = userInfoService.getUserByPhoneOrEmail(userInfo);
        if (userInfoForDB != null && StringUtils.hasLength(userInfoForDB.getPhone())) {
            return Optional.of("User phone already exists!");
        }
        if (userInfoForDB != null && StringUtils.hasLength(userInfoForDB.getEmail())) {
            return Optional.of("User Email already exists!");
        }
        return Optional.empty();
    }
}
