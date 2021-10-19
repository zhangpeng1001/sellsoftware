package com.tw.sellsoftware.usercenter.mapper;

import com.tw.sellsoftware.usercenter.domain.UserVipRelation;

public interface UserVipRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserVipRelation record);

    int insertSelective(UserVipRelation record);

    UserVipRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserVipRelation record);

    int updateByPrimaryKey(UserVipRelation record);
}