package com.tw.sellsoftware.usercenter.mapper;

import com.tw.sellsoftware.usercenter.domain.UserInfo;
import org.apache.ibatis.annotations.*;

public interface UserInfoMapper {

    String TABLE_NAME = " t_user_info ";
    String INSERT_FIELDS = " user_name, email, phone, password ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Select({"select ", SELECT_FIELDS, " from", TABLE_NAME, "where user_name = #{userName}"})
    @Results(id = "BaseResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "password", column = "password")
    })
    UserInfo getUserByUserName(@Param("userName") String userName);

    @Select({"select ", SELECT_FIELDS, " from", TABLE_NAME, "where user_name = #{userName} or phone = #{phone} or email = #{email} "})
    @ResultMap("BaseResultMap")
    UserInfo getUserByNameOrPhoneOrEmail(@Param("userName") String userName,@Param("phone") String phone,@Param("email") String email);

    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") values (#{userName},#{email},#{phone},#{password})"})
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insertUserInfo(UserInfo record);
}