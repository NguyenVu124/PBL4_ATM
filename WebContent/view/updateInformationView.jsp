<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sửa tài khoản cá nhân</title>
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
				<h1> EDIT INFORMATION PAGE</h1>
				<p style="color:red;">${error}</p><br>
				<form action="${pageContext.request.contextPath}/updateInformation" method="POST">
				<table>
					<tr>
						<td>ID:</td>
						<td><input type="text" name="ID" value="${loginedUser.ID}" readonly></td>
					</tr>
					<tr>
						<td>Name:</td>
						<td><input type="text" name="name" value="${infor.name}"></td>
					</tr>
					<tr>
						<td>Phone:</td>
						<td><input type="text" name="phone" value="${infor.phone}"></td>
					</tr>
					<tr>
						<td>Gender:</td>
						<td><input type="text" name="gender" value="${infor.gender}"></td>
					</tr>
					<tr>
						<td>Birth:</td>
						<td><input type="date" name="birth" value="${infor.birth}"></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="text" name="email" value="${infor.email}"></td>
					</tr>
					<tr>
						<td>Identity Number:</td>
						<td><input type="text" name="identitynumber" value="${infor.identitynumber}"></td>
					</tr>
					<tr>
						<td><input type="submit"></td>
					</tr>
				</table>
				</form>
			</div>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>