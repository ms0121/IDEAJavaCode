<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-03
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>四个特定域中的属性</title>
</head>
<body>
    <%--EL  获取四个特定域中的属性--%>
    <%--pageScope ====== pageContext 域--%>
    <%--requestScope ====== Request 域--%>
    <%--sessionScope ====== Session 域--%>
    <%--applicationScope ====== ServletContext 域--%>

    <%
        // 设置属性值
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>

    <h3>通过EL表达式获取四个属性值</h3>
    pageContext: ${pageScope.key}<br>
    request: ${requestScope.key}<br>
    session: ${sessionScope.key}<br>
    application: ${applicationScope.key}<br>



</body>
</html>
