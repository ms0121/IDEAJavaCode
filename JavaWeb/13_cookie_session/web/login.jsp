<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-06
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="http://localhost:8080/13_cookie_session/loginServlet" method="get">
        用户名: <input type="text" name="username" value=""><br>
        密码: <input type="password" name="password" value="${cookie.username.value}"><br>
        <input type="submit" value="登录">
    </form>


</body>
</html>
