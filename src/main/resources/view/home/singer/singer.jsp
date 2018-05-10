<%@page import="java.util.List"%>
<%@page import="com.neteasemusic.www.entity.SingerCategory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../top.jsp" %>
<link href="/Music/home/css/singer.css" rel="stylesheet" type="text/css">
<script>
	function getHotSingers(container){
		$.post(
			"/Music/SingerServlet?action=getHotSingers",
			{},
			function(data){
				container.html(data);
			}
		);
	}
	
	function getSingersByCategoryId(container,categoryId){
		$.post(
				"/Music/SingerServlet?action=getSingersByCategoryId",
				{
					categoryId:categoryId
				},
				function(data){
					container.html(data);
				}
			);
	}
	
	$(function(){
		getHotSingers($("#container"));
		$(".category").each(function(index,element){
			var c=$(this);
			c.click(function(){
				getSingersByCategoryId($("#container"),parseInt($(this).attr("category_id")));
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
				<li class="white"><a href="/Music/home/singer/singer.jsp">热门歌手</a></li>
			</ul>
		<%
		//加载全部歌手分类
		List<SingerCategory> singerCategories=(List<SingerCategory>)session.getAttribute("singerCategories");
		if(singerCategories!=null){
			for(SingerCategory singerCategory:singerCategories){
				if(0 == singerCategory.getParent()) {
					int parent = singerCategory.getId();
					//判断有无子分类
					boolean flag = false;
					for(SingerCategory sc:singerCategories) {
						if(parent == sc.getParent()) {
							flag = true;
							break;
						}
					}
					if(true == flag) {
					%>
					<hr/>
					<h3><%=singerCategory.getName() %></h3>
					<ul>
					<%
						int i=0;
						//子项
						for(SingerCategory sc:singerCategories) {
							if(parent == sc.getParent()) {
					%>
							<li class="white"><a class="category" href="#" category_id="<%=sc.getId()%>"><%=sc.getName() %></a></li>
					<%
							}
						}
					%>
						</ul>
					<%
					}
				}
			}
			session.removeAttribute("singerCategories");
					
		}else{
			response.sendRedirect("/Music/SingerServlet?action=showAllSingerCategories");
		}
		%>
				</div>
				<div class="center_right" id="container">
<!-- 					ajax获取热门歌手或某分类歌手 -->
					
					
				</div>
			</div>
		</div>
	<%@ include file="../bottom.jsp" %>