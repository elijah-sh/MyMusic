<!-- 歌单详情页面 -->
<%@page import="com.neteasemusic.www.entity.Song"%>
<%@page import="java.util.List"%>
<%@page import="com.neteasemusic.www.entity.ListCategory"%>
<%@page import="com.neteasemusic.www.entity.SongList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../top.jsp" %>
<link rel="stylesheet" href="/Music/home/css/songListDetails.css"/>

<%
	SongList songList=(SongList)session.getAttribute("songList");
	if(songList==null){
		response.sendRedirect("/Music/home/index.jsp");
		return;
	}
%>
<div class="backgroud">
	<div class="centre">
				<div class="cleft">
					<div class="clefttop">
						<div class="img">
							<img src="<%=songList.getImg()%>"/>
						</div>
						<div class="clefttopr">
							<div class="gedanname">
								歌单:【 <%=songList.getName() %> 】
							</div>
							<div class="user">
								<div class="user_img">
									<%
										String img=songList.getCreater().getImg();
										String defalt_img=application.getInitParameter("DEFAULT_IMG");
									%>
									<a href="#"><img src="<%=(img==null||img.trim().length()<=0)?defalt_img:img%>"/></a>
								</div>	
								<div class="nickname"><a href="#"><%=songList.getCreater().getNickname() %></a></div>
								<div class="create_time"><%=songList.getCreate_time() %>创建</div>
							</div>
							<ul class="types">
								<div><strong>标签：</strong></div>
								<%
									for(ListCategory lc:songList.getCategories()){
								%>
								<li><a href="#"><%=lc.getName() %></a></li>
								<%
									}
								%>
							</ul>
							<div class="gedanjieshao">
								<strong>介绍：</strong>
								<%=songList.getIntro() %>
							</div>
						</div>
					</div>
					
					<a href="/Music/SongListServlet?action=playSongList&id=<%=songList.getId() %>" target="player" style="display:block;padding:5px;border:1px solid gray;width:150px;border-radius:5px;text-decoration:none;text-align:center;margin-left:50px;color:black;font-family:'微软雅黑';">播放歌单</a>
					
					<div class="songtable">
						<div class="li0">
							<div class="li01">
								
							</div>
							<div class="li02">
								歌曲标题
							</div>
							<div class="li03">
								歌手
							</div>
							<div class="li04">
								专辑
							</div>
							<div class="li05">
								操作
							</div>
						</div>
						<%
							List<Song> songs=songList.getSongs();
							for(int i=1;i<=songs.size();i++){
						%>
						<div class="li<%=i%2==1?"1":"2"%>">
							<div class="li01"><%=i %></div>
							
							<a href="/Music/SongServlet?action=getSongDetails&id=<%=songs.get(i-1).getId() %>"><div class="li02"><%=songs.get(i-1).getName() %></div></a>
							<a href="#"><div class="li03"><%=songs.get(i-1).getAlbum().getSinger().getName() %></div></a>
							<a href="#"><div class="li04"><%=songs.get(i-1).getAlbum().getName() %></div></a>
							<div class="li05">
								<a href="/Music/SongServlet?action=playSong&id=<%=songs.get(i-1).getId() %>" target="player" class="play_button" song_id="<%=songs.get(i-1).getId() %>" ></a>
								<a href="#" class="collect_button"></a>
							</div>
						</div>
						<%
							}
						%>
						
					</div>
					
				</div>
				
				
				<div class="clear_fix"></div>
			</div>
			</div>
<%@ include file="../bottom.jsp" %>