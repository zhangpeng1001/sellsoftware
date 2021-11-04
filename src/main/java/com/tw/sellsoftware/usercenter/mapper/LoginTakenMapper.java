package com.tw.sellsoftware.usercenter.mapper;

import com.tw.sellsoftware.usercenter.domain.LoginToken;
import org.apache.ibatis.annotations.*;

public interface LoginTakenMapper {


    String TABLE_NAME = " t_login_token ";
    String INSERT_FIELDS = " user_id, user_login_token ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Select({"select ", SELECT_FIELDS, ", update_time from", TABLE_NAME, "where user_login_token = #{userLoginToken}"})
    @Results(id = "BaseResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userLoginToken", column = "user_login_token"),
            @Result(property = "updateTime", column = "update_time")
    })
    LoginToken getLoginTokenByToken(@Param("userLoginToken") String userLoginToken);

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{userId},#{userLoginToken})"})
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertLoginToken(LoginToken lginToken);
}
