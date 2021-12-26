<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>尚硅谷会员注册页面</title>
	<!--在base标签中，永远固定相对路径的跳转结果,此时默认会跳转到book下的web目录之下, 最后的斜杠不能丢-->
	<%--  使用静态包含，将公共的部分进行抽取出来 --%>
	<%@include file="/pages/common/head.jsp"%>

	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}

		h1 a {
			color:red;
		}
	</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >

				<%--静态包含登录成功之后的显示部分，（共有。将其进行抽取出来处理）--%>
				<%@include file="/pages/common/login_success_menu.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>欢迎回来 <a href="../../index.jsp">转到主页</a></h1>
	
		</div>

		<%--	静态包含页脚信息 , 都有公共的部分 --%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>