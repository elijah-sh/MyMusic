package com.music.dao;

import com.music.pojo.Album;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AlbumMapper {
    int deleteByPrimaryKeyAlbum(Integer id);

    int insertAlbum(Album record);

    Album selectByPrimaryKeyAlbum(Integer id);

    List<Album> selectAllAlbum();

    int updateByPrimaryKeyAlbum(Album record);
    
      List<Album>  getHotAlbums(Integer limit ) ;
}