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
    <p>填写注册信息</p>
    <div>
        <form action="student/addStudent.do" method="post">
            <%--  当前的属性名必须和Student对象的属性名一致   --%>
            <table>
                <tr>
                    <td>用户名:</td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>年龄:</td>
                    <td>
                        <input type="text" name="age">
                    </td>
                </tr>
            </table>
            <input type="submit" name="btn" value="注册">
        </form>
    </div>
</div>
</body>
</html>
