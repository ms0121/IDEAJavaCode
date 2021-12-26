<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logout</title>
</head>
<body>
    <h4>退出登录</h4>
    <%
        session.removeAttribute("name");
    %>
</body>
</html>
