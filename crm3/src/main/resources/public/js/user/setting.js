layui.use(['form','jquery','jquery_cookie'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        $ = layui.jquery_cookie($);

    /**
     * 表单submit提交(表示响应当前的点击操作)
     *  form.on('submit(按钮的lay-filter属性值)', function(data){
     *
     *       return false; //阻止表单跳转。
     *  });
     */
    form.on('submit(saveBtn)', function(data){
        // alert("form");
        // 获取表单的字段信息
        // console.log(data.field);
        // 对表单中的数据进行参数校验(freeMarker已经校验)

        // 发起ajax登录请求
        $.ajax({
            type:"post",
            url: ctx + "/user/updateSetting",
            data:{
                phone: data.field.phone,
                email: data.field.email,
                trueName: data.field.trueName
            },
            // 执行请求成功后返回的数据信息(该信息就是userLogin接口返回的返回值)
            success: function (result) {
                console.log(result);
                // 通过判断当前返回值的状态码进行判断是否登录成功
                if (result.code == 200){
                    // 登录成功
                    layer.msg("用户信息修改!", {icon:6},function () {
                        // 在父窗口内进行跳转至登录首页，否则将会重新开启一个新的窗口进行跳转
                        // 那就是不断的重叠。
                        window.parent.location.href = ctx + "/main";
                    });
                }else {
                    // 弹出异常信息
                    layer.msg(result.msg, {icon:5});
                }
            }
        });
        // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
        // 不禁止将会跳转到 http://localhost:8080/crm?userName=admin&userPwd=123456....这个地址，这个地址不存在
        return false;
    });
});
