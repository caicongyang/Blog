<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div#container{width:500px}
div#header {background-color:#99bbbb;}
div#menu {background-color:#ffff99;height:200px;width:150px;float:left;}
div#content {background-color:#EEEEEE;height:200px;width:350px;float:left;}
div#footer {background-color:#99bbbb;clear:both;text-align:center;}
h1 {margin-bottom:0;}
h2 {margin-bottom:0;font-size:18px;}
ul {margin:0;}
li {list-style:none;}
</style>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js">
</script>
</head>
<body>
<div id="container">
<div id="header">
<h1>Main Title of Web Page</h1>
</div>
<div id="menu">
<h2>Menu</h2>
<ul>
<c:forEach items="${clist}" var="category" varStatus="statu">
<li><a  href="<%=path%>/blog/list.action?blog.category.id=${category.id}"  target="_top" >${category.name}</a></li>
</c:forEach>
</ul>
</div>
<div id="main">${blog.title}<br></br> ${blog.content}</div>
<div id="footer">Copyright W3School.com.cn</div>
</div>
</body>
<script type="text/javascript">
</script>
</html>