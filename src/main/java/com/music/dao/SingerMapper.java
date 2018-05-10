package com.music.dao;

import com.music.pojo.Singer;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SingerMapper {
    int deleteByPrimaryKeySinger(Integer id);

    int insertSinger(Singer record);

    Singer selectByPrimaryKeySinger(Integer id);

    List<Singer> selectAllSinger();

    int updateByPrimaryKeySinger(Singer record);
}