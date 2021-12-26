<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
	<%--  使用静态包含，包含base标签，css样式，JQuery文件， 将公共的部分进行抽取出来 --%>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>

			<%--	使用静态包含，将公共的部分进行抽取出来		--%>
			<%@include file="/pages/common/manager_menu.jsp"%>

		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="get">
				<%--	根据book_manager页面传过来的method方法来判断当前的操作时 update修改 还是 add添加	--%>
				<%--	当前的操作时: ${empty param.id? "add":"update"},
						修改图书的信息，需要根据图书的id进行修改，所以必须将图书的id传递到 bookServlet 中去才可以成功修改图书的信息
				--%>
				<input type="hidden" name="pageNo" value="${param.pageNo}">
				<input type="hidden" name="action" value="${empty param.id?"add":"update"}" />
				<input type="hidden" name="id" value="${requestScope.book.id}">

				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.book.price}"/></td>
						<td><input name="author" type="text" value="${requestScope.book.author}"/></td>
						<td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
		</div>

		<%--	静态包含页脚信息 , 都有公共的部分 --%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>