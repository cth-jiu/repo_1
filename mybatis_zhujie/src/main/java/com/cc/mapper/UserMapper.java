package com.cc.mapper;

import com.cc.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.Alias;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public List<User> findById(int id);

    @Insert("insert into user (username,birthday,sex,address) values (#{username},#{birthday},#{sex},#{address})")
    public void save(User user);

    @Select("select * from user")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "address",column = "address"),
            @Result(property = "ordersList",javaType = List.class,column = "id",many = @Many(select = "com.cc.mapper.OrdersMapper.findByUid",fetchType = FetchType.EAGER))
    })
    public List<User> findAll();
}
