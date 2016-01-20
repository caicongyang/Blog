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
<table style="border: 1px;border-color: black;">
	<tr>
		<th style="width:10%"></th>
		<th style="width:20%">名称</th>
		<th style="width:40%">描述</th>
		<th style="width:25%">操作</th>
	</tr>

	<c:forEach items="${list}" var="category" varStatus="statu">
		<tr>
			<td>${statu.index}</td>
			<td>${category.name}</td>
			<td>${category.description}</td>
			<td><a href="<%=path%>/blogAdmin/categoryUpdatePage.action?category.id=${category.id}">修改</a> | <a href="javascript:del('${category.id}')">删除</a></td>
		</tr>
	</c:forEach>
</table>
</body>
<script type="text/javascript">
function del(id){
	if(confirm('确认要删除该分类？')){
		document.location.href = "<%=path%>/blogAdmin/categoryDel.action?category.id="+id;
	}else{
		return;
	}
}

</script>
</html>
