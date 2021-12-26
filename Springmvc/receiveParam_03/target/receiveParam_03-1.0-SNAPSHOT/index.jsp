<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>提交表单数据</h1>
    <h3>请求参数名和控制器方法中的形参名一样的情况： </h3>
    <form action="first.do" method="post">
        姓名: <input type="text" name="name"><br>
        年龄: <input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <br>
    <hr>
    <hr>
    <h3>请求参数名和控制器方法中的形数名不一样的情况: </h3>
    <form action="receiveParam.do" >
        姓名: <input type="text" name="rname"><br>
        年龄: <input type="text" name="rage"><br>
        <input type="submit" value="提交">
    </form>

    <br>
    <hr>
    <hr>
    <h3>请求参数比较多的时候，直接使用bean的方式进行封装对象: </h3>
    <form action="receiveObject.do" >
        姓名: <input type="text" name="name"><br>
        年龄: <input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>


</body>
</html>
