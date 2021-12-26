<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-02
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope2.jsp</title>
</head>
<body>
    <h1>scope2.jsp页面</h1>
    pageContext域是否有值: <%=pageContext.getAttribute("key")%><br>
    request域是否有值: <%=request.getAttribute("key")%><br>
    session域是否有值: <%=session.getAttribute("key")%><br>
    application域是否有值: <%=application.getAttribute("key")%><br>

    <h2>我是标签2</h2>

</body>
</html>
