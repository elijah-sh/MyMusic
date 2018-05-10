package com.music.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.pojo.Album;
import com.music.pojo.AlbumComment;

/**
 * @author shensh
 * @date 2018年5月9日  
 * @version 1.0
 *  Album n. 	相册; 唱片;  专辑 
 */
public interface IAlbumService {
	// 获取热门专辑
	public  List<Album> getHotAlbums(Integer limit);
}
