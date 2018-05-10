package com.music.dao;

import com.music.pojo.SingerCategory;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SingerCategoryMapper {
    int deleteByPrimaryKeySingerCategory(Integer id);

    int insertSingerCategory(SingerCategory record);

    SingerCategory selectByPrimaryKeySingerCategory(Integer id);

    List<SingerCategory> selectAllSingerCategory();

    int updateByPrimaryKeySingerCategory(SingerCategory record);
}