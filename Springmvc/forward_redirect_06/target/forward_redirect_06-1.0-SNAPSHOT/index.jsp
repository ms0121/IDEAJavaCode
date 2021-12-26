<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <div align="center">
        <h1>forward请求转发</h1>
        <form action="forward.do" method="post">
            姓名: <input type="text" name="name"><br>
            年龄: <input type="text" name="age"><br>
            <input type="submit" value="提交">
        </form>
    </div>

    <br>
    <hr>

    <div align="center">
        <h1>redirect重定向</h1>
        <form action="redirect.do" method="post">
            姓名: <input type="text" name="name"><br>
            年龄: <input type="text" name="age"><br>
            <input type="submit" value="提交">
        </form>
    </div>

</body>
</html>
