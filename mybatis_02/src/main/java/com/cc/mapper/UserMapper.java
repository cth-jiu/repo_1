package com.cc.mapper;

import com.cc.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public List<User> findAll();

    public List<User> findUserById(int id);

    public List<User> findUserByIdAndName(int id,String username);

    public List<User> findUserByIdAndName1(@Param("id") int id,@Param("username") String username);

    public List<User> findUserByIdAndName2(User user);

    public List<User> findUserByName(String username);

    public List<User> findUserByName2(String username);

    public void saveUser(User user);

    public List<User> findUserByName3(User user);

    public void updateUser(User user);

    public List<User> findList(List<Integer> ids);


}
