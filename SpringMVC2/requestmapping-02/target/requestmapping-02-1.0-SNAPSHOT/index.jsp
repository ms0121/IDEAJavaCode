<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <p>这是个简单的页面信息</p>
    <a href="test/some.do">发起some.do的GET请求</a><br>
    <form action="test/other.do" method="post">
        <input type="submit" value="发起post请求的方式">
    </form><br>
    <a href="test/first.do">发起first.do请求</a><br>
</body>
</html>
