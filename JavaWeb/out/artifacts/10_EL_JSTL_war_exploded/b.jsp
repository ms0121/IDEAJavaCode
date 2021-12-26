<%@ page import="javax.swing.text.WrappedPlainView" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-03
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    EL表达式主要是在jsp页面上输出数据信息，--%>
<%--    主要是输出域对象中的数据--%>
    <%
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key", "session");
        application.setAttribute("key","application");
    %>
<%--    如果有相同的key，则返回范围最小的值--%>
    EL表达式获取值: ${key}

</body>
</html>
