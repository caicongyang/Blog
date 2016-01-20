<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'catagoryList.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="caicongyang">
<meta http-equiv="description" content="This is my page">

</head>
<body style="text-align: center;">
<form method="post" action="<%=path%>/blogAdmin/categoryUpdate.action">
<input type="hidden" name="category.id" value="${category.id}">
名称：<input type="text" name="category.name" value="${category.name}">
描述：<input type="text" name="category.description" value="${category.description}">
<input type="submit" value="提交">
</form>
</body>
</html>
