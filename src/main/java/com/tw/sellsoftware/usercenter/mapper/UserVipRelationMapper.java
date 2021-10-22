package com.tw.sellsoftware.usercenter.mapper;

import com.tw.sellsoftware.usercenter.domain.UserVipRelation;
import org.apache.ibatis.annotations.*;

public interface UserVipRelationMapper {

    String TABLE_NAME = " t_user_vip_relation ";
    String INSERT_FIELDS = " user_id, vip_id ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Select({"select ", SELECT_FIELDS, " from", TABLE_NAME, "where user_id = #{userId}"})
    @Results(id = "BaseResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "vipId", column = "vip_id")
    })
    UserVipRelation selectByUserId(@Param("userId") Integer userId);

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{userId},#{vipId})"})
    int insert(UserVipRelation userVipRelation);
}