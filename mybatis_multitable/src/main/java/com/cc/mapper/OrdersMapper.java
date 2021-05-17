package com.cc.mapper;

import com.cc.domain.Orders;

import java.util.List;

public interface OrdersMapper {


    public List<Orders> findAll();
    public List<Orders> findAll1();
    public List<Orders> findById();
}
