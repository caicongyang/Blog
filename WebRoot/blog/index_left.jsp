<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css">
</head>
<div id="menu">
	<div>
		<div class="menutop">菜单</div>
		<ul id="menuList" class="menucontent">
			<c:forEach var="item" items="${clist}" varStatus="status">
				<li class="interval"><a
					href="<%=basePath%>blog/blogList.action?blog.category.id=${item.id}"
					target="main"> ${item.name}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
</html>
