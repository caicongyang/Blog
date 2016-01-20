<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Caicongyang的博客</title>
<meta http-equiv="keywords" content="Caicongyang">
<meta http-equiv="description" content="caicongyang">
<link type="images/x-icon" href="<%=basePath%>img/csdn.png"
	rel="shortcut icon">
</head>
<frameset rows="50,*"  frameborder="no" border="0" framespacing="0">
	<frame src="<%=path%>/blog/top.action"  noresize="noresize" frameborder="0" name="topFrame" marginwidth="0" marginheight="0" scrolling="no">
	<frameset cols="12%,88%">
		<frame src="<%=path%>/blog/left.action"  name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto">
		<frame src="<%=path%>/blog/main.action"  name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="yes">
	</frameset>
</frameset>
</html>
