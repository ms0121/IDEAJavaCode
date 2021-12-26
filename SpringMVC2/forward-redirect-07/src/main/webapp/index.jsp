<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
</head>
<body>
    <p>forward请求转发的实现</p>
    <form action="forward.do" method="post">
        用户名： <input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="注册">
    </form>

    <br>
    <hr>
    <p>redirect重定向的实现</p>
    <form action="redirect.do" method="post">
        用户名： <input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="注册">
    </form>

</body>
</html>
