package com.music.dao;

import com.music.pojo.SongList;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SongListMapper {
    int deleteByPrimaryKeySongList(Integer id);

    int insertSongList(SongList record);

    SongList selectByPrimaryKeySongList(Integer id);

    List<SongList> selectAllSongList();

    int updateByPrimaryKeySongList(SongList record);
    
    // 获取热门歌曲
    public List<SongList> getHotSongLists(int limit);
    
    //榜单
    public List<SongList> getHotSongs(int limit );
}