<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>学生</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        // 加载页面
        $(function () {
            // 页面加载完成之后，直接显示数据信息
            loadData();
            // 给加载信息的按钮绑定单击事件
            $("#btnLoad").click(function () {
                // 点击按钮之后重新加载数据信息
                loadData();
            })
        })

        function loadData() {
            // 点击之后发起ajax请求读取数据信息
            $.ajax({
                url:"student/queryStudent.do",
                type:"get",
                dataType:"json",
                success:function (resp) {
                    // 每次加载清空页面信息
                    $("#info").html("");
                    // alert(resp);
                    $.each(resp, function (i, n) {
                        $("#info").append("<tr>")
                            .append(" <td>" + n.id + "</td>")
                            .append(" <td>" + n.name + "</td>")
                            .append(" <td>" + n.age + "</td>").append("</tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
    <div align="center">
        <table align="center">
            <thead>
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>年龄</td>
                </tr>
            </thead>
            <tbody id="info">

            </tbody>
        </table>
        <input type="button" value="加载信息" id="btnLoad">
    </div>

</body>
</html>
