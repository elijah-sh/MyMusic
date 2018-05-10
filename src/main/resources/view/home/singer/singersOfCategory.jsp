<!-- 某分类歌手列表页面 -->
<%@page import="com.neteasemusic.www.entity.Singer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
function getSingersByLetter(container, letter){
	$.post(
			"/Music/SingerServlet?action=getSingersByLetter",
			{
				letter:letter
			},
			function(data){
				container.html(data);
			}
		);
}

$(function(){
	$(".letter").each(function(index,element){
		var c=$(this);
		c.click(function(){
			getSingersByLetter($("#singers"), $(this).attr("letter"));
		});
	})
});
</script>

<h2 class="hotsinger"><%=request.getAttribute("categoryName") %></h2>
<hr class="hr2" />
<br/>&nbsp;&nbsp;
<%
for(int i=65;i<91;i++)
{
    %>
    <a class="letter" href="#" letter="<%=(char)i %>"><%=(char)i%></a>
	<%
}
%>
<br/>
<%
	List<Singer> singers=(List<Singer>)request.getAttribute("singers");
	if(singers!=null&&singers.size()>0){
%>
<div id="singers">
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

</div>
