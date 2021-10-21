package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserVipRelation;
import com.tw.sellsoftware.usercenter.mapper.UserVipRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVipRelationService {

    @Autowired
    private UserVipRelationMapper userVipRelationMapper;


    public UserVipRelation selectByUserId(Integer userId) {
        return userVipRelationMapper.selectByUserId(userId);
    }

    public int insert(UserVipRelation userVipRelation) {
        return userVipRelationMapper.insert(userVipRelation);
    }
}
