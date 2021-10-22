package com.tw.sellsoftware.software.mapper;

import com.tw.sellsoftware.software.domain.SoftwareInfo;
import com.tw.sellsoftware.utils.PageInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SoftwareInfoMapper {

    String TABLE_NAME = " t_software_info ";
    String SELECT_FIELDS = " id, software_name, software_price, software_describe ";

    @Select({"select ", SELECT_FIELDS, " from", TABLE_NAME, "where id = #{id}"})
    @Results(id = "BaseResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "softwareName", column = "software_name"),
            @Result(property = "softwarePrice", column = "software_price"),
            @Result(property = "softwareDescribe", column = "software_describe")
    })
    SoftwareInfo querySoftwareById(@Param("id") Integer id);

    @Select({"select ", SELECT_FIELDS, " from", TABLE_NAME, " limit #{start},#{pageSize}"})
    @ResultMap("BaseResultMap")
    List<SoftwareInfo> querySoftwareInfo(PageInfo pageInfo);
}