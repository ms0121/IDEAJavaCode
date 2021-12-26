
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>注册页面</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div align="center">
        <img src="images/wbb.jpg" width="150px" height="150px"><br>
        <form action="student/addStudent.do" method="get">
            姓名: <input type="text" name="name"><br>
            年龄: <input type="text" name="age"><br>
            <input type="submit" value="注册">
        </form>
    </div>
</body>
</html>
