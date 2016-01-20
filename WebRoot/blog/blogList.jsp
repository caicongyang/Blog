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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js">
</script>
</head>
<body>
	<div id="header">
		<ul class="nav">
			<li class="navli navselect"><a
				href="<%=basePath%>/blog/blogList.action">博客</a></li>
			<li class="navli"><a href="#home">主站</a></li>
			<li class="navli"><a href="<%=basePath%>/blog/blogList.action">联系</a>
			</li>
			<li class="navli"><a href="<%=basePath%>/blog/blogList.action">关于</a>
			</li>
		</ul>
	</div>
	<div id="container">
		<div id="menu">
			<div>
				<div class="menutop">文章分类</div>
				<ul id="menuList" class="menucontent">
					<li class="interval">HTML</li>
					<li class="interval">CSS</li>
					<li class="interval">JavaScript</li>
				</ul>
			</div>
		</div>
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

					<s:if test="%{pageBean.currentPage == 1}"> 
				第一页 上一页 
				</s:if>
					<s:else>
						<a href="listMyArticle.action?currentPage=1">第一页</a>
						<a
							href="listMyArticle.action?currentPage=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
					</s:else>
					<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
						<a
							href="listMyArticle.action?currentPage=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
						<a
							href="listMyArticle.action?currentPage=<s:property value="pageBean.totalPage"/>">最后一页</a>
					</s:if>
					<s:else> 
				下一页 最后一页 
				</s:else>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<div class="fdiv">Copyright caicongyang.com</div>
	</div>
</body>
<script type="text/javascript">
$.ajax({
	type : "POST",
	url : "<%=path%>/blog/categoryList.action",
	cache : true,
	success : function(data) {
		$("#menuList").html("");//清空内容
        $.each(data, function(i, item) {
         $("#menuList").append("<div class='interval'><li ><a href='javascript:categorizedArticle("+item.id+")'>"+item.name+item.id + "</li></div>"); 
            });
	}
});
function categorizedArticle(id){
	window.location.href ="<%=path%>/blog/blogList.action?category.id="+ id;
}
</script>
</html>
