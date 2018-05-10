<!-- 某首字母的歌手列表 -->
<%@page import="com.neteasemusic.www.entity.Singer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Singer> singers=(List<Singer>)request.getAttribute("singers");
	if(singers!=null&&singers.size()>0){
%>
<dl>
	<%
	for(Singer singer : singers) {
		%>
		<dt class="floatleft">
		<a href="#"><img src="<%=singer.getSmall_img() %>" width="100px" heigth="100px"
			title="" /></a></a>
		<dd>
			<a href="#"><%=singer.getName() %></a> <a href="#" class="zan" title="点击查看主页"></a>
		</dd>
		</dt>
		<%
	}
}
	%>
</dl>
