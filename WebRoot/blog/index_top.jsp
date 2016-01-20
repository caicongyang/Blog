<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>top</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
</head>
<div id="header">
	<ul class="nav">
		<li class="navli navselect"><a
			href="<%=path%>/blog/index.jsp">博客</a></li>
		<li class="navli"><a href="<%=path%>/blog/index.jsp">主站</a></li>
		<li class="navli"><a href="<%=path%>/loginPage.action" target="_top">登录</a>
		</li>
		<li class="navli"><a href="<%=path%>/blogAdmin/addCategoryPage.action" target="_top">新增分类</a>
		</li>
		<li class="navli"><a href="<%=path%>/blogAdmin/addBlogPage.action" target="_top">写文章</a>
		</li>
	</ul>
</div>
</html>
