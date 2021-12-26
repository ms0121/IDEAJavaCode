<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $("button").click(function(){
                //alert("button click");
                $.ajax({
                    // url:"returnVoid.do",
                    // url:"returnStudentJson.do", // 方式2
                    url: "returnStudentJsonArray.do",  // 方式3
                    data:{
                        name:"zhangsan",
                        age:20
                    },
                    type:"post",
                    dataType:"text",
                    //dataType:"json",
                    success:function(resp){
                        //resp从服务器端返回的是json格式的字符串 {"name":"zhangsan","age":20}
                        //jquery会把字符串转为json对象， 赋值给resp形参。

                        // [{"name":"李四同学","age":20},{"name":"张三","age":28}]
                        //alert(resp.name + "    "+resp.age);  // 方式2

                        // 方式3
                        $.each(resp,function(i,n){
                            alert(n.name+"   "+n.age)
                        })

                        // alert("返回的是文本数据："+resp);
                    }
                })
            })
        })
    </script>
</head>
<body>

    <h1>提交表单数据</h1>
    <h5></h5>
    <form action="returnStringView.do" method="post">
        姓名: <input type="text" name="name"><br>
        年龄: <input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <br>
    <hr>
    <form action="returnStringView2.do" method="post">
        姓名: <input type="text" name="name"><br>
        年龄: <input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <br/>
    <br/>
    <button id="btn">发起ajax请求</button>


</body>
</html>
