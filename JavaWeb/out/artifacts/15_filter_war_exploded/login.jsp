<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-09
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>我是登录Login.jsp页面</h1>
    <form action="http://localhost:8080/15_filter/loginServlet" method="get">
        用户名: <input type="text" name="username" ><br>
        密码: <input type="password" name="password"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
