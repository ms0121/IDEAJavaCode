<%@page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <base href="<%=basePath%>">--%>
    <title>Title</title>
</head>
<body>
    <%--  el表达式取值  --%>
    <h3>你好</h3><br>
    ${name}<br>
</body>
</html>
