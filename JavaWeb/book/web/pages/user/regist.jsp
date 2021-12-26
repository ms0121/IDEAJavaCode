<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>

    <!--在base标签中，永远固定相对路径的跳转结果,此时默认会跳转到book下的web目录之下, 最后的斜杠不能丢-->
    <%--  使用静态包含，将公共的部分进行抽取出来 --%>
    <%@include file="/pages/common/head.jsp" %>


    <script type="text/javascript">

        // 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
        // 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
        // 验证确认密码：和密码相同
        // 邮箱验证：xxxxx@xxx.com
        // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成

        // 加载页面
        $(function () {

            // 给用户名绑定单击事件
            $("#username").blur(function () {
                // 获取输入框中的用户名
                // this代表当前响应事件的dom对象
                var username = this.value;
               $.getJSON(
                   "http://localhost:8080/book/userServlet",
                    "action=ajaxExistsUsername&username=" + username,
                   function (data) {
                       if (data.existsUsername){
                           $("span.errorMsg").text("用户名已存在");
                       }else {
                           $("span.errorMsg").text(" 用户名可用！");
                       }
                   }
               )
            });


            // 给验证码绑定单击事件
            $("#img_data").click(function () {
                // 在事件响应的function函数中有一个this对象，这个this对象，就是当前正在响应事件的dom对象
                // 因此这里的this(dom)对象就是验证的 <img>，那么就可以给该对象的属性进行赋值
                // src表示验证码img标签的图片路径，它可读，可写
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            });

            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                // 1.获取用户名输入框中的内容
                var usernameText = $("#username").val();
                // 2 创建正则表达式
                var usernamePatt = /^\w{5,12}$/;
                // 使用test的方法进行验证
                if (!usernamePatt.test(usernameText)) {
                    // 提示用户结果
                    $("span.errorMsg").text("用户名不合法!");
                    return false;
                }

                // 如果用户名合法就不显示
                $("span.errorMsg").text("");
            });

            // 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
            $("#sub_btn").click(function () {
                // 1. 获取用户名密码
                var passwordText = $("#password").val();
                // 2.正则表达式
                var passwordPatt = /^\w{5,12}$/;
                // 3.验证
                if (!passwordPatt.test(passwordText)) {
                    // 提示用户
                    $("span.errorMsg").text("用户名密码不合法!");
                    return false;
                }

                // 验证确认密码：和密码相同
                var repwdText = $("#repwd").val();
                var passwordText = $("#password").val();
                if (!(repwdText == passwordText)) {
                    $("span.errorMsg").text("密码不一致!");
                    return false;
                }


                // 邮箱验证：xxxxx@xxx.com
                var emailText = $("#email").val();
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPatt.test(emailText)) {
                    $("span.errorMsg").text("邮箱不合法!");
                    return false;
                }

                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成
                var codeText = $("#code").val();
                //去掉验证码前后空格
                // alert(" 去空格前：[" + codeText + "]")
                codeText = $.trim(codeText);
                // alert(" 去空格后：[" + codeText + "]")
                if (codeText == null || codeText == "") {
                    //4 提示用户
                    $("span.errorMsg").text(" 验证码不能为空！");
                    return false;
                }
                // 防止跳转
                $("span.errorMsg").text("");
            });
        });

    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <%--    将用户注册失败的信息显示在注册注册页面上      --%>
                    <span class="errorMsg">
                        <%-- 注册失败的错误信息,表达式脚本，不推荐使用 --%>
                        <%--   <%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>--%>
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username" id="username"
                               <%---表达式脚本。不推荐使用--%>
                                <%--  value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"                        --%>
                                value="${requestScope.username}"
                        />
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               autocomplete="off" tabindex="1" name="email" id="email"
                                <%--  表达式脚本，不推荐使用， 直接使用EL表达式 --%>
                                <%-- value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"--%>
                                value="${requestScope.email}"
                        />
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" value="" style="width: 150px;" id="code"/>
                        <img id="img_data" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 80px; height: 30px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%--	静态包含页脚信息 , 都有公共的部分 --%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>