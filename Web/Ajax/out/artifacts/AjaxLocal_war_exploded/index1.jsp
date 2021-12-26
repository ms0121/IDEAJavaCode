<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script type="text/javascript">
        function search() {
            // 发送ajax请求，传递参数给服务器，服务器返回数据
            // 1.创建异步对象
            var xmlHttp = new XMLHttpRequest();
            // 2。绑定事件
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.status == 200 && xmlHttp.readyState == 4){
                    // alert(xmlHttp.responseText);
                    // 把服务端发回来的数据保存到文本编辑框中
                    document.getElementById("proname").value = xmlHttp.responseText;
                }
            }

            // 3。初始化请求数据信息,第二个参数是指servlet中的方法
            var proid = document.getElementById("proid").value;
            xmlHttp.open("get", "queryProvince?proid="+proid, true);
            // 4。发送请求
            xmlHttp.send();
        }

    </script>

</head>
<body>

    <p>根据省份id获取省会城市(不使用json)</p>
    <table>
        <tr>
            <td>省份编号: </td>
            <td>
                <input type="text" id="proid">
                <input type="button" value="搜索" onclick="search()">
            </td>
        </tr>

        <tr>
            <td>省份名称: </td>
            <td>
                <input type="text" id="proname">
            </td>
        </tr>
    </table>
</body>
</html>
