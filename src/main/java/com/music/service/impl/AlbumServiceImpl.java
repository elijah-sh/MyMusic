package com.music.service.impl;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dao.AlbumCommentMapper;
import com.music.dao.AlbumMapper;
import com.music.pojo.Album;
import com.music.service.IAlbumService;

@Service
public class AlbumServiceImpl implements IAlbumService  {
	
	 @Autowired
	 private AlbumMapper albumMapper;
	//获得热门专辑
	@Override
	public List<Album> getHotAlbums(Integer limit)   {
		// TODO 自动生成的方法存根
		 
		List<Album> albums=albumMapper.getHotAlbums(limit);
		
	//	request.setAttribute("albums", albums);
	//	request.getRequestDispatcher("home/album/listAlbums.jsp").forward(request, response);
		return albums;
	}
	
	
	/*//获取歌手列表到添加专辑页面
	public void listAllSingers(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
			SingerService singerService=new SingerService();
			List<Singer> singers=singerService.listAllSingers();
			request.getSession().setAttribute("singers", singers);
			response.sendRedirect("/Music/admin/album/addAlbumPage.jsp");
	}
	
	//添加专辑
	public void addAlbum(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{

		//上传路径
		 String savePath = request.getServletContext().getInitParameter("SAVE_PATH");
		

		 //读取路径
		 String readPath = request.getServletContext().getInitParameter("READ_PATH");
		 
		 if(FileUpload.uploadFile(request, savePath,new String[]{".jpg",".png",".jpeg"})){
			 String name=(String)request.getAttribute("name");
			 String company=(String)request.getAttribute("company");
			 String intro=(String)request.getAttribute("intro");
			 
			 //数据校验
			 if(name.trim().length()<=0||company.trim().length()<=0||intro.trim().length()<=0){
				 request.getSession().setAttribute("message", "数据格式不正确，请重填！");
				 response.sendRedirect("/Music/AlbumServlet?action=listAllSingers");
			 }else{
			 
				 //获取请求参数，构建对象，把它传给service
				 Album album=new Album();
				 album.setName((String)request.getAttribute("name"));
				 album.setImg(readPath+"/"+(String)request.getAttribute("img"));
				 album.setCompany((String)request.getAttribute("company"));
				 album.setIntro(intro);
				 album.setRelease_time(new Date(System.currentTimeMillis()));
				 Singer singer=new Singer();
				 singer.setId(Integer.parseInt((String)request.getAttribute("singer_id")));
				 album.setSinger(singer);
				 
				 AlbumService albumService=new AlbumService();
				 if (albumService.addAlbum(album)) {
					 request.getSession().setAttribute("message", "添加成功！");
					 response.sendRedirect("/Music/AlbumServlet?action=listAllSingers");
				}else{
					request.getSession().setAttribute("message", "添加失败，可能是专辑名冲突，请重试！");
					response.sendRedirect("/Music/AlbumServlet?action=listAllSingers");
				}
		}
			 
		 }else{
			 request.getSession().setAttribute("message", "上传图片失败，请重试！");
			 response.sendRedirect("/Music/AlbumServlet?action=listAllSingers");
		 }
	}
	

	
	//获得全部专辑
	public void getAllAlbums(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		AlbumService service=new AlbumService();
		List<Album> albums=service.listAllAlbums();
		request.setAttribute("albums", albums);
		request.getRequestDispatcher("home/album/listAlbums.jsp").forward(request, response);
		
	}
	
	
	
	
	
	
	*/
	
	
	
	
}
