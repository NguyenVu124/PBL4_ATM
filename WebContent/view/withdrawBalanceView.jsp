<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rút tiền từ tài khoản</title>
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
				<h1>WITHDRAW BALANCE PAGE</h1>
				<p style="color:red;">${error}</p><br>
				<form action="${pageContext.request.contextPath}/withdrawBalance" method="POST">
				<table>
				<tr>
					<td><label>Input: </label></td>
					<td><input type="text" name="input"></td>
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