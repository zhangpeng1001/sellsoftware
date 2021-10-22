package com.tw.sellsoftware.usercenter.mapper;

import com.tw.sellsoftware.usercenter.domain.VipInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VipInfoMapper {

    String TABLE_NAME = " t_vip_info ";
    String SELECT_FIELDS = " id, vip_grade, discount, vip_desc ";

    @Select({"select ", SELECT_FIELDS, " from", TABLE_NAME, "where id = #{id}"})
    @Results(id = "BaseResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "vipGrade", column = "vip_grade"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "vipDesc", column = "vip_desc")
    })
    VipInfo selectVipInfoById(@Param("id") Integer id);

    @Select({"select ", SELECT_FIELDS, " from", TABLE_NAME, " ORDER BY RAND() LIMIT 1"})
    @ResultMap("BaseResultMap")
    VipInfo getRandomVipInfo();
}