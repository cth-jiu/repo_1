package com.cc.mapper;

import com.cc.domain.Orders;
import com.cc.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrdersMapper {

    @Select("select * from orders where uid = #{uid}")
    public List<Orders> findByUid(int uid);

    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "ordertime",column = "ordertime"),
            @Result(property = "total",column = "total"),
            @Result(property = "user",javaType = User.class,column = "uid",one = @One(select = "com.cc.mapper.UserMapper.findById",fetchType = FetchType.EAGER))
    })
    public List<Orders> findAll();
}
