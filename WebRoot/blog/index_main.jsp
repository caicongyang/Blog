<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>main</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css">
</head>
<div id="content">
	<div class="carticle">

		<s:iterator value="pageBean.list" id="blog" status="st">
			<div class="interval"></div>
			<!--	<s:property value="#st.index" />
						<a href="<s:url action="blogDel.html"><s:param name="blog.id" value="%{#blog.id}"></s:param></s:url>"><s:property value="#blog.title"/></a>
						-->
			<!--
							<s:a href="blogDel.html?blog.id=%{#blog.id}"><s:property value="#blog.title"/></s:a><br/>
						-->
			<div class="carticletitle">
				<a target="_blank"
					href="<%=path%>/blog/blogDel.action?blog.id=${id}"><s:property
						value="#blog.title" /> </a>
			</div>
			<div class="carticlecontent">
				<s:property value="#blog.content" />
			</div>
			<div class="dashed"></div>
		</s:iterator>

		<div>
			共
			<s:property value="pageBean.allRow" />
			条记录 共
			<s:property value="pageBean.totalPage" />
			页 当前第
			<s:property value="pageBean.currentPage" />
			页<br />
			<s:if test="%{pageBean.currentPage != 1}">
				<a href="<%=path%>/blog/blogList.action?currentPage=1&blog.category.id=${cagetoryId}">第一页</a>
				<a href="<%=path%>/blog/blogList.action?currentPage=<s:property value="%{pageBean.currentPage-1}"/>&blog.category.id=${cagetoryId}">上一页</a>
			</s:if>
			<s:if test="%{pageBean.isLastPage()==false}">
				<a
					href="<%=path%>/blog/blogList.action?currentPage=<s:property value="%{pageBean.currentPage+1}"/>&blog.category.id=${cagetoryId}">下一页</a>
				<a
					href="<%=path%>/blog/blogList.action?currentPage=<s:property value="pageBean.totalPage"/>&blog.category.id=${cagetoryId}">最后一页</a>
			</s:if>
		</div>
	</div>
	<%-- <div class="carticle">

		<s:iterator value="list" id="blog" status="st">
			<div class="interval"></div>
			<!--	<s:property value="#st.index" />
						<a href="<s:url action="blogDel.html"><s:param name="blog.id" value="%{#blog.id}"></s:param></s:url>"><s:property value="#blog.title"/></a>
						-->
			<!--
							<s:a href="blogDel.html?blog.id=%{#blog.id}"><s:property value="#blog.title"/></s:a><br/>
						-->
			<div class="carticletitle">
				<a target="_blank" href="<%=path%>/blog/blogDel.action?blog.id=${id}"><s:property value="#blog.title" /> </a>
			</div>
			<div class="carticlecontent">
				<s:property value="#blog.content" />
			</div>
			<div class="dashed"></div>
		</s:iterator>
	</div> --%>
</div>
</html>
