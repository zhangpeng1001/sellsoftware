package com.tw.sellsoftware.usercenter.mapper;


import com.tw.sellsoftware.usercenter.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper_back {

//    List<UserInfo> getUserByUserName(String userName);

    int insertSelective(UserInfo userInfo);
}
