<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-03
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>other其他隐含对象</title>
</head>
<body>
    <h2>其他隐含对象的使用: </h2>
    <%--
        // param           Map<String,String>       它可以获取请求参数的值
        // paramValues     Map<String,String[]>     它也可以获取请求参数的值，获取多个值的时候使用。
    --%>
<%--    http://localhost:8080/10_EL_JSTL/other.jsp?username=zhangsan&password=123456&hobby=java&hobby=.cpp --%>
    参数的username: ${param.username}<br>
    参数的password: ${param.password}<br>

    输出请求参数 username 的值：${ paramValues.username[0] } <br>
    输出请求参数 hobby 的值：${ paramValues.hobby[0] } <br>
    输出请求参数 hobby 的值：${ paramValues.hobby[1] } <br>

    <%--
        // header           Map<String,String>      它可以获取请求头的信息
        // headerValues     Map<String,String[]>    它可以获取请求头的信息，它可以获取多个值的情况
    --%>
    header代理浏览器: ${header["User-Agent"]}<br>
    header连接状态: ${header.Connection}<br>
    header代理浏览器: ${headerValues["User-Agent"][0]}<br>


    <%-- cookie      Map<String,Cookie>      它可以获取当前请求的 Cookie 信息   --%>
    cookie名称: ${cookie.JSESSIONID.name}<br>
    cookie值: ${cookie.JSESSIONID.value}<br>

    <%--  获取web.xml中的配置参数信息  --%>
    <%--initParam    Map<String,String>    它可以获取在 web.xml 中配置的<context-param>上下文参数--%>
    参数的username: ${initParam.username}<br>
    参数的password: ${initParam.url}<br>

</body>
</html>
