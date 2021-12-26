<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl的核心库，进行遍历获取到的信息--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<%--
    web的路径问题：
       1. 不以 / 开头的相对路径，找资源，以当前资源的路径为基准，经常容易出现问题
       2. 以 / 开头的相对路径找资源，以服务器的路径为标准(http://localhost:3306),
            需要加上项目名: http://localhost:3306/crud,
            request.getContextPath()可以获取到项目路径，以斜线开始，不以斜线结尾
--%>

<html>
<head>
    <title>员工列表</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.js"></script>
    <%--    引入css样式--%>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 加载 Bootstrap 的所有 js 插件-->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
    <%--搭建显示页面，共有4行--%>
    <div class="container">
        <%-- 标题  --%>
        <div class="row">
            <div class="col-md-12">
              <h2>SSM-CRUD</h2>
            </div>
        </div>
        <%--  按钮  --%>
        <div class="row">
            <div class="col-md-4 col-md-offset-8">
                <button type="button" class="btn btn-primary">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    add
                </button>
                <button type="button" class="btn btn-danger">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    delete
                </button>
            </div>
        </div>
        <%--  显示表格数据信息  --%>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Gender</th>
                            <th>Email</th>
                            <th>Department</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <c:forEach items="${pageInfo.list}" var="emp">
                        <tbody>
                            <tr>
                                <th>${emp.empId}</th>
                                <th>${emp.empName}</th>
                                <th>${emp.gender == "m"? "男":"女"}</th>
                                <th>${emp.email}</th>
                                <th>${emp.department.deptName}</th>
                                <th>
                                    <button class="btn btn-primary btn-sm">
                                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> edit
                                    </button>
                                    <button class="btn btn-danger btn-sm">
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> delete
                                    </button>
                                </th>
                            </tr>
                        </tbody>
                    </c:forEach>

                </table>
            </div>
        </div>

        <%-- 显示分页信息,两列，各占据一半 --%>
        <div class="row">
            <%--  分页文字信息          --%>
            <div class="col-md-6">
                第${pageInfo.pageNum}页，共${pageInfo.pages}页，总${pageInfo.total}共条记录!
            </div>
            <%-- 分页条信息 --%>
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li><a href="${APP_PATH}/emps?pn=1">首页</a></li>

                        <%--  如果有上一页就显示   --%>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li>
                                <a href="${APP_PATH}/emps?pn=${pageInfo.pageNum - 1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                            <%--  给当前页面加上高亮     --%>
                            <c:if test="${page_Num == pageInfo.pageNum}">
                                <li class="active"><a href="#">${page_Num}</a></li>
                            </c:if>
                            <%--  不是当前页面的不加高亮     --%>
                            <c:if test="${page_Num != pageInfo.pageNum}">
                                <li ><a href="${APP_PATH}/emps?pn=${page_Num}">${page_Num}</a></li>
                            </c:if>
                        </c:forEach>

                        <%--  如果有上一页就显示   --%>
                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                                <a href="${APP_PATH}/emps?pn=${pageInfo.pageNum + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <%--  显示末页信息    --%>
                        <li><a href="${APP_PATH}/emps?pn=${pageInfo.pages}">末页</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</body>
</html>
