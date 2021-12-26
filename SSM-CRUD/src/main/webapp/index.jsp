<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--要使用c:foreach的方法--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
    <title>crud</title>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.js"></script>
    <%--    引入css样式--%>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 加载 Bootstrap 的所有 js 插件-->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <%--
        web找资源出现的问题;
            1。不以 / 斜杠开头的找资源，都是以当前资源的路径为基准，经常容易出现问题
            2. 以 / 斜杠开头的找资源，是以服务器的路径为基准(http://localhost:3306)，
                需要加上项目名: http://localhost:3306/crud,
                request.getContextPath()可以获取到项目路径，以斜线开始，不以斜线结尾
    --%>

</head>
<body>
    <div class="container">
        <%--  标题栏 --%>
        <div class="row">
            <div class="col-md-12">
                <h3>Welcome! SSM_CRUD</h3>
            </div>
        </div>

        <%--全局按钮操作栏--%>
        <div class="row">
            <div class="col-md-4 col-md-offset-8">
                <button type="button" class="btn btn-primary" id="emp_add_modal_btn">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    添加
                </button>
                <button type="button" class="btn btn-danger" id="emp_del_modal_btn">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    删除
                </button>
            </div>
        </div>

        <%-- 内容显示  --%>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover" id="emps_table">
                    <thead>
                        <tr>
                            <th>
                                <input type="checkbox" id="check_all">
                            </th>
                            <th>#</th>
                            <th>Name</th>
                            <th>Gender</th>
                            <th>Email</th>
                            <th>Department</th>
                            <th>操作</th>
                        </tr>
                    </thead>

                    <tbody>
                        <%-- 显示员工信息   --%>
                    </tbody>

                </table>
            </div>
        </div>

        <%-- 分页栏 --%>
        <div class="row">
            <%--  分页文字信息 --%>
            <div class="col-md-6" id="page_info_area">
            </div>

            <%-- 显示导航条信息栏--%>
            <div class="col-md-6" id="page_info_nav">
            </div>

        </div>
    </div>

    <!-- 编辑员工的模态框Modal -->
    <div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header" align="center">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">员工编辑</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">empName</label>
                            <div class="col-sm-10">
                                    <p class="form-control-static" id="edit-empName-input"></p>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-10">
                                <input type="email" name="email" id="email_update_input" class="form-control"
                                       placeholder="Email">
                                <%--   错误提示框，文本内容在验证的部分进行设置值   --%>
                                <span class="help-block"> </span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">gender</label>
                            <div class="col-sm-10">
                                <label class="radio-inline">
                                    <input type="radio" name="gender" value="m" checked="checked"> 男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="gender" value="w"> 女
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">deptName</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="dId">
                                    <%-- <option>1</option> --%>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="save_emp_btn">Update</button>
                </div>
            </div>
        </div>
    </div>



    <!-- 新增员工的模态框Modal -->
    <div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header" align="center">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">员工新增</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">

                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">empName</label>
                            <div class="col-sm-10">
                                <input type="empName" name="empName" id="empName_add_input" class="form-control"
                                       placeholder="empName">
                                <%--   错误提示框，文本内容在验证的部分进行设置值   --%>
                                <span class="help-block"> </span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-10">
                                <input type="email" name="email" id="email_add_input" class="form-control"
                                       placeholder="Email">
                                <%--   错误提示框，文本内容在验证的部分进行设置值   --%>
                                <span class="help-block"> </span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">gender</label>
                            <div class="col-sm-10">
                                <label class="radio-inline">
                                    <input type="radio" name="gender" value="m" checked="checked"> 男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="gender" value="w"> 女
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">deptName</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="dId">
                                    <%-- <option>1</option> --%>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="save_emp_btn">Save</button>
                </div>
            </div>
        </div>
    </div>



    <%--  处理ajax的请求  --%>
    <script type="text/javascript">

        // 定义一个全局的变量保存当前的记录总数
        var totalRecoder;
        // 记录当前页
        var currentPage;

        // 页面加载完成之后，直接去发送ajax请求，获取分页数据信息
        // 1.页面加载完成之后，直接发送ajax请求，得到分页数据信息
        $(function () {
            toPage(1);
        });

        // 直接跳转到指定的页码
        function toPage(pn) {
            $.ajax({
                url: "${APP_PATH}/emps", // 请求的地址信息
                data: "pn=" + pn, // 请求携带的数据,跳转到的页面
                type: "GET", // 请求的方式
                // 请求成功的回调函数
                success: function (result) {
                    // 1. 解析并显示员工的数据信息
                    build_emps_table(result);
                    // 2. 解析并显示分页数据信息
                    build_page_info(result);
                    // 3. 显示导航信息栏
                    build_page_nav(result)
                }
            });
        }
        
        // 解析员工信息
        function build_emps_table(result) {
            // 每次加载的时候都清空表格数据信息
            $("#emps_table tbody").empty();
            // 获取所有的员工数据信息
            var emps = result.extend.pageInfo.list;
            // 遍历每一个员工信息
            $.each(emps, function (index, item) {
                var checkTd = $("<td><input type='checkbox' class='check_item'></td>")
                var empIdTd = $("<td></td>").append(item.empId);
                var empNameTd = $("<td></td>").append(item.empName);
                var genderTd = $("<td></td>").append(item.gender == "m" ? "男":"女");
                var emailTd = $("<td></td>").append(item.email);
                var deptNameTd = $("<td></td>").append(item.department.deptName);

                // <button type="button" class="btn btn-primary btn-sm">
                //     <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                // 编辑
                // </button>
                var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
                // 给编辑按钮添加一个属性，用于记录当前员工的id信息
                editBtn.attr("edit-btn", item.empId);

                // <button type="button" class="btn btn-danger btn-sm">
                //     <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                // 删除
                // </button>
                var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm del_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
                var btnId = $("<td></td>").append(editBtn).append(" ").append(delBtn);
                delBtn.attr("del-btn", item.empId);

                $("<tr></tr>").append(checkTd).append(empIdTd).append(empNameTd).append(genderTd)
                    .append(emailTd).append(deptNameTd).append(btnId)
                    .appendTo("#emps_table tbody");
            })
        }

        // 显示分页数据
        function build_page_info(result) {
            // 每次都清空分页栏数据信息
            $("#page_info_area").empty();
            var data = result.extend.pageInfo;
            $("#page_info_area").append("<b>第" + data.pageNum + "页，" + "共" + data.pages
                    + "页，" + "总共" + data.total + "条记录!</b>");
            totalRecoder = data.total;
        }

        // 显示导航条数据信息
        function build_page_nav(result) {
            // 清空导航条信息
            $("#page_info_nav").empty();
            var data = result.extend.pageInfo;
            var nav = $("<nav></nav>").addClass("Page navigation");
            var ul = $("<ul></ul>").addClass("pagination");
            // 首页
            var firstPageLi = $("<li></li>").append($("<a></a>").attr("href","#").append("首页"));
            //上一页
            var prePageLi = $("<li></li>").append($("<a></a>").attr("href","#").attr("aria-label","Previous")
                .append($("<span></span>").attr("aria-hidden","true").append("&laquo;")));

            // 添加单击事件
            if (data.hasPreviousPage == false){
                // 如果没有前一页，就不显示
                firstPageLi.addClass("disabled");
                prePageLi.addClass("disabled");
            }else {
                // 给首页和上一页添加单击事件
                // 跳转到首页
                firstPageLi.click(function () {
                    toPage(1);
                })
                // 跳转到前一页
                prePageLi.click(function () {
                    toPage(data.pageNum - 1);
                })
            }

            ul.append(firstPageLi).append(prePageLi);

            // 遍历分页导航数据
            $.each(data.navigatepageNums, function (i, num) {
                var curLi = $("<li></li>").append($("<a></a>").attr("href","#").append(num));
                // 给当前的页面添加高亮
                if (num == data.pageNum){
                    curLi.addClass("active");
                    currentPage = data.pageNum;
                }
                curLi.click(function () {
                    toPage(num);
                })
                ul.append(curLi);
            })

            //下一页
            var nextPageLi = $("<li></li>").append($("<a></a>").attr("href","#").attr("aria-label","Next")
                .append($("<span></span>").attr("aria-hidden","true").append("&raquo;")));
            // 末页
            var lastPageLi = $("<li></li>").append($("<a></a>").attr("href","#").append("末页"));

            // 添加单击事件
            if (data.hasNextPage == false){
                // 如果没有前一页，就不显示
                nextPageLi.addClass("disabled");
                lastPageLi.addClass("disabled");
            }else {
                // 给末页和下一页添加单击事件
                // 跳转到首页
                lastPageLi.click(function () {
                    toPage(data.total);
                })
                // 跳转到下一页
                nextPageLi.click(function () {
                    toPage(data.pageNum + 1);
                })
            }
            ul.append(nextPageLi).append(lastPageLi);
            // 显示数据信息
            $("#page_info_nav").append(nav.append(ul));
        }

        // 清空表单的数据和格式的信息
        // 重置整个表单信息
        function reset_form(ele) {
            // 重置表单的数据信息
            $(ele)[0].reset();
            // 重置模态框中的表单样式
            $(ele).find("*").removeClass("has-success has-error");
            $(ele).find(".help-block").text("");
        }


        // 新增模态框的按钮单击
        $("#emp_add_modal_btn").click(function () {
            // 每次弹出模态框的时候，完全清除表单数据和格式的信息,dom对象才有reset方法
            reset_form("#empAddModal form");
            // 每次新增的弹出模态框的时候，都要显示员工部门的信息
            $(".form-control").text("");
            getDepts("#empAddModal select");
            // 弹出模态框
            $("#empAddModal").modal({
                backdrop: "static"
            });
        })


        // 获取部门信息
        function getDepts(ele) {
            // 清空当前模态框中的内容
            $(ele).empty();
            $.ajax({
                url: "${APP_PATH}/depts",
                type: "get",
                success:function (result) {
                    // 查询所有的部门信息
                    // console.log(result);
                    var data = result.extend.depts;
                    $.each(data, function (i, item) {
                        // 将部门信息更新到模态框中
                        $("<option></option>").append(item.deptName).attr("value",item.deptId)
                            .appendTo(ele);
                    })
                }
            })
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

        // 当用户名输入框发生变化的时候，直接发送ajax请求进行验证当前的用户名是否可用
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
                        $("#save_emp_btn").attr("ajax-va", "success");
                    } else if (result.code == 200) {
                        show_validate_msg("#empName_add_input", "error", result.extend.va_msg);
                        $("#save_emp_btn").attr("ajax-va", "error");
                    }
                }
            })
        });

        // 保存员工数据信息
        $("#save_emp_btn").click(function () {
            // 1. 保存员工之前，进行数据的校验
            if (!validate_add_form()){
                return false;
            }

            // 2. 根据用户名是否可用进行操作
            // 输入用户名的时候，直接发送ajax请求进行校验
            if ( $("#save_emp_btn").attr("ajax-va") == "error"){
                return false;
            }

            // 3. 验证通过，执行员工插入的方法
            $.ajax({
                url:"${APP_PATH}/emps",
                type:"post",
                // 获取当前表单中的所有数据，并将其进行序列化
                data: $("#empAddModal form").serialize(),
                success:function (result) {
                    if (result.code == 100){
                        // 显示执行操作的消息
                        // alert(result.msg);
                        // 关闭模态框
                        $('#empAddModal').modal('hide');
                        // 跳转到最后一页
                        toPage(totalRecoder);
                    }else {
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
            })
        });

        // 给编辑按钮添加单击事件
        // 我们是按钮创建执勤就绑定了click。所以使用click绑定不上
            // 1）可以在创建按钮的时候进行绑定  2）绑定单击.live()
            // 但是新版的jQuery没有live，使用on进行代替
        $(document).on("click",".edit_btn",function () {
            //清空模态框表单的数据信息
            reset_form("#empUpdateModal form");
            // 直接查询部门的信息
            getDepts("#empUpdateModal select");

            // 根据员工id获取员工的详细信息
            getEmployee($(this).attr("edit-btn"));
            // 把员工的id赋值给模态框的update更新按钮
            $("#save_emp_btn").attr("edit-btn-id", $(this).attr("edit-btn"));
            // alert("编辑按钮被点击了");
            // 弹出模态框
            $("#empUpdateModal").modal({
                backdrop: "static"
            });
        })

        // 根据员工的id获取员工的所有详细信息
        function getEmployee(id) {
            $.ajax({
                url:"${APP_PATH}/emp/"+id,
                type:"GET",
                success:function (result) {
                    // alert(result.extend.emp);
                    var employee = result.extend.emp;
                    // alert(employee.empName);
                    $("#edit-empName-input").text(employee.empName);
                    $("#email_update_input").val(employee.email);  // 给input的表单赋值
                    $("#empUpdateModal input[name=gender]").val([employee.gender]);
                    $("#empUpdateModal select[name=dId]").val([employee.dId]);
                }
            })
        }

        // 给更新按钮添加单击事件，点击update更新按钮，保存修改的员工信息
        $("#save_emp_btn").click(function () {
            // 1。判断当前的邮箱格式是否正确
            // 校验邮箱
            var email = $("#email_update_input").val();
            var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if (!regEmail.test(email)) {
                // alert("邮箱不符合格式!")，同理
                show_validate_msg("#email_update_input", "error", "邮箱格式不合法!");
                return false;
            } else {
                show_validate_msg("#email_update_input", "success", "")
            }

            // 2.发送ajax请求保存更新员工信息
            $.ajax({
                url:"${APP_PATH}/emp/" + $(this).attr("edit-btn-id"),
                // 方式1： 使用当前的post方式加上 "&_method=PUT" 将其转为普通请求
                // type:"POST",
                // data:$("#empUpdateModal form").serialize() + "&_method=PUT",

                // 方式2： 直接发送put请求，需要在web.xml中进行配置
                // 我们想要能够支持直接发送PUT请求之类的请求，还要封装请求体中的数据
                // 1. 在web.xml中配置上： HttpPutFormContentFilter
                // 2. 它的作用：将请求中的数据解析包装成为一个map
                // 3. request被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
                type:"PUT",
                data:$("#empUpdateModal form").serialize(),
                success:function (result) {
                    alert(result.msg);
                    // 关闭修改模态框
                    $('#empUpdateModal').modal('hide');
                    // 跳转被修改的信息的那一页
                    toPage(currentPage);
                }
            })
        })


        // 给删除按钮添加单击事件
        $(document).on("click", ".del_btn", function () {
            // 弹出对话框是否删除该员工信息
            // $(this) 代表当前被点击的删除按钮
            var empName = $(this).parents("tr").find("td:eq(2)").text();
            var empId = $(this).attr("del-btn");
            if (confirm("确认删除 【" + empName + "】吗？")) {
                $.ajax({
                    // 确认就发送请求删除该员工信息
                    url: "${APP_PATH}/emp/" + empId,
                    type: "DELETE",
                    success: function (result) {
                        alert(result.msg);
                        // 回到删除页面
                        toPage(currentPage);
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


        // 给全局删除绑定单击事件
        $("#emp_del_modal_btn").click(function () {
            // 遍历每一个被选择的id
            var names = "";
            var ids = "";
            $.each($(".check_item:checked"),function () {
                names += $(this).parents("tr").find("td:eq(2)").text() + ",";
                ids += $(this).parents("tr").find("td:eq(1)").text() + "-";
            })
            // 去除name中多余的 逗号 ，
            names = names.substring(0, names.length - 1);
            ids = ids.substring(0, ids.length - 1);
            if (confirm("你确定要删除【" + names + "】吗？")){
                // alert("hahhaha");
                $.ajax({
                    url:"${APP_PATH}/emp/" + ids,
                    type:"delete",
                    success:function (result) {
                        alert(result.msg);
                        // 跳转到执行删除的页面
                        toPage(currentPage);
                    }
                })
            }
        })

    </script>
</body>
</html>
