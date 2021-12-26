<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-03
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--关系运算符--%>
    ${12 == 12} 或者 ${12 eq 12}
    <br>
    <%--  逻辑表达式  --%>
    ${ 12 == 12 && 12 < 11 } 或 ${ 12 == 12 and 12 < 11 }

    <%--    .点运算，可以输出 Bean 对象中某个属性的值。--%>
    <%--    []中括号运算，可以输出有序集合中某个元素的值。--%>
    <%--    并且[]中括号运算，还可以输出 map 集合中 key 里含有特殊字符的 key 的值。--%>
    <%
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("key1", "value1");
        stringStringHashMap.put("a-a-a","value2");
        stringStringHashMap.put("b.b.b","value3");
        request.setAttribute("map", stringStringHashMap);
    %>
    <h3>获取map中的值：</h3>
    ${map["key1"]}
    ${map["a-a-a"]}
    ${map["b.b.b"]}



</body>
</html>
