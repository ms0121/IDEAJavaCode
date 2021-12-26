<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>
	<%--  使用静态包含，包含base标签，css样式，JQuery文件， 将公共的部分进行抽取出来 --%>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">结算</span>

			<%--静态包含登录成功之后的显示部分，（共有。将其进行抽取出来处理）--%>
			<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
		
		<h1>你的订单已结算，订单号是: ${sessionScope.orderId}</h1>

	</div>

	<%--	静态包含页脚信息 , 都有公共的部分 --%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>