package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.usercenter.domain.UserVipRelation;
import com.tw.sellsoftware.usercenter.mapper.UserInfoMapper;
import com.tw.sellsoftware.usercenter.mapper.UserVipRelationMapper;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    private final UserInfoMapper userInfoMapper;

    private final UserVipRelationMapper userVipRelationMapper;

    public UserInfoService(UserInfoMapper userInfoMapper, UserVipRelationMapper userVipRelationMapper) {
        this.userInfoMapper = userInfoMapper;
        this.userVipRelationMapper = userVipRelationMapper;
    }

    public UserInfo getUserByUserName(String userName) {
        return userInfoMapper.getUserByUserName(userName);
    }

    public UserInfo getUserByNameOrPhoneOrEmail(String userName, String phone, String email) {
        return userInfoMapper.getUserByNameOrPhoneOrEmail(userName, phone, email);
    }

    public int register(UserInfo userInfo) {
        return userInfoMapper.insertUserInfo(userInfo);
    }

    public int insertUserVipRelation(UserVipRelation userVipRelation) {
        return userVipRelationMapper.insert(userVipRelation);
    }
}
