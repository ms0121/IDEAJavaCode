<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-09-25
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <%--
        文件上传表单（二进制表单）：
            1.表单的method设置为post
            2.表单的enctype属性设置为multipart/form-data
            3.input的type属性设置为file，且设置对应的name属性

    --%>
    <form action="uploadFile" enctype="multipart/form-data" method="post">
        <input type="file" name="file">
        <button>上传</button>
    </form>
</body>
</html>
