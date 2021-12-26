<%@page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h2>请求转发和重定向问题</h2>
    <%--  路径中传递的参数获取方法，使用params  --%>
    <h5>name = ${param.name}, age = ${param.age}</h5>
    <br>

    <%--  请求对象的取值方法，直接使用属性名  --%>
    <h5>name = ${myname}</h5>

</body>
</html>
