package com.music.dao;

import com.music.pojo.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKeyUser(Integer id);

    int insertUser(User record);

    User selectByPrimaryKeyUser(Integer id);

    List<User> selectAllUser();

    int updateByPrimaryKeyUser(User record);
}