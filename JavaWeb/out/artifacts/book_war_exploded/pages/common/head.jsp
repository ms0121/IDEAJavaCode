<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-04
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--动态的获取当前地址--%>
<%
    String basePath = request.getScheme()
        + "://"
        + request.getServerName()
        + ":"
        + request.getServerPort()
        + request.getContextPath()
        + "/";
    // / 必不可少
    pageContext.setAttribute("basePath", basePath);
%>

<!--base标签，永远固定相对路径跳转的结果-->
<%--<base href="http://localhost:8080/book/">--%>
<base href="<%=basePath%>">

<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
