<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-07
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <%--  action的地址：表示的是提交的信息发送到servlet中去  --%>
    <form action="http://localhost:8080/tmp/loginServlet" method="get">
        用户名: <input type="text" name="username"><br>
        验证码: <input type="text" name="code" style="width:60px">
        <img src="http://localhost:8080/tmp//kaptcha.jpg" alt="" style="width: 100px"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
