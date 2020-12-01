<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Đăng nhập</title>
	<style>
		body {
			margin: 0;
		}
		.container {
			display:flex;
		}
		.nav {
			width:20%;
		}
	</style>
</head>
<body>
	<div>
		<div class="header"><jsp:include page="_header.jsp"></jsp:include></div>
		<div class="container">
			<div class="nav"><jsp:include page="_nav.jsp"></jsp:include></div>
			<div class="content">
				<h1>LOG IN PAGE</h1>
				<p style="color:red;">${error}</p><br>
				<form action="${pageContext.request.contextPath}/login" method="POST">
				<table>
				<tr>
					<td><label>Username: </label></td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td><label>Password: </label></td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit">
				</tr>
			</table>	
			</form>
			</div>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>