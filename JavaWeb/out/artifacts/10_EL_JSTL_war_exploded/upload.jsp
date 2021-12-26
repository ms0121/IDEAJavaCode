<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-03
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload页面</title>
</head>
<body>
    <form action="http://localhost:8080/10_EL_JSTL/uploadServlet" enctype="multipart/form-data" method="post">
        用户名: <input type="text" name="username" ><br>
        头像: <input type="file"  name="photo"><br>
        <input type="submit" value="上传">
    </form>

</body>
</html>
