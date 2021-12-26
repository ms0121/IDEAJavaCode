<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.4.1.js"> </script>
    <script type="text/javascript">
        // 加载页面
        $(function () {
            // 给按钮添加单击事件
            $("#btnLoader").click(function () {
                // 清除旧的数据信息
                $("#info").html("");
                // 读取获得的json数据信息
                $.ajax({
                    url:"student/listStudent.do",
                    type:"get",
                    dataType:"json",
                    success:function (data) {
                        // 把获取到的数据信息进行遍历
                        $.each(data, function (i, n) {
                            // 将数据追加到<tbody id="info">这里面进行显示（行和列）
                            $("#info").append("<tr>").append("<td>" + n.id + "</td>").
                            append("<td>" + n.name + "</td>").append("<td>" + n.age + "</td>").
                            append("</tr>")
                        })
                    }
                })
            })
        })
    </script>

</head>
<body>
    <%-- 使用一个表格进行显示数据信息   --%>
    <div align="center">
        <table>
            <%--  表头  --%>
            <thead>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
            </thead>

            <%--  表格主体 --%>
            <tbody id="info">
            </tbody>
        </table>
        <input type="button" id="btnLoader" value="查询">
        <a href="index.jsp"><input type="button" value="首页"></a>
    </div>
</body>
</html>
