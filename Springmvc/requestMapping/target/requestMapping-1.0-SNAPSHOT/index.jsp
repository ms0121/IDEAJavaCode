<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>这是第一个springmvc项目</h1>
    <h3><a href="test/some.do"> 我是some.do请求! </a></h3>
    <h3><a href="test/other.do"> 我是other.do请求! </a></h3>
    <br>
    <br>
    <hr>
    <h3><a href="user/some.do"> 我是some.do的get请求! </a></h3>
    <%--    <h3><a href="user/other.do"> 我是other.do的post请求! </a></h3>--%>
    <form action="user/other.do" method="post">
        <input type="submit" value="我是other.do的post请求!">
    </form>

    <h3><a href="user/first.do">我是first方法!</a> </h3>
</body>
</html>
