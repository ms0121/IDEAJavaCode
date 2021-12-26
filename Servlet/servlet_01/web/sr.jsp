<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-09-24
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 获取request的域对象
        String rname = (String) request.getAttribute("rname");

        // 获取session中的域对象
        String sname = (String) session.getAttribute("sname");
//        String spwd = (String) session.getAttribute("spwd");
        String spwd = (String) request.getSession().getAttribute("spwd");

        // 打印在页面上
        out.print("rname: " + rname + ", sname: " + sname + ", spwd: " + spwd);
    %>
</body>
</html>
