<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-03
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext使用</title>
</head>
<body>
    <%--
        和下列EL表达式使用的方式一样:
            request.getScheme() 它可以获取请求的协议
            request.getServerName() 获取请求的服务器 ip 或域名
            request.getServerPort() 获取请求的服务器端口号
            getContextPath() 获取当前工程路径
            request.getMethod() 获取请求的方式（GET 或 POST）
            request.getRemoteHost() 获取客户端的 ip 地址
            session.getId() 获取会话的唯一标识
    --%>
    <%--    直接使用jsp表达式的方式--%>
    <%=request.getScheme()%>

    <h3>ii. pageContext  对象的使用</h3><br>
    1. 协议：${pageContext.request.scheme}<br>
    2. 服务器 ip：${pageContext.request.serverName}<br>
    3. 服务器端口：${pageContext.request.serverPort}<br>
    4.  获取工程路径：${pageContext.request.servletPath}<br>
    5. 获取请求方法：${pageContext.request.method}<br>
    6. 获取客户端 ip 地址：${pageContext.request.remoteHost}<br>
    7. 获取会话的 id 编号：${pageContext.session.id}<br>
</body>
</html>
