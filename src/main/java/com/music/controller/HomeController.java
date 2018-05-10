package com.music.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.music.pojo.Album;
import com.music.service.IAlbumService;
import com.music.service.ISongListService;


@Controller  
@RequestMapping("/home") 
public class HomeController {
 
	@Autowired
	private ISongListService iSongListService;
	
	@Autowired
	private IAlbumService iAlbumService;
	  
    @RequestMapping("/getHotSongLists") 
	public String GetHotSongLists(){
		
    	iSongListService.getHotSongLists(4);
		return "home/bottom";
	}
    
    @RequestMapping("/getHotAlbums") 
   	public String GetHotAlbums(ModelMap map){
   		
    	List<Album> albumList = iAlbumService.getHotAlbums(8);
    	map.addAttribute("albumList", albumList);
   		return "home/home";
   	}
    
    @RequestMapping("/getHotSongs") 
   	public String GetHotSongs(){
    	iSongListService.getHotSongs(10);
    	System.out.println("---");
   		return "home/index";
   	}
    
    
}
