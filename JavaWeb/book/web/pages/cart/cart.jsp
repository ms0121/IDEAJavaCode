<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--  使用静态包含，包含base标签，css样式，JQuery文件， 将公共的部分进行抽取出来 --%>
	<%@include file="/pages/common/head.jsp"%>

	<script type="text/javascript">

		$(function () {
			// 给删除按钮绑定单击事件
			$("a.deleteItem").click(function () {
				return confirm("你确定要删除 [" + $(this).parent().parent().find("td:first").text() + "] 吗?");
			});

			//  清空购物车的提示按钮
			$("#clearCart").click(function () {
				return confirm("你确定要删除吗?");
			});

			// 更新商品的数量
			$(".updateCount").change(function () {
				// 获取商品的名称
				var name = $(this).parent().parent().find("td:first").text();
				var id = $(this).attr("bookId");
				// 获取商品的数量,表明直接获取输入框的值
				var count = this.value;
				if (confirm("你确定要将 [" + name + "]的商品数量修改为: " + count)){
					// 发起请求进行修改，直接跳转调用updateCount方法进行修改数量值
					location.href = "cartServlet?action=updateCount&count="+count+"&id="+id;
				} else {
					// defaultValue 属性是表单项 Dom 对象的属性。它表示默认的 value 属性值
					this.value = this.defaultValue;
				}
			});

		});

	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>

			<%--静态包含登录成功之后的显示部分，（共有。将其进行抽取出来处理）--%>
			<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">

<%--		${sessionScope}--%>

		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">亲，你还没有添加任何商品，请快去购物吧</a></td>
				</tr>
			</c:if>

			<c:if test="${not empty sessionScope.cart.items}">
				<%--	entry是map中的一个键值对（id，CartItem）,所以使用entry.getValue取出CartItem对象	--%>
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input type="text" class="updateCount" style="width: 70px"
								   bookId = "${entry.value.id}" value="${entry.value.count}">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>

						<%--	给删除绑定单击事件，目的就是防止误删		--%>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>

		</table>

		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id="clearCart" href="cartServlet?action=clearCart">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>

	</div>

	<%--	静态包含页脚信息 , 都有公共的部分 --%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>