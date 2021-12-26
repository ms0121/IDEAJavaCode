<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-04
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <%-- manager/bookServlet表示请求资源的地址，action=list 表示要
    调用BookServlet里面的list方法 --%>
    <a href="manager/bookServlet?action=page">图书管理</a>
    <a href="pages/manager/order_manager.jsp">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>