<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css">
<script type="text/javascript" src="<%=path%>/js/jquery.min.js" ></script>
<script type="text/javascript">
$(document).ready(function(){
var url = "<%=basePath%>blog/menu.action";
$.ajax({
		type : "POST",
		url : url,
		cache : true,
		processData : true,
		data : null,
		dataType: "json", 
		success : function(back) {
			var menuHtml="";
			for(var i =0 ;i<back.length;i++){
				menuHtml+="<li class=\"interval\"><a href=\"<%=basePath%>blog/blogList.action?blog.category.id="+back[i].id+"\" target='main'>"+back[i].name+"</a>";
			}	
			$("#menuList").append(menuHtml);
		}
	});
});
</script>
</head>
<div id="menu">
	<div>
		<div class="menutop">菜单</div>
		<ul id="menuList" class="menucontent">
		</ul>
	</div>
</div>
</html>
