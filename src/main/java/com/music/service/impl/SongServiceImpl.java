package com.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dao.SongMapper;
import com.music.pojo.Song;
import com.music.service.ISongService;

@Service
public class SongServiceImpl implements ISongService {
	 @Autowired
	 private SongMapper songMapper;
	
	 // 主页面榜单
		@Override
	 public List<Song> getHotSongs(int limit) {
			// TODO Auto-generated method stub
			return songMapper.getHotSongs(limit);
		}
}
