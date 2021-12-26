<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-02
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>

<%--    1. 静态包含--%>
    <h1>标题1</h1>
    <h2>标题2</h2>
<%--        <%@include file="" 就是静态包含， file属性指定你要包含的页面路径 --%>
<%--        地址中的第一个斜杆 / 表示为http://ip:port/工程路径/   映射到代码的web目录下--%>
<%--        静态包含的特点：--%>
<%--            1. 静态包含不会翻译被包含的jsp页面    --%>
<%--            2. 静态包含其实是把被包含的jsp页面的代码拷贝到被包含的位置执行输出 --%>
    <%@include file="/include/footer.jsp"%>



</body>
</html>
