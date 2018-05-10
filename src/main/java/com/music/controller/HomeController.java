package com.music.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.music.pojo.Album;
import com.music.pojo.Song;
import com.music.pojo.SongList;
import com.music.service.IAlbumService;
import com.music.service.ISongListService;
import com.music.service.ISongService;


@Controller  
@RequestMapping("/home") 
public class HomeController {
 
	@Autowired
	private ISongListService iSongListService;
	@Autowired
	private ISongService iSongService;
	@Autowired
	private IAlbumService iAlbumService;
	  
    @RequestMapping("/getHotSongLists") 
    @ResponseBody
	public void GetHotSongLists(ModelMap map){
		
    	List<SongList>	hotSongList =	iSongListService.getHotSongLists(4);
    	 map.addAttribute("songHotList", hotSongList); 
	}
    
    @RequestMapping("/getHotAlbums") 
    @ResponseBody
   	public void GetHotAlbums(ModelMap map){
   		
    	List<Album> albumList = iAlbumService.getHotAlbums(8);
    	map.addAttribute("albumList", albumList);
        map.addAttribute("name", "thymeleaf-imooc");

    	System.out.println(albumList.size());
    	System.out.println(albumList.get(0).getName());

   	}
    
    @RequestMapping("/getHotSongs") 
    @ResponseBody
   	public void GetHotSongs(ModelMap map){
    	List<Song> hotSong  = iSongService.getHotSongs(10);
    	map.addAttribute("hotSong", hotSong);
   		
   	}
    
	@RequestMapping("/main")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf-imooc");
    	List<Album> albumList = iAlbumService.getHotAlbums(8);
    	System.out.println(albumList.size());

        map.addAttribute("albumList", albumList);
        return "/home/index";
    }
	
	
}
