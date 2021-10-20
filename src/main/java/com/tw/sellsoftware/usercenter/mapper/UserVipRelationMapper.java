package com.tw.sellsoftware.usercenter.mapper;

import com.tw.sellsoftware.usercenter.domain.UserVipRelation;

public interface UserVipRelationMapper {

    int insert(UserVipRelation userVipRelation);

    UserVipRelation selectById(Integer id);

    UserVipRelation selectByUserId(Integer userId);

}