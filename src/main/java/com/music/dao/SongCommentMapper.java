package com.music.dao;

import com.music.pojo.SongComment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SongCommentMapper {
    int deleteByPrimaryKeySongComment(Integer id);

    int insertSongComment(SongComment record);

    SongComment selectByPrimaryKeySongComment(Integer id);

    List<SongComment> selectAllSongComment();

    int updateByPrimaryKeySongComment(SongComment record);
}