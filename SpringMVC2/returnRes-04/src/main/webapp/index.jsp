<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        // 加载页面信息
        $(function () {
            // 给按钮绑定单击事件
            $("#btn").click(function () {
                // 使用ajax请求
                $.ajax({
                    // url:"returnVoidJson.do", // 无返回值的void方式的请求
                    // url: "requestStudentJson.do",  // 返回是object的请求
                    // url:"requestStudentJsonArray.do", // 返回的是一个List的请求
                    url:"returnStringData.do",
                    data:{
                        name:"东方不败",
                        age:20
                    },
                    type:"post",
                    // dataType:"json", // 返回的是String类型的数据不能指定为json，但是其他类型的需要指定为json
                    dataType:"text",
                    success:function (resp) {
                        // resp代表的是形参，即响应执行成功之后服务器端返回的json格式的数据赋值给该resp形参
                        // jQuery会把字符串转为json对象，赋值给resp形参
                        // alert(resp);
                        // alert(resp.name + " " + resp.age);

                        // 控制器的list集合返回后会被转为json数组的形式
                        // 所以可以使用jQuery的方式进行遍历
                        // $.each(resp, function (i, data) {
                        //     alert(data.name + " " + data.age);
                        // })

                        // 返回的是String的文本类型
                        alert(resp);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>返回值是String的参数</p>
    <form action="some.do" method="post">
        用户名： <input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="注册">
    </form>
    <br>
    <hr>
    <p>返回值类型是void，json数据的形式</p>
    <button id="btn">使用json数据形式</button>

</body>
</html>
