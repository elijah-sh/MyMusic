package com.music.service;

import java.util.List;

import com.music.pojo.ListCategory;
import com.music.pojo.Song;
import com.music.pojo.SongList;
import com.music.pojo.User;

/**
 * @author shensh
 * @date 2018年5月9日  
 * @version 1.0
 */
public interface ISongService {
 
	public List<Song> getHotSongs(int limit) ;
	
}
