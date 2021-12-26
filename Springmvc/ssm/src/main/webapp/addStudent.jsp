<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>注册</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div align="center">
        <div>
            <img src="images/wbb.jpg" height="200px" width="200px">
            <h3>王冰冰欢迎你来注册</h3>
        </div>

        <div>
        <form action="student/addStudent.do" method="post">
            <div align="center">
                <table>
                    <tr>
                        <%--   这里的形参名必须和bean中的参数名一直   --%>
                        <td>姓名:</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>年龄:</td>
                        <td><input type="text" name="age"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="注册"></td>
                        <a href="index.jsp"><input type="button" value="首页"></a>
                    </tr>
                </table>
            </div>
        </form>
        </div>

    </div>
</body>
</html>
