<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--要使用c:foreach的方法--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
    <title>crud</title>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.js"></script>
    <%--    引入css样式--%>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 加载 Bootstrap 的所有 js 插件-->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <%--
        web找资源出现的问题;
            1。不以 / 斜杠开头的找资源，都是以当前资源的路径为基准，经常容易出现问题
            2. 以 / 斜杠开头的找资源，是以服务器的路径为基准(http://localhost:3306)，
                需要加上项目名: http://localhost:3306/crud,
                request.getContextPath()可以获取到项目路径，以斜线开始，不以斜线结尾
    --%>

</head>
<body>
    <div class="container">
        <%--  标题栏 --%>
        <div class="row">
            <div class="col-md-12">
                <h3>Welcome! SSM_CRUD</h3>
            </div>
        </div>

        <%--全局按钮操作栏--%>
        <div class="row">
            <div class="col-md-4 col-md-offset-8">
                <button type="button" class="btn btn-primary">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    添加
                </button>
                <button type="button" class="btn btn-danger">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    删除
                </button>
            </div>
        </div>

        <%-- 内容显示  --%>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover">
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Gender</th>
                            <th>Email</th>
                            <th>Department</th>
                            <th>操作</th>
                        </tr>

                        <c:forEach items="${pageInfo.list}" var="emp">
                            <tr>
                                <th>${emp.empId}</th>
                                <th>${emp.empName}</th>
                                <th>${emp.gender=="m"?"男":"女"}</th>
                                <th>${emp.email}</th>
                                <th>${emp.department.deptName}</th>
                                <th>
                                    <button type="button" class="btn btn-primary btn-sm">
                                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                        编辑
                                    </button>
                                    <button type="button" class="btn btn-danger btn-sm">
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        删除
                                    </button>
                                </th>
                            </tr>
                        </c:forEach>
                </table>
            </div>
        </div>

        <%-- 分页栏 --%>
        <div class="row">

            <%--  分页文字信息          --%>
            <div class="col-md-6">
                <b>第${pageInfo.pageNum}页，共${pageInfo.pages}页，总${pageInfo.total}共条记录!</b>
            </div>

            <%-- 导航条数据信息 --%>
            <div class="col-md-6">
                <nav aria-label="Page navigation" id="page_nv_area">
                    <ul class="pagination">

                        <%-- 首页   --%>
                        <c:if test="${!pageInfo.isFirstPage}">
                            <li><a href="${APP_PATH}/emps?pn=1">首页</a></li>
                        </c:if>

                        <%-- 上一页   --%>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li>
                                <a href="${APP_PATH}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <%-- 导航条   --%>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                            <c:if test="${pageInfo.pageNum == page_Num}">
                                <li class="active"><a href="#">${page_Num}</a></li>
                            </c:if>
                            <c:if test="${pageInfo.pageNum != page_Num}">
                                <li ><a href="${APP_PATH}/emps?pn=${page_Num}">${page_Num}</a></li>
                            </c:if>
                        </c:forEach>

                        <%-- 下一页   --%>
                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                                <a href="${APP_PATH}/emps?pn=${pageInfo.pageNum + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <%-- 末页   --%>
                        <c:if test="${!pageInfo.isLastPage}">
                            <li><a href="${APP_PATH}/emps?pn=${pageInfo.pages}">末页</a></li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</body>
</html>
