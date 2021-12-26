
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
            if (xmlHttp.readyState==4 && xmlHttp.status==200){
                // alert(xmlHttp.responseText);
                // 获取返回的数据信息
                var data = xmlHttp.responseText;
                // 更新dom对象。并把数据更新到页面上
                document.getElementById("mydata").innerText = data;
            }
        }
        // 获取输入框中的元素值
        var name = document.getElementById("name").value;
        var height = document.getElementById("height").value;
        var weight = document.getElementById("weight").value;
        var param = "name=" + name + "&height=" + height + "&weight=" + weight;
        // alert(param);
        // 3.初始化请求数据信息
        xmlHttp.open("get", "ajaxServlet?" + param, true);
        // 4.发起请求
        xmlHttp.send();
    }

  </script>
</head>
<body>
    <p>局部刷新</p>
    <div>
        用户名: <input type="text" id="name"><br>
        身高：<input type="text" id="height"><br>
        体重: <input type="text" id="weight"><br>
        <input type="submit" value="提交" onclick="doAjax()">

        <hr>
        <hr>
        <br>
        <div id="mydata">
            异步方法获取的数据更新中..........
        </div>

    </div>
</body>
</html>
