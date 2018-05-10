package com.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dao.UserMapper;
import com.music.pojo.User;
import com.music.service.UserManageService;

 
@Service(value = "userManageService")
public class UserManageServiceImpl implements UserManageService{

	@Autowired
	private UserMapper userMapper;

 
 
	
	
}

 