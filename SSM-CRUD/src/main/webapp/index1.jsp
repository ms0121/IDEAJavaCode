<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl的核心库，进行遍历获取到的信息--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<%--
    web的路径问题：
       1. 不以 / 开头的相对路径，找资源，以当前资源的路径为基准，经常容易出现问题
       2. 以 / 开头的相对路径找资源，以服务器的路径为标准(http://localhost:3306),
            需要加上项目名: http://localhost:3306/crud,
            request.getContextPath()可以获取到项目路径，以斜线开始，不以斜线结尾
--%>

<html>
<head>
    <title>员工列表</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.js"></script>
    <%--    引入css样式--%>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 加载 Bootstrap 的所有 js 插件-->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>

<%-- 修改员工信息，模态框   --%>
<!-- Modal -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">员工编辑</h4>
            </div>
            <div class="modal-body">
                <%--   弹窗的表单    --%>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <%--     静态标签--%>
                            <p class="form-control-static" id="empName_update_static"></p>
                            <%--   错误提示框，文本内容在验证的部分进行设置值   --%>
                            <span class="help-block"> </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <%--   name属性的值必须和bean中的属性一一对应  --%>
                            <input type="text" name="email" class="form-control" id="email_update_input"
                                   placeholder="xx@qq.com">
                            <span class="help-block"> </span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" value="m" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" value="w"> 女
                            </label>
                        </div>
                    </div>

                    <%--   部门选项  --%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="dId">
                            </select>
                        </div>
                    </div>
                </form>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
                </div>

            </div>
        </div>
    </div>
</div>


<%-- 新增员工信息，模态框   --%>
<!-- Modal -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">
                <%--   弹窗的表单    --%>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text" name="empName" class="form-control" id="empName_add_input"
                                   placeholder="empName">
                            <%--   错误提示框，文本内容在验证的部分进行设置值   --%>
                            <span class="help-block"> </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <%--   name属性的值必须和bean中的属性一一对应  --%>
                            <input type="text" name="email" class="form-control" id="email_add_input"
                                   placeholder="xx@qq.com">
                            <span class="help-block"> </span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_add_input" value="m" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_add_input" value="w"> 女
                            </label>
                        </div>
                    </div>

                    <%--   部门选项  --%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="dId">
                            </select>
                        </div>
                    </div>
                </form>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
                </div>

            </div>
        </div>
    </div>
</div>


<%--搭建显示页面，共有4行--%>
<div class="container">
    <%-- 标题  --%>
    <div class="row">
        <div class="col-md-12">
            <h2>SSM-CRUD</h2>
        </div>
    </div>
    <%--  按钮  --%>
    <div class="row">
        <div class="col-md-4 col-md-offset-9">
            <button type="button" class="btn btn-primary">
                <span class="glyphicon glyphicon-plus" aria-hidden="true" id="emp_add_modal_btn"></span>添加
            </button>
            <button type="button" class="btn btn-danger">
                <span class="glyphicon glyphicon-trash" aria-hidden="true" id="emp_delete_all_btn"></span>删除
            </button>
        </div>
    </div>
    <%--  显示表格数据信息  --%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
                    <td>
                        <input type="checkbox" id="check_all">
                    </td>
                    <td>#</td>
                    <td>Name</td>
                    <td>Gender</td>
                    <td>Email</td>
                    <td>Department</td>
                    <td>操作</td>
                </tr>
                </thead>

                <%--  显示详细的员工信息  --%>
                <tbody></tbody>
            </table>
        </div>
    </div>
    <%-- 显示分页信息,两列，各占据一半 --%>
    <div class="row">
        <%--  分页文字信息：build_page_info(),  --%>
        <div class="col-md-6" id="page_info_area">
        </div>

        <%-- 分页条信息， build_page_nav(result) --%>
        <div class="col-md-6" id="page_nav_area">

        </div>
    </div>
</div>

<script type="text/javascript">

    // 保存总的员工记录数
    var totalRecord, currentNum;

    // 1.页面加载完成之后，直接发送ajax请求，得到分页数据信息
    $(function () {
        to_page(1);
    });

    // 直接跳转到指定的页码
    function to_page(pn) {
        $.ajax({
            url: "${APP_PATH}/emps", // 请求的地址信息
            data: "pn=" + pn, // 请求携带的数据,跳转到的页面
            type: "GET", // 请求的方式
            // 请求成功的回调函数
            success: function (result) {
                // 1. 解析并显示员工的数据信息
                build_emp_table(result);
                // 2. 解析并显示分页数据信息
                build_page_info(result);
                // 3. 显示导航信息栏
                build_page_nav(result);
            }
        });
    }

    // 显示员工信息
    function build_emp_table(result) {
        // 每次查询都进行清空,即清空元素
        $("#emps_table tbody").empty();

        // 获取json中的所有员工数据信息
        var emps = result.extend.pageInfo.list;
        // 进行遍历
        $.each(emps, function (index, item) {
            var checkBoxId = $("<td><input type='checkbox' class='check_item'></td>")
            var empIdId = $("<td></td>").append(item.empId);
            var empNameId = $("<td></td>").append(item.empName);
            var genderId = $("<td></td>").append(item.gender == "m" ? "男" : "女");
            var emailId = $("<td></td>").append(item.email);
            var deptNameId = $("<td></td>").append(item.department.deptName);

            // 编辑，删除按钮绑定单击事件
            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append($("<span></span>")
                .addClass("glyphicon glyphicon-pencil")).append("编辑");
            // 给编辑的当前对象按钮添加一个自定义的属性，来表示当前员工的id信息
            editBtn.attr("edit-id", item.empId);

            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append($("<span></span>")
                .addClass("glyphicon glyphicon-trash")).append("删除");
            delBtn.attr("del-id", item.empId);
            var btn = $("<td></td>").append(editBtn).append(" ").append(delBtn);

            // append方法执行完成以后还是返回原来的数据信息
            // 表示把内容添加到emp_table里面的 <tbody> 中
            $("<tr></tr>").append(checkBoxId)
                .append(empIdId)
                .append(empNameId)
                .append(genderId)
                .append(emailId)
                .append(deptNameId)
                .append(btn)
                .appendTo("#emps_table tbody");
        })
    }

    // 显示分页数据信息
    function build_page_info(result) {
        // 每次查询都进行清空,即清空元素
        $("#page_info_area").empty();

        var data = result.extend.pageInfo;
        $("#page_info_area").append("第" + data.pageNum + "页，" + "共" + data.pages
            + "页，" + "总共" + data.total + "条记录!");
        // 保存总的记录数
        totalRecord = data.total;
        currentNum = data.pageNum;
    }

    // 添加分页导航，
    function build_page_nav(result) {
        // 每次查询都进行清空,即清空元素
        $("#page_nav_area").empty();

        var nav = $("<nav></nav>").addClass("Page navigation");
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href", "#"));

        // 判断当前页是否有前一页，从而进行开启上一页和首页的功能
        // 如果没有
        if (result.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            // 配置首页，上一页的单击事件
            firstPageLi.click(function () {
                to_page(1);
            });
            // 上一页
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
            });
        }
        ul.append(firstPageLi).append(prePageLi);

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href", "#"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
        if (result.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            // 配置末页，下一页的单击事件
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum + 1);
            });
            // 末页
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
        }


        // 遍历当前的所有页码
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var linum = $("<li></li>").append($("<a></a>").append(item).attr("href", "#"));
            if (result.extend.pageInfo.pageNum == item) {
                linum.addClass("active");
            }
            // 给当前的页面添加单击事件,跳转到点击的页码，每次跳转之前清空上一次的信息
            linum.click(function () {
                to_page(item);
            });
            ul.append(linum);
        });

        ul.append(nextPageLi).append(lastPageLi);
        // 将所有的分页导航信息添加到nav里面并插入到 #page_nav_area 这里面
        nav.append(ul).appendTo("#page_nav_area");
    }


    // 重置整个表单信息
    function reset_form(ele) {
        // 重置表单的数据信息
        $(ele)[0].reset();
        // 重置模态框中的表单样式
        $(ele).find("*").removeClass("has-success has-error");
        $(ele).find(".help-block").text("");
    }

    // 给添加的按钮添加事件
    // 点击新增按钮弹出模态框
    $("#emp_add_modal_btn").click(function () {
        // 每次弹出模态框都将其进行清除里面的表单数据,jQuery没有reset方法，只有dom对象才有,所以先取出dom对象
        // $("#empAddModal form")[0].reset();
        // 重置整个模态框的表单数据，样式等
        reset_form("#empAddModal form");

        // 发送ajax请求，查出部门信息，显示在下拉列表中
        getDepts("#empAddModal select");

        // 弹出模态框
        $("#empAddModal").modal({
            backdrop: "static"
        });
    });

    // 查出所有的部门信息并显示在下拉列表中
    function getDepts(ele) {
        // 每次弹出模态框都需要清除下拉列表的内容
        $(ele).empty();

        $.ajax({
            url: "${APP_PATH}/depts",
            type: "GET",
            success: function (result) {
                // console.log(result);
                $.each(result.extend.depts, function () {
                    var option = $("<option></option>").append(this.deptName).attr("value", this.deptId);
                    // 将查出来的部门信息添加到指定的标签中
                    option.appendTo(ele);
                });
            }
        });
    }

    // 校验表单的数据信息
    function validate_add_form() {
        // 拿到要校验的数据信息，使用正则表达式
        // 校验用户名
        var empName = $("#empName_add_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if (!regName.test(empName)) {
            // alert("用户名可以是2-5位的中文或者6-16位的数字字符");
            // 在input框的父类标签中添加错误信息
            // 检验失败，在其后一个span标签中添加提示信息
            show_validate_msg("#empName_add_input", "error", "用户名可以是2-5位的中文或者6-16位的数字字符!");
            return false;
        } else {
            show_validate_msg("#empName_add_input", "success", "");
        }

        // 2. 校验邮箱
        var email = $("#email_add_input").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (!regEmail.test(email)) {
            // alert("邮箱不符合格式!")，同理
            show_validate_msg("#email_add_input", "error", "邮箱格式不合法!");
            return false;
        } else {
            show_validate_msg("#email_add_input", "success", "")
        }

        return true;
    }


    // 校验用户名和邮箱的函数
    function show_validate_msg(ele, status, msg) {
        // 移除当前元素的校验状态
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if ("success" == status) {
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        } else if ("error" == status) {
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }
    }


    // 当文本输入框的内容发生改变时，发送ajax请求进行验证数据信息
    $("#empName_add_input").change(function () {
        // 获取当前#empName_add_input的输入框内容
        var empName = this.value;
        // 发送ajax请求判断当前用户名是否可用
        $.ajax({
            url: "${APP_PATH}/checkuser",
            data: "empName=" + empName,
            type: "POST",
            success: function (result) { // 检验返回的结果
                if (result.code == 100) {
                    show_validate_msg("#empName_add_input", "success", "用户名可用");
                    // 给保存按钮添加一个属性
                    $("#emp_save_btn").attr("ajax-va", "success");
                } else if (result.code == 200) {
                    show_validate_msg("#empName_add_input", "error", result.extend.va_msg);
                    $("#emp_save_btn").attr("ajax-va", "error");
                }
            }
        })
    });


    //给保存按钮添加单击事件，从而保存员工信息
    $("#emp_save_btn").click(function () {
        // 1.将模态框中填写的数据信息提交给服务器进行保存
        if (!validate_add_form()) {
            return false;
        }

        // 根据用户名是否可用从而设置保存按钮是否可用
        // this代表当前页面对象中的属性
        if ($(this).attr("ajax-va") == "error") {
            return false;
        }

        // 2.发送ajax请求保存员工
        $.ajax({
            url: "${APP_PATH}/emp",
            type: "POST",
            // data 表示提交的具体数据信息(模态框中的表单数据)，直接使用json保存序列化信息
            data: $("#empAddModal form").serialize(),
            success: function (result) {
                // 进行后端校验判断
                // 校验成功
                if (result.code == 100) {
                    alert(result.msg);
                    // 1.关闭模态框
                    $("#empAddModal").modal('hide');
                    // 2. 来到最后一个，显示刚才添加的员工信息
                    // 发送ajax请求显示最后一行数据信息
                    // 因为totalRecord大于总页数，就会显示最后一页
                    to_page(totalRecord);
                } else {
                    // 校验失败，显示错误信息（有那个字段的就返回哪个字段）
                    // undefined表示验证通过，反之不通过
                    if (undefined != result.extend.errorField.email) {
                        // 显示邮箱错误信息
                        show_validate_msg("#email_add_input", "error", result.extend.errorField.email);
                    }
                    if (undefined != result.extend.errorField.empName) {
                        // 显示用户名错误信息
                        show_validate_msg("#empName_add_input", "error", result.extend.errorField.empName);
                    }
                }
            }
        });
    });

    // 给编辑按钮绑定单击事件click，但是绑定不上（因为数据是页面架子啊完成之后
    // 从json中获取的，而按钮的单击事件在加载的时候就绑定了）
    // 绑定的方式：
    //    1、可以再创建按钮的时候进行绑定
    //    2. jQuery的新版本中没有live，使用on进行代替
    //    在页面中给 class = "edit_btn"的按钮添加单击click事件
    $(document).on("click", ".edit_btn", function () {
        // alert("edit");
        // 2. 查出部门信息，并显示部门列表
        getDepts("#empUpdateModal select");
        // 1. 查出员工信息,this代表当前被点击的对象(即被点击的按钮，从而获取到当前的员工id)
        getEmp($(this).attr("edit-id"));
        // 将员工的id设置在更新按钮的属性上，从而进行将id进行传递到模态框中
        // 把员工的id传递给模态框的更新按钮
        $("#emp_update_btn").attr("edit-id", $(this).attr("edit-id"));

        // 0. 弹出模态框
        $("#empUpdateModal").modal({
            backdrop: "static"
        });
    });

    // 使用ajax方式查询员工信息并进行返回
    function getEmp(id) {
        $.ajax({
            url: "${APP_PATH}/emp/" + id,
            type: "GET",
            success: function (result) {
                // 获取当前的员工信息
                var empData = result.extend.emp;
                // 给当前栏设置文本内容
                $("#empName_update_static").text(empData.empName);
                // 给email栏进行赋值
                $("#email_update_input").val(empData.email);
                // 给单选框进行赋值
                $("#empUpdateModal input[name=gender]").val([empData.gender]);
                // 下拉列表框
                $("#empUpdateModal select").val([empData.dId]);
            }
        });
    }


    // 点击更新按钮，更新员工信息
    $("#emp_update_btn").click(function () {
        // 1. 校验邮箱
        var email = $("#email_update_input").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (!regEmail.test(email)) {
            // alert("邮箱不符合格式!")，同理
            show_validate_msg("#email_update_input", "error", "邮箱格式不合法!");
            return false;
        } else {
            show_validate_msg("#email_update_input", "success", "")
        }

        // 2. 发送ajax请求保存更新的员工信息(先在模态框中获取到员工的id)
        // 间接的方式使用POST进行包装
        $.ajax({
            url: "${APP_PATH}/emp/" + $(this).attr("edit-id"),

            // 方法1：
            // 不能直接发put请求的方式，因为Tomcat接收到PUT请求不会讲数据进行
            // type:"POST",
            // 封装，只有POST请求的数据才会被封装成为请求体
            // 发送的数据,并设置请求方法、、
            // data:$("#empUpdateModal form").serialize() + "&_method=PUT",

            // 方法2：
            // 直接发送PUT请求，需要使用SpringMVC的方式
            type: "PUT",
            data: $("#empUpdateModal form").serialize(),
            success: function (result) {
                // alert(result.msg);
                if (confirm(result.msg)) {
                    // 1.关闭编辑模态框
                    $("#empUpdateModal").modal('hide');
                }
                // 2. 跳到当前修改信息的页面
                to_page(currentNum);
            }
        })
    });

    // 删除指定的员工信息
    $(document).on("click", ".delete_btn", function () {
        // 弹出对话框是否删除该员工信息
        // $(this) 代表当前被点击的删除按钮
        var empName = $(this).parents("tr").find("td:eq(2)").text();
        var empId = $(this).attr("del-id");
        if (confirm("确认删除 【" + empName + "】吗？")) {
            $.ajax({
                // 确认就发送请求删除该员工信息
                url: "${APP_PATH}/emp/" + empId,
                type: "DELETE",
                success: function (result) {
                    alert(result.msg);
                    // 回到删除页面
                    to_page(currentNum);
                }
            })
        }
    });

    // 实现全选/全不选的功能
    // 给按钮绑定单击事件
    $("#check_all").click(function () {
        // attr 获取没设置的属性checked得到undefined
        // 我们这些dom原生的属性，attr能够获取自定义属性的值
        // prob可以修改和获取dom原生属性的值,即可以获取到当前多选框是否被单击
        // alert($(this).prop("checked"));
        $(".check_item").prop("checked", $(this).prop("checked"));
    });

    // check_item
    $(document).on("click", ".check_item", function () {
        // 判断当前的选择框是否已经被全选
        var flag = $(".check_item:checked").length == $(".check_item").length;
        $("#check_all").prop("checked", flag);
    });


    // 实现批量删除的方式
    $("#emp_delete_all_btn").click(function () {
        var empName = "";
        var del_str = "";
        // 循环遍历被选中的按钮
        $.each($(".check_item:checked"), function () {
            // 获取被选中的员工姓名(this表示当前被选中的信息),以及相应的id号
            empName += $(this).parents("tr").find("td:eq(2)").text() + ",";
            del_str += $(this).parents("tr").find("td:eq(1)").text() + "-"
        });

        // 去除empName, del_str中多余的最后一个逗号符
        empName.substring(0, empName.length - 1);
        del_str.substring(0, del_str.length - 1);
        if (confirm("确认删除【" + empName + "】吗？")) {
            // 发送ajax请求实现删除的操作
            $.ajax({
                url: "${APP_PATH}/emp/" + del_str,
                type: "DELETE",
                success: function (result) {
                    alert(result.msg);
                    // 回到当前页面
                    to_page(currentNum);
                }
            });
        }
    });


</script>
</body>
</html>
