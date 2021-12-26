<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>

<html>
<head>
    <title>学生信息</title>
    <base href="<%=basePath%>">

    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        // 加载页面信息
        $(function () {
            // 在当前页面dom对象加载后，就执行loadStudentData()函数显示数据信息
            loadStudentData();
            // 给按钮绑定响应单击事件，单击之后显示学生列表
            $("#btnLoader").click(function () {
               loadStudentData();
            });
        });

        function loadStudentData() {
            // 执行ajax请求,没有参数
            $.ajax({
                url:"student/queryStudent.do", // 跳转到该方法
                type:"get", // 请求方式
                dataType:"json", // 数据格式
                success:function (data) {  // 相应成功的处理函数,data是一个参数。名字自定义
                    // 清除旧的数据信息
                    $("#info").html("");
                    // 然后再循环的遍历新的数据信息
                    // 将得到的json数据data使用each进行循环处理显示,n代表取出来的每一个student数据信息
                    $.each(data, function (i, n) {
                        // 将数据追加到<tbody id="info">这里面进行显示（行和列）
                        $("#info").append("<tr>").
                        append("<td>" + n.id + "</td>").
                        append("<td>" + n.name + "</td>").
                        append("<td>" + n.age + "</td>").append("</tr>")
                    });
                }
            })
        }

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
