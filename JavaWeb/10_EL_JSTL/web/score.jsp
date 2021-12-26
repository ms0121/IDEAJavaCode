<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-03
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL页面展示</title>
</head>
<body>

    <%--    core  核心库使用
            i. <c:set /> (使用很少)
            作用：set 标签可以往域中保存数据
            域对象.setAttribute(key,value);
            scope 属性设置保存到哪个域
            page 表示 PageContext 域（默认值）
            request 表示 Request 域
            session 表示 Session 域
            application 表示 ServletContext 域
            var 属性设置 key 是多少
            value 属性设置值
    --%>
    set设置之后: ${requestScope.abc}<br>
    <c:set scope="request" var="abc" value="abc123"/>
    set设置之前: ${requestScope.abc}<br>


    <%--
        // ii.<c:if />
        // if 标签用来做 if 判断。
        // test 属性表示判断的条件（使用 EL 表达式输出）
    --%>
    <c:if test="${12 == 12}">
        <h2>12 等于 12! </h2>
    </c:if>


    <%--
        iii.<c:choose> <c:when> <c:otherwise>标签
        作用：多路判断。跟 switch ... case .... default 非常接近
        choose 标签开始选择判断
        when 标签表示每一种判断情况
        test 属性表示当前这种判断情况的值
        otherwise 标签表示剩下的情况
        <c:choose> <c:when> <c:otherwise>标签使用时需要注意的点：
        1、标签里不能使用 html 注释，要使用 jsp 注释
        2、when 标签的父标签一定要是 choose 标签
    --%>
    <%--    设置相应的属性值--%>
    <%request.setAttribute("score", 89);%>
    <c:choose>
        <c:when test="${score > 90}">
            <h3>大于90分，很优秀!</h3>
        </c:when>

        <c:when test="${score > 80}">
            <h3>大于80分，不错!</h3>
        </c:when>

        <c:when test="${score > 60}">
            <h3>大于60分，及格了!</h3>
        </c:when>

        <c:otherwise>
            <h3>小于60分，还要多加努力!</h3>
        </c:otherwise>
    </c:choose>


</body>
</html>
