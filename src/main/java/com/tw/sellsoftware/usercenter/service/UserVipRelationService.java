package com.tw.sellsoftware.usercenter.service;

import com.tw.sellsoftware.usercenter.domain.UserVipRelation;
import com.tw.sellsoftware.usercenter.mapper.UserVipRelationMapper;
import org.springframework.stereotype.Service;

@Service
public class UserVipRelationService {

    private final UserVipRelationMapper userVipRelationMapper;

    public UserVipRelationService(UserVipRelationMapper userVipRelationMapper) {
        this.userVipRelationMapper = userVipRelationMapper;
    }


    public UserVipRelation selectByUserId(Integer userId) {
        return userVipRelationMapper.selectByUserId(userId);
    }

    public int insert(UserVipRelation userVipRelation) {
        return userVipRelationMapper.insert(userVipRelation);
    }
}
