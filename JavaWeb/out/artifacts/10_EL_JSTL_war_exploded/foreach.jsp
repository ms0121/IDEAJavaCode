<%@ page import="sun.awt.SunHints" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.sun.org.apache.xpath.internal.operations.String" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-03
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>foreach页面</title>
</head>
<body>

    <%--    遍历输出1-10之间的数字
           1.遍历 1 到 10，输出
            begin 属性设置开始的索引
            end 属性设置结束的索引
            var 属性表示循环的变量(也是当前正在遍历到的数据)
            for (int i = 1; i < 10; i++)
    --%>
    <table border="1">
        <c:forEach begin="1" end="10" var="i">
            <tr>
                <td>第${i}行</td>
            </tr>
        </c:forEach>
    </table>


    <%-- 2.遍历 Object 数组
        for (Object item: arr)
        items 表示遍历的数据源（遍历的集合）
        var 表示当前遍历到的数据
    --%>
    <%
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + 1;
        }
        request.setAttribute("arr", ints);
    %>
    <c:forEach items="${requestScope.arr}" var="temp">
        ${temp}<br>
    </c:forEach>

    <%--  遍历map集合  --%>
    <%
        Map<java.lang.String, java.lang.String> stringStringMap = new HashMap<>();
        stringStringMap.put("key1", "value1");
        stringStringMap.put("key2", "value2");
        stringStringMap.put("key3", "value3");

        request.setAttribute("map", stringStringMap);
    %>
    <c:forEach items="${requestScope.map}" var="entry">
        <h1>${entry.key}: ${entry.value}</h1>
    </c:forEach>





</body>
</html>
