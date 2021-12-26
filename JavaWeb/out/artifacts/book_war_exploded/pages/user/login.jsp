<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>尚硅谷会员登录页面</title>

	<!--在base标签中，永远固定相对路径的跳转结果,此时默认会跳转到book下的web目录之下, 最后的斜杠不能丢-->
	<%--  使用静态包含，包含base标签，css样式，JQuery文件， 将公共的部分进行抽取出来 --%>
	<%@include file="/pages/common/head.jsp"%>

</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<%--	将错误信息显示在登录界面的上面，位置可以任意设置 --%>
								<span class="errorMsg">
									<%--	表达式脚本， 不推荐使用, 直接修改为EL表达式  --%>
									<%--	<%=request.getAttribute("msg")==null?--%>
									<%--	"请输入用户名和密码": request.getAttribute("msg")%>--%>
									${empty requestScope.msg?"请输入用户名和密码":requestScope.msg}

									</span>
							</div>

							<div class="form">
								<!--这个必须填写，否则无法完成相应信息-->
								<!--表单栏需要设置提交到具体的哪个页面信息的路径信息  提交的方式-->
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="login">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username"
											<%--	表达式脚本(不推荐使用), 后面都是用EL表达式 --%>
											<%--	 value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"/>--%>
											value="${requestScope.username}"
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>

		<%--	静态包含页脚信息 , 都有公共的部分 --%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>