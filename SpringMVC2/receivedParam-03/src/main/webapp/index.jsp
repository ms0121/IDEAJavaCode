<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <p>接收参数的页面信息</p>
    <form action="some.do" method="post">
        用户名： <input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="注册">
    </form>

    <br>
    <hr>
    <p>请求中参数名和处理器方法中的参数名不一致</p>
    <form action="some1.do">
        用户名： <input type="text" name="rname"><br>
        年龄：<input type="text" name="rage"><br>
        <input type="submit" value="注册">
    </form>

    <br>
    <hr>
    <p>处理器方法参数为对象接收的方式</p>
    <form action="some2.do">
        用户名： <input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="注册">
    </form>

</body>
</html>
