<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>

    <title>index</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">

        // 加载页面信息
        $(function () {
            // 绑定按钮事件
            $("#addProvince").click(function () {
                $.ajax({
                    url:"queryProvince",
                    dataType:"json",
                    success:function (result) {
                        // 清空子标签
                        $("#province").empty();
                        $("#province").append("<option value='0'>请选择...</option>");
                        $.each(result, function (i, n) {
                            // alert(n.name);
                            $("#province").append("<option value='"+n.id+"'>" + n.name + "</option>");
                        });
                    }
                })
            })

            // 根据选择的省份进行更新该省份的城市
            $("#province").on("change", function () {
                var proId = $("#province>option:selected").val();
                if (proId == "0"){
                    alert("请选择一个有效的省份!");
                }else {
                    $.ajax({
                        url:"queryCity",
                        data:{
                            proId:proId
                        },
                        dataType: "json",
                        success:function (result) {
                            $("#city").empty();
                            $("#city").append("<option value='0'>请选择...</option>");
                            $.each(result, function (i, n) {
                                // alert(n.name);
                                $("#city").append("<option value='"+n.id+"'>" + n.name + "</option>");
                            });
                        }
                    })
                }
            })
        })
    </script>
  </head>
  <body>

    <p align="center">Ajax-jQuery实现省市级联的方式</p>
    <table align="center">
        <tr>
          <td>省份:</td>
          <td>
            <select id="province">
                <option value="0">请选择...</option>
            </select>
          </td>
          <td><button id="addProvince">获取省名</button></td>
        </tr>
        <br>
        <br>
        <tr>
            <td>城市:</td>
            <td>
                <select id="city">
                    <option value="0">请选择...</option>
                </select>
            </td>
        </tr>
    </table>
  </body>
</html>
