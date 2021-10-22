package com.tw.sellsoftware.order.mapper;

import com.tw.sellsoftware.order.domain.OrderDetail;
import com.tw.sellsoftware.order.domain.OrderInfo;
import com.tw.sellsoftware.utils.PageInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderDetailMapper {

    String TABLE_NAME = " t_order_detail ";
    String INSERT_FIELDS = " order_id, user_id, software_id, software_price, discount ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"<script>", "insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values <foreach collection='list' item='detail'  index='index' separator=','>  ",
            "(#{detail.orderId}, #{detail.userId},#{detail.softwareId},#{detail.softwarePrice}, #{detail.discount})",
            "</foreach></script>"
    })
    void insertDetailBatch(List<OrderDetail> list);


    @Select({"select ", SELECT_FIELDS, " from", TABLE_NAME, "where order_id = #{orderId} "})
    @Results(id = "BaseResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "softwareId", column = "software_id"),
            @Result(property = "softwarePrice", column = "software_price"),
            @Result(property = "discount", column = "discount")
    })
    List<OrderDetail> queryOrderDetailByOrderId(@Param("orderId") int orderId);
}