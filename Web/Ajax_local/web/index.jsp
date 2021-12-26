
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
            // 3.初始化请求数据信息
            xmlHttp.open("get","ajaxServlet", true);
            // 4.发起请求
            xmlHttp.send();
        }

    </script>
  </head>
  <body>
      <p>局部刷新</p>
      <div>
        用户名: <input type="text" name="name"><br>
          身高：<input type="text" name="height"><br>
          体重: <input type="text" name="weight"><br>
          <input type="submit" value="提交" onclick="doAjax()">
      </div>
  </body>
</html>
