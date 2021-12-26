<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%--  使用静态包含，包含base标签，css样式，JQuery文件， 将公共的部分进行抽取出来 --%>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            // 给a标签绑定单击事件，实现弹窗提示信息,用于删除的确认提示操作
            $("a.deleteClass").click(function () {
                /**
                 * confirm是确认提示框函数
                 * 参数是它的提示内容
                 * 它有两个按钮，一个是确认，一个是取消
                 * 返回true表示点击了确认，返回false表示点击了取消
                 * return false; // 阻止了元素的默认行为 == 不提交请求
                 * 在事件的默认函数中，有一个this对象，这个this对象就是当前点击的 a 标签部分，并通过父元素的父元素找到，
                 * 也就是当前正在响应事件的都没对象
                 */
                return confirm("你确认要删除 [" + $(this).parent().parent().find("td:first").text() + "] 吗");
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>

    <%--	使用静态包含，将公共的部分进行抽取出来		--%>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                    <%--	点击修改之后，a标签（只可以使用get请求）将会跳转到servlet程序中进行调用 --%>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                    <%--	给a标签绑定单击事件 --%>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <%--  再添加图书的时候，将总页数数值传到servlet中去，添加成功之后将在最后一页进行显示   --%>
            <td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>


        <%--静态页面包含	--%>
        <%@include file="/pages/common/page_nav.jsp"%>

</div>

<%--	静态包含页脚信息 , 都有公共的部分 --%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>