<%@page import="java.util.List"%>
<%@page import="com.neteasemusic.www.entity.SingerCategory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../top.jsp" %>
<link href="/Music/home/css/album.css" rel="stylesheet" type="text/css">
<script>
	function getHotAlbums(container){
		$.post(
			"/Music/AlbumServlet?action=getHotAlbums",
			{},
			function(data){
				container.html(data);
			}
		);
	}
	
	function getAllAlbums(container){
		$.post(
			"/Music/AlbumServlet?action=getAllAlbums",
			{},
			function(data){
				container.html(data);
			}
		);
	}
	
	/* function getSingersByCategoryId(container,categoryId){
		$.post(
				"/Music/SingerServlet?action=getSingersByCategoryId",
				{
					categoryId:categoryId
				},
				function(data){
					container.html(data);
				}
			);
	} */
	
	$(function(){
		getHotAlbums($("#hotAlbums"));
		getAllAlbums($("#allAlbums"));
// 		$(".category").each(function(index,element){
// 			var c=$(this);
// 			c.click(function(){
// 				getSingersByCategoryId($("#container"),parseInt($(this).attr("category_id")));
// 			});
// 		})
	});
</script>


		<div id="color">
			<div class="center">
				<h2 class="h1">热门专辑</h2>
				<hr class="hr1" />
				<div class="center_right" id="hotAlbums">
<!-- 					ajax获取热门专辑 -->
				</div>
				
				<h2 class="h2">全部专辑</h2>
				<hr class="hr2" />
				<div class="center_right" id="allAlbums">
<!-- 					ajax获取全部专辑 -->
				</div>
			</div>
		</div>
	<%@ include file="../bottom.jsp" %>