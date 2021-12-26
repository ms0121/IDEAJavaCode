
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>result</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div align="center">
        result页面，你注册的结果是: ${tips}
        <br>
        <a href="index.jsp">首页</a>
    </div>
</body>
</html>
