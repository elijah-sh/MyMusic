package com.music.dao;

import com.music.pojo.ListComment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ListCommentMapper {
    int deleteByPrimaryKeyListComment(Integer id);

    int insertListComment(ListComment record);

    ListComment selectByPrimaryKeyListComment(Integer id);

    List<ListComment> selectAllListComment();

    int updateByPrimaryKeyListComment(ListComment record);
}