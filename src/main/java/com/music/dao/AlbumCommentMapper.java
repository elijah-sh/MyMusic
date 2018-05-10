package com.music.dao;

import com.music.pojo.AlbumComment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AlbumCommentMapper {
    int deleteByPrimaryKeyAlbumComment(Integer id);

    int insertAlbumComment(AlbumComment record);

    AlbumComment selectByPrimaryKeyAlbumComment(Integer id);

    List<AlbumComment> selectAllAlbumComment();

    int updateByPrimaryKeyAlbumComment(AlbumComment record);
    
   
}