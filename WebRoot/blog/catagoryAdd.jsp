<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>新增分类  --from caicongyang.com</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="caicongyang">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<form action="<%=path%>/blogAdmin/addCategory.action" method="post">
		<div>
			标题： <input type="text" id="title" name="category.name" value="">
		</div>
		<div>
			描述信息： <input type="text" id="description" name="category.description"
				value="">
		</div>
		<div><input type="submit" value="提交"></div>
	</form>
</body>
</html>
