package com.cc.mapper;

import com.cc.domain.User;

import java.util.List;

public interface UserMapper {

    public List<User> findAll();
    public List<User> findByIdAndName(User user);
    public List<User> findByName(String username);
    public List<User> findByIdAndName1(User user);
    public List<User> findByIds(List<Integer> ids);
    public void up(User user);



}
