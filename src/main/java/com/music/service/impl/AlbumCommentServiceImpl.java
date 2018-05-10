package com.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dao.AlbumCommentMapper;
import com.music.dao.SingerMapper;
import com.music.pojo.AlbumComment;
import com.music.pojo.Singer;
import com.music.service.IAlbumCommentService;

 
@Service
public class AlbumCommentServiceImpl implements IAlbumCommentService{

	 @Autowired
	private AlbumCommentMapper albumCommentMapper;
	@Override
	public boolean insert(AlbumComment albumComment) {
		// TODO Auto-generated method stub
		int ac= albumCommentMapper.insertAlbumComment(albumComment);
		if (ac>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		int ac= albumCommentMapper.deleteByPrimaryKeyAlbumComment(id);
		if (ac>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(AlbumComment t) {
		int ac= albumCommentMapper.updateByPrimaryKeyAlbumComment(t);
		if (ac>0) {
			return true;
		}
		return false;
	}

	@Override
	public AlbumComment findById(int id) {
		// TODO Auto-generated method stub
		return albumCommentMapper.selectByPrimaryKeyAlbumComment(id);
	}

	@Override
	public List<AlbumComment> listAll() {
		// TODO Auto-generated method stub
		return albumCommentMapper.selectAllAlbumComment();
	}
	 
}
 