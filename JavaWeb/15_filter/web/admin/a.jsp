<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-09
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        // 只能使用在jsp页面当中，因为html页面无法进行编写java代码
        Object user = request.getSession().getAttribute("user");
        if (user == null){
            // 如果用户没有登录，直接跳转到登录界面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            // 禁止向下执行
            return;
        }
    %>

    <h2>我是jsp页面<h2>
</body>
</html>
