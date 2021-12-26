<%@ page import="com.liu.Bean.Person" %>
<%@ page import="com.sun.org.apache.xpath.internal.operations.String" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-03
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>
        EL表达式输出Bean对象中的普通的属性，主要是查看
        Bean中是否有get方法，并不是按照属性名
    </h2>

    <%
        // 创建对象并设置属性值
        Person person = new Person();
        person.setName("张三");
        person.setPhone(new java.lang.String[]{"329839283","73267467","78372873"});
        ArrayList<java.lang.String> list = new ArrayList<>();
        list.add("北京");
        list.add("上海");
        list.add("深圳");
        person.setCities(list);

        Map<java.lang.String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        person.setMap(map);

        pageContext.setAttribute("p", person);
    %>

    <h3>输出Person类中的属性值: </h3>
    ${p.name}<br>
    ${p.cities}<br>
    ${p.cities[0]}<br>
    ${p.phone[2]}<br>
    ${p.map}<br>
    ${p.map.key1}<br>
    ${p.age}<br>

</body>
</html>
