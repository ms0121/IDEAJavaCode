<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-02
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动态包含</title>
</head>
<body>
<%--    动态包含--%>
    <h1>标题1</h1>    
    <h2>标题2</h2>

    <%--
        <jsp:include page=""> 这是动态包含
        page属性是指定你要包含的jsp页面的路径
        动态包含也可以像静态包含一样，把被包含的内容执行输出到包含的位置

        动态包含的特点：
            1.动态包含会把包含的jsp页面也翻译成为java代码
            2.动态包含底层的代码使用如下代码去调用被包含的jsp页面去执行输出
            3. 动态包含，还可以传递参数

    --%>

    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value="root"/>
        <jsp:param name="password" value="123456"/>
    </jsp:include>

</body>
</html>








