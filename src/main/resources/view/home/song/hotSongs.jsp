<%@page import="com.neteasemusic.www.entity.Song"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
	.hot_title{
		font-weight:bold;
		font-size:16px;
	}
</style>
<div class="left1">
	<div class="left1_img"></div>
	<a href="#" class="hot_title">热歌榜</a> <a class="left2_img" href="#"></a>
</div>
<%
	List<Song> songs=(List<Song>)request.getAttribute("songs");
	if(songs!=null&&songs.size()>=0){
		int index=1;
		for(Song song:songs){
%>
<ul>
	<li class="li1"><a href="#"><%=index++%>.<%=song.getName() %></a></li>
</ul>
<%
		}
	}else{
%>
<p>暂时还没有歌曲哦...</p>
<%
	}
%>

<div class="left2">
	<a href="#">查看全部&gt;&nbsp;&nbsp;</a>
</div>