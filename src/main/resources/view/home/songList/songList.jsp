<%@page import="java.util.List"%>
<%@page import="com.neteasemusic.www.entity.ListCategory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../top.jsp" %>
<link href="/Music/home/css/songList.css" rel="stylesheet" type="text/css">
<script>
	function getHotSongLists(container){
		$.post(
			"/Music/SongListServlet?action=getHotSongLists",
			{},
			function(data){
				container.html(data);
			}
		);
	}
	
	function getSongListsByCategoryId(container,categoryId){
		$.post(
				"/Music/SongListServlet?action=getSongListsByCategoryId",
				{
					categoryId:categoryId
				},
				function(data){
					container.html(data);
				}
			);
	}
	
	$(function(){
		getHotSongLists($("#container"));
		$(".category").each(function(index,element){
			var c=$(this);
			c.click(function(){
				getSongListsByCategoryId($("#container"),parseInt($(this).attr("category_id")));
			});
		})
	});
</script>
<div id="color">
	<div class="center">
		<div class="center_left">
			<div class="left_space"></div>
			<h3>推荐</h3>
			<ul>
				<li class="white"><a href="/Music/home/songList/songList.jsp">热门歌单</a></li>
			</ul>
		<%
		//加载全部歌单分类
		List<ListCategory> listCategories=(List<ListCategory>)session.getAttribute("listCategories");
		if(listCategories!=null){
			for(ListCategory listCategory:listCategories){
				if(0 == listCategory.getParent()) {
					int parent = listCategory.getId();
					//判断有无子分类
					boolean flag = false;
					for(ListCategory lc:listCategories) {
						if(parent == lc.getParent()) {
							flag = true;
							break;
						}
					}
					if(true == flag) {
					%>
					<hr/>
					<h3><%=listCategory.getName() %></h3>
					<ul>
					<%
						int i=0;
						//子项
						for(ListCategory lc:listCategories) {
							if(parent == lc.getParent()) {
					%>
							<li class="white"><a class="category" href="#" category_id="<%=lc.getId()%>"><%=lc.getName() %></a></li>
					<%
							}
						}
					%>
						</ul>
					<%
					}
				}
			}
			session.removeAttribute("listCategories");
					
		}else{
			response.sendRedirect("/Music/SongListServlet?action=showAllListCategories");
		}
		%>
				</div>
				<div class="center_right" id="container">
<!-- 					ajax获取热门歌单或某分类歌单 -->
					
					
				</div>
			</div>
		</div>
	<%@ include file="../bottom.jsp" %>