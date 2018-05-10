<!-- 某分类歌单列表页面 -->
<%@page import="com.neteasemusic.www.entity.SongList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h2 class="hotsonglist"><%=request.getAttribute("categoryName") %></h2>
<hr class="hr2" />
<%
	List<SongList> songLists=(List<SongList>)request.getAttribute("songLists");
	if(songLists!=null&&songLists.size()>0){
%>
<div>
<dl>
	<%
	for(SongList songList : songLists) {
		%>
		<dt class="floatleft">
		<a href="/Music/SongListServlet?action=getSongListDetails&id=<%=songList.getId() %>"><img src="<%=songList.getImg() %>" width="100px" heigth="100px"
			title="" /></a></a>
		<dd>
			<a href="/Music/SongListServlet?action=getSongListDetails&id=<%=songList.getId() %>"><%=songList.getName() %></a> <a href="#" class="zan" title="点击查看主页"></a>
		</dd>
		</dt>
		<%
	}
}
	%>
</dl>

</div>
