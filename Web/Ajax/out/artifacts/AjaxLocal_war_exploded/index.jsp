<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        <%--  直接使用ajax的方式     --%>
        $(function () {
            $("#btn").click(function () {
                // 获取id
                var proid = $("#proid").val();
                // alert(proid);

                // alert("正在响应事件");
                $.ajax({
                    url:"queryJsonServlet",
                    data:{
                        proid:proid
                    },
                    type:"get",
                    dataType:"json",
                    success:function (data) {
                        $("#proname").val(data.name);
                        $("#projiancheng").val(data.jiancheng);
                        $("#proshenghui").val(data.shenghui);
                    }
                })
            })
        })






        function search() {
            // 发送ajax请求，传递参数给服务器，服务器返回数据
            // 1.创建异步对象
            var xmlHttp = new XMLHttpRequest();
            // 2。绑定事件
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.status == 200 && xmlHttp.readyState == 4){
                    // alert(xmlHttp.responseText);
                    var data = xmlHttp.responseText;
                    // 将字符串转为json对象，方便进行取值
                    var jsondata = eval("(" + data + ")");
                    // 更新dom对象，把服务端发回来的数据保存到文本编辑框中
                    document.getElementById("proname").value = jsondata.name;
                    document.getElementById("projiancheng").value = jsondata.jiancheng;
                    document.getElementById("proshenghui").value = jsondata.shenghui;
                }
            }
            // 3。初始化请求数据信息,第二个参数是指servlet中的方法
            var proid = document.getElementById("proid").value;

            // true：代表异步请求，使用异步对象发起请求后，不用等待数据处理完毕，就可以执行其他的代码
            // false：同步，异步对象必须处理完成请求，从服务器端获取到数据之后，才能执行之后的代码，任意时刻只能执行一个异步请求
            xmlHttp.open("get", "queryJsonServlet?proid="+proid, true);
            // 4。发送请求
            xmlHttp.send();
        }

    </script>

</head>
<body>

    <p>根据省份id获取省会城市(使用json)</p>
    <table>
        <tr>
            <td>省份编号: </td>
            <td>
                <input type="text" id="proid">
                <input type="button" value="搜索" id="btn">
            </td>
        </tr>

        <tr>
            <td>省份名称: </td>
            <td>
                <input type="text" id="proname">
            </td>
        </tr>
        <tr>
            <td>省份简称: </td>
            <td>
                <input type="text" id="projiancheng">
            </td>
        </tr>
        <tr>
            <td>省会城市: </td>
            <td>
                <input type="text" id="proshenghui">
            </td>
        </tr>

    </table>
</body>
</html>
