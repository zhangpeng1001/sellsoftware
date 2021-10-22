package com.tw.sellsoftware.order.mapper;

import com.tw.sellsoftware.order.domain.OrderInfo;
import com.tw.sellsoftware.usercenter.domain.UserInfo;
import com.tw.sellsoftware.utils.PageInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderInfoMapper {

    String TABLE_NAME = " t_order_info ";
    String INSERT_FIELDS = " user_id, order_status, order_price, pay_time ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") values (#{userId}, #{orderStatus}, #{orderPrice}, #{payTime})"})
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insertOrderInfo(OrderInfo orderInfo);

    @Select({"select ", SELECT_FIELDS, " from", TABLE_NAME, "where user_id = #{userId} limit #{pageInfo.start},#{pageInfo.pageSize} "})
    @Results(id = "BaseResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "orderStatus", column = "order_status"),
            @Result(property = "orderPrice", column = "order_price"),
            @Result(property = "payTime", column = "pay_time"),
            @Result(property="detailList", column="id",
                    many=@Many(select="com.tw.sellsoftware.order.mapper.OrderDetailMapper.queryOrderDetailByOrderId", fetchType= FetchType.EAGER)),
    })
    List<OrderInfo> queryOrderList(@Param("pageInfo") PageInfo pageInfo, @Param("userId") int userId);
}