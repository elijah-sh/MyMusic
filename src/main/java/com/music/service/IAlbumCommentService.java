package com.music.service;

import java.util.List;

import com.music.pojo.AlbumComment;

/**
 * @author shensh
 * @date 2018年5月9日  
 * @version 1.0
 */
public interface IAlbumCommentService {
	 public boolean insert(AlbumComment albumComment) ;
		// 使用前提是我已经得到了user_id,还有专辑id

	 public boolean deleteById(int id);

	//该功能不实现
	public boolean update(AlbumComment t) ;

	public AlbumComment findById(int id);  

	public List<AlbumComment> listAll() ;
}
