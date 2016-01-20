<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>新增文章</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="images/x-icon" href="<%=path%>/img/csdn.png"
	rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/article.css">
<script type="text/javascript" src="<%=path%>/js/jquery.min.js">
</script>
</head>
<body>
	<jsp:include page="index_top.jsp" flush="false" />
	<jsp:include page="index_menu.jsp" flush="true" />
		<div id="content" name='main'>
			<form action="<%=path%>/blogAdmin/addBlog.action" method="post">
				<div class="carticle">
					<div class="interval">
						标题： <input type="text" id="title" name="blog.title"
							class="addArticleTitle" value="">
					</div>
					<div class="interval">
						类别： <input type="text" id="category" name="blog.catageryId"
							class="addArticleCategory" value="">
					</div>
					<div class="interval">
						<textarea class="addArticleContent xheditor" id="xheditor"
							name="blog.content">
						</textarea>
					</div>
					<div class="interval">
						<div class="interval">
							<input type="submit" value="发表">
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div id="footer">
		<div class="fdiv">Copyright caicongyang.com</div>
	</div>
</body>

<script type="text/javascript">
</script>
</html>

