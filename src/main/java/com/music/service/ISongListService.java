package com.music.service;

import java.util.List;

import com.music.pojo.ListCategory;
import com.music.pojo.SongList;
import com.music.pojo.User;

/**
 * @author shensh
 * @date 2018年5月9日  
 * @version 1.0
 */
public interface ISongListService {
 


	// 根据热度取得歌单  主页面
	public List<SongList> getHotSongLists(int limit) ;
 
	
	
	// 得到完整信息的歌单(建立与歌单关联的需要的映射)
	//歌单id,歌单创建者，歌单图片，歌单创建时间，歌单创建者的头像，歌单所属分类，歌单介绍，歌曲列表，歌曲评论
	public SongList getSongListById(int songListId) ;
 
	

	
	// 根据歌单分类取得歌单
	public List<SongList> getSongListByCategory(ListCategory listCategory) ;
 
	// 创建歌单,songList里面只需要有歌单名，创建者，创建时间
	public boolean createSongList(SongList songList) ;
 

	// 收藏歌单
	public boolean collectSongList(User user, SongList songList) ;
 

	// 获得用户创建的歌单
	public List<SongList> getCreateSongList(User user) ;
	 

	// 获得用户收藏的歌单
	public List<SongList> getCollectSongList(User user) ;
 
	
	//得到全部歌单
	public List<SongList> listAllSongList() ;
}
