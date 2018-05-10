package com.music.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.music.pojo.Song;

	@Mapper
public interface SongMapper {
    int deleteByPrimaryKeySong(Long songId);

    int insertSong(Song record);

    int insertSelectiveSong(Song record);

    Song selectByPrimaryKeySong(Long songId);

    int updateByPrimaryKeySelectiveSong(Song record);

    int updateByPrimaryKeySong(Song record);
   
    public List<Song> findAllSong(Song song);
    
}