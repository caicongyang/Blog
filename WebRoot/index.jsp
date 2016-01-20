<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>CaiCongyang</title>
<link type="images/x-icon" href="<%=path%>/img/csdn.png"
	rel="shortcut icon" />
<meta http-equiv="keywords"
	content="caicongyang,http://blog.csdn.net/caicongyang,caicongyang" />
<meta http-equiv="description" content="CaiCongyang" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	margin: 0;
	padding: 0;
	height: 100%;
	/* background: url(img/bg.jpg); 
	background-size: cover; */
	/* 基本色 */
	background: #3FB0AC;
	/* chrome 2+, safari 4+; multiple color stops */
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(1, #3FB0AC),
		color-stop(1, #C5D7A1) );
	/* chrome 10+, safari 5.1+ */
	background-image: -webkit-linear-gradient(#3FB0AC, #C5D7A1);
	/* firefox; multiple color stops 
	background-image: -moz-linear-gradient(top,#063053, #395873, #5c7c99);*/
	background: -moz-linear-gradient(top, red, rgba(0, 0, 255, 0.5) );
	/* ie 6+ */
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#3FB0AC',
		endColorstr='#C5D7A1' );
	/* ie8 + */
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(startColorstr='#3FB0AC', endColorstr='#C5D7A1')";
	/* ie10 */
	background-image: -ms-linear-gradient(#3FB0AC, #C5D7A1);
	/* opera 11.1 */
	background-image: -o-linear-gradient(#3FB0AC, #C5D7A1);
	/* 标准写法 */
	background-image: linear-gradient(#3FB0AC, #C5D7A1);
}

h1 {
	margin-left: 100px;
	margin-top: 80px;
	font-size: 45px;
}

h2,h3,p {
	margin-left: 100px;
	margin-top: 30px;
}

a {
	text-decoration: none;
	color: #003399;
}

li {
	list-style: none;
}

#top {
	height: 35px;
	line-height: 35px;
	border-bottom: 1px solid #bbb;
	background: #fafafa;
}

#weibo {
	position: absolute;
	top: 90px;
	right: 100px;
	background: #fff;
}
</style>
</head>
<body>
	<div id="top">
		<span style="float:left; margin-left:100px;">Welcome to my
			website！</span>
		<c:if test="${sessionScope.user.name!=null}">
			<span style="float:right; margin-right:120px;">欢迎您：${sessionScope.user.name}!
			</span>
		</c:if>
		<div style="float:right; margin-right:120px;">
			<span><a href="<%=basePath%>/loginPage.action">登陆 </a> </span>| <span><a
				href="<%=basePath%>/blog/index.jsp">个人博客 </a> </span>| <span><a
				href=mailto:caicongyang@139.com>Contact Me </a> </span>|
		</div>
	</div>
	<div id="weibo">
		<iframe width="350" height="400" class="share_self" frameborder="0"
			scrolling="no"
			src="http://widget.weibo.com/weiboshow/index.php?language=&width=0&height=400&fansRow=1&ptype=1&speed=0&skin=1&isTitle=1&noborder=1&isWeibo=1&isFans=1&uid=2282202874&verifier=8a8120bb&dpc=1"></iframe>
	</div>
	<h1>Cai Congyang</h1>
	<h2>Tom.Cai</h2>
	<h3>程序员 码农 伪极客 白帽黑客</h3>
	<p>
		<span style="font-size: 17px;">就职于福建某电信级解决方案公司,三年电信行业经验。</span> <br></br>
		<span style="font-size: 17px;">专注于企业计算、整体解决方案、互联网和大数据方向!</span>
	</p>
	<div style="margin-left: 100px; margin-top:30px;">
		<ul style="line-height:40px;">
			<li><img src="img/csdn.png" style="vertical-align:middle;"
				alt="" /> <a style="vertical-align:middle;"
				href="http://blog.csdn.net/caicongyang" target="_blank"><span>CSDN博客</span>
			</a></li>
			<li><img src="img/csdn.png" style="vertical-align:middle;"
				alt="" /> <a style="vertical-align:middle;"
				href="http://09300501.sinaapp.com/" target="_blank"><span>信管一班论坛</span>
			</a></li>
		</ul>
	</div>
</body>
</html>
