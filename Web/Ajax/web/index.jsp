<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script type="text/javascript">
        // 实用内存中的异步对象，代替浏览器发起的请求，异步对象使用js创建和管理
        function doAjax() {
            // 1。创建异步对象
            var xmlHttp = new XMLHttpRequest();
            // 2，绑定事件
            xmlHttp.onreadystatechange = function () {
                // 处理服务器端返回的数据，更新当前页面信息
            }
            // 获取输入框中的元素值
            var name = document.getElementById("name").value;
            var height = document.getElementById("height").value;
            var weight = document.getElementById("weight").value;
            var param = "name=" + name + "&height=" + height + "&weight=" + weight;
            alert(param);
            // 3.初始化请求数据信息
            xmlHttp.open("get", "ajaxServlet?" + param, true);
            // 4.发起请求
            xmlHttp.send();
        }

    </script>

</head>
<body>
<h3>ajax刷新机制</h3>
<div>
    用户名：<input type="text" id="name"><br>
    身高：<input type="text" id="height"><br>
    体重：<input type="text" id="weight"><br>
    <input type="submit" value="提交" onclick="doAjax()"><br>
</div>
<br>
<hr>
<hr>
<br>

<h3>使用表提交的方式</h3>
<div>
    <form action="bmiServlet" method="get">
        用户名：<input type="text" name="name"><br>
        身高：<input type="text" name="height"><br>
        体重：<input type="text" name="weight"><br>
        <input type="submit" value="提交"><br>
    </form>
</div>

</body>
</html>
