<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
<style>
	*{
		margin:0px;
		padding:0px;
	}
	#icontent{
		width:100%;
		height:100%;
		margin:0px;
		padding:0px;
		position:absolute;
		z-index:5;
	}
	
	#player{
		position:absolute;
		z-index:10;
		width:530px;
		height:100px;
		top:78%;
	}
	
</style>
<script src="/Music/js/jquery-min.js"></script>

</head>
<body>
<iframe name="content" src="home.jsp" id="icontent" frameborder="0" scrolling="auto"  allowTransparency="true">
		<!-- 内容iframe，这个iframe用来显示网页，本体则是用来播放音乐的，数据从session中获取 -->
</iframe>
<iframe name="player" src="player.jsp" id="player" frameborder="0" scrolling="no" allowTransparency="true">

</iframe>
</body>
</html>