<!-- 首页热门歌单页面 -->
<%@page import="com.neteasemusic.www.entity.SongList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<SongList> songLists=(List<SongList>)request.getAttribute("songLists");
	if(songLists!=null&&songLists.size()>0){
%>
	<div class="center_up_down1">
		<dl>
			<%
			for(int i=0;i<4&&i<songLists.size();i++){
				SongList songList=songLists.get(i);
			%>
			<dt>
				<a href="/Music/SongListServlet?action=getSongListDetails&id=<%=songList.getId() %>"><img src="<%=songList.getImg() %>" width="140px" 
					title="<%=songList.getName() %>" /></a>
			<dd>
				<a href="/Music/SongListServlet?action=getSongListDetails&id=<%=songList.getId() %>" ><%=songList.getName() %></a>
			</dd>
			</dt>
			<%
			}
			%>
		</dl>
	</div>
	<div class="center_up_down2">
		<dl>
		<%
			for(int i=4;i<songLists.size();i++){
				SongList songList=songLists.get(i);
		%>
			<dt>
				<a href="/Music/SongListServlet?action=getSongListDetails&id=<%=songList.getId() %>"><img src="<%=songList.getImg() %>" width="140px" 
					title="<%=songList.getName() %>" /></a></a>
			<dd>
				<a href="/Music/SongListServlet?action=getSongListDetails&id=<%=songList.getId() %>"><%=songList.getName() %></a>
			</dd>
			</dt>
		<%
			}
		%>
		</dl>
	</div>
<%
	}else{
%>
	<p>暂时还没有歌单哦...</p>
<%
	}
%>
<div class="clear_fix"></div>
