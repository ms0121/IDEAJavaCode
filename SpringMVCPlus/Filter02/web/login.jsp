<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-09-25
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        // 判断用户名是否为空
        function login() {
            var name = $("#name").val();
            console.log(name);
            if (name != null && name.trim() != ''){
                // 用户名不为空，则进行表单提交,提交到指定的路径上
                $("#formData").submit();
            }
        }
    </script>
</head>
<body>
    <form action="login" id="formData">
       用户名: <input type="text" name="name" id="name"><br>
        <button type="button" onclick="login()">登录</button>
    </form>
</body>
</html>
