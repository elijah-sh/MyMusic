package com.music.dao;

import com.music.pojo.ListCategory;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ListCategoryMapper {
    int deleteByPrimaryKeyListCategory(Integer id);

    int insertListCategory(ListCategory record);

    ListCategory selectByPrimaryKeyListCategory(Integer id);

    List<ListCategory> selectAllListCategory();

    int updateByPrimaryKeyListCategory(ListCategory record);
}