<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-03
  Time: 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp页面</title>
</head>
<body>
    <%
        request.setAttribute("key", "value");
    %>

    <h2>值存在的情况: </h2>
    以前jsp获取属性值的方式: <%=request.getAttribute("key")%>
    <br>
    现在在EL表达式获取属性值的方式: ${key}

    <h2>值不存在的情况下返回的结果显示: </h2>
    以前jsp获取属性值的方式: <%=request.getAttribute("key1")%>
    <br>
    现在在EL表达式获取属性值的方式: ${key1}
</body>
</html>
