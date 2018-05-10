
<%@page import="com.neteasemusic.www.entity.Song"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../top.jsp" %>
<style type="text/css">
			.color {
				background-color: aliceblue;
				width: 100%;
				height: 1300px;
				margin:0px auto;
			}
			
			.center {
				background-color: white;
				border: 1px solid gainsboro;
				width: 800px;
				height: 1300px;
				margin: 0px auto;
			}
			
			.center .left {
				float: left;
				width: 280px;
				height: 1300px;
				margin-left: 20px;
			}
			
			.center .left img {
				float: left;
				margin-top: 100px;
				margin-left: 100px;
			}
			
			.center .left .background {
				float: left;
				width: 206px;
				height: 205px;
				background-image: url(../img/coverall.png);
				background-position: -140px -580px;
				margin-left: -168px;
				margin-top: 62px;
			}
			
			.center .right {
				float: left;
				width: 400px;
				height: 1300px;
				margin-left: 40px;
			}
			
			.center .right .right_up {
				float: left;
			}
			
			.center .right .right_up .font1 {
				float: left;
				font-size: 24px;
				font-weight: 500;
				padding-top: 60px;
			}
			
			.center .right .right_up .right_up1 {
				clear: both;
				float: left;
				margin-top: 25px;
			}
			
			.center .right .right_up .right_up2 {
				clear: both;
				float: left;
				margin-top: 10px;
			}
			
			.center .right .right_up .font2 {
				clear: both;
				float: left;
				font-size: 13px;
				font-weight: 300;
				color: gray;
			}
			
			.center .right .right_up .belong {
				float: left;
				font-size: 13px;
				text-decoration: none;
				color: cornflowerblue;
			}
			
			.center .right .right_up .belong:hover {
				text-decoration: underline;
			}
			
			.center .right .right_center {
				clear: both;
				float: left;
				margin-top: 40px;
			}
			
			.center .right .right_center .playlist {
				float: left;
				width: 100px;
				height: 31px;
				padding-left:20px;
				background-image: url(img/button2.png);
				background-position: 0px -633px;
				text-decoration: none;
				font-size: 13px;
				color: white;
			}
			
			.center .right .right_center .playlist:hover {
				background-image: url(img/button2.png);
				background-position: 0px -719px;
			}
			
			.center .right .right_center .playlist div {
				float: left;
				margin-left: 35px;
				margin-top: 5px;
			}
			
			.center .right .right_center .add {
				float: left;
				width: 31px;
				height: 31px;
				background-image: url(img/button2.png);
				background-position: 0px -1588px;
			}
			
			.center .right .right_center .add:hover {
				background-image: url(img/button2.png);
				background-position: -40px -1588px;
			}
			
			.center .right .right_down {
				clear: both;
				padding-top: 40px;
				float: left;
			}
			
			.center .right .right_down hr {
				width: 400px;
			}
			
			.center .right .right_down h1 {
				clear: both;
				float: left;
				font-weight: 300;
				font-size: 14px;
				margin-top: 20px;
			}
		</style>
<div class="color">
<%
	Song song=(Song)session.getAttribute("song");
%>
			<div class="center">
				<div class="left">
					<img src="<%=song.getAlbum().getImg() %>" width="130px">
					<div class="background"></div>
				</div>
				<div class="right">
					<div class="right_up">
						<h2 class="font1">单曲【<%=song.getName() %>】</h2>
						<div class="right_up1">
							<h2 class="font2">歌手：</h2>
							<a class="belong" href="#"><%=song.getAlbum().getSinger().getName() %></a>
						</div>
						<div class="right_up2">
							<h2 class="font2">所属专辑：</h2>
							<a class="belong" href="#"><%=song.getAlbum().getName() %></a>
						</div>
					</div>
					<div class="right_center">
						<div style="clear:both;"></div>
						<a href="/Music/SongServlet?action=playSong&id=<%=song.getId() %>" target="player" song_id="<%=song.getId() %>"
						style="font-family:'微软雅黑';font-weight:bold;" >播放</a>
					</div>
					<div class="right_down">
						<hr />
						<pre>
							<%=song.getLyric() %>
						</pre>
					</div>
				</div>
			</div>
		</div>

<%@ include file="../bottom.jsp" %>