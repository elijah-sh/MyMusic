package com.music.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.music.pojo.Album;
import com.music.pojo.Song;
import com.music.pojo.SongList;
import com.music.service.IAlbumService;
import com.music.service.ISongListService;
import com.music.service.ISongService;



@Controller  
@RequestMapping("/Music") 
public class IndexController {
 
	@Autowired
	private ISongListService iSongListService;
	@Autowired
	private ISongService iSongService;
	@Autowired
	private IAlbumService iAlbumService;
	
    @RequestMapping("/") 
    public String backgroud(ModelMap map  ) throws Exception{
    	String tt=Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
    	//  地址只用于Windows文件路径格式 \ 
    	String path=tt.substring(1,tt.length()).replace('/', '\\');
    	String Url = path+"view\\home\\";
    	String fileUrlfoot = Url + "foot.html"; 
    	String fileUrltop = Url + "top.html"; 
    	
    	String fileUrlmain = Url + "main.html"; 
     	 File Filefoot = new File(fileUrlfoot ); 
     	 File Filetop = new File(fileUrltop ); 
     	 File Filemain = new File(fileUrlmain); 
    	 Document foot = Jsoup.parse(Filefoot,"UTF-8" );  
    	 Document top = Jsoup.parse(Filetop,"UTF-8" ); 
    	 Document main = Jsoup.parse(Filemain,"UTF-8" ); 
    	 map.addAttribute("foot", foot); 
    	 map.addAttribute("top",top ); 
    	 map.addAttribute("main",main ); 
    	 
     	List<SongList>	hotSongList =	iSongListService.getHotSongLists(4);
    	List<Album> albumList = iAlbumService.getHotAlbums(8);
    	List<Song> hotSong  = iSongService.getHotSongs(10);
    	
    	map.addAttribute("hotSong", hotSong);
    	map.addAttribute("albumList", albumList);
    	map.addAttribute("hotSongList", hotSongList); 
    		System.out.println(hotSong.size());
    	return "home/index";
    }
    
    
   
}