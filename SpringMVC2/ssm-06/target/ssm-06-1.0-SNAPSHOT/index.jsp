<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>index</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div align="center">
        <p>SSM整合</p>
        <table>
            <tr>
                <td><a href="addStudent.jsp">学生注册</a></td>
            </tr>
            <tr>
                <td><a href="listStudent.jsp">显示学生</a></td>
            </tr>
        </table>
    </div>
</body>
</html>
