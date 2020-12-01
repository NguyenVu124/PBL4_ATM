<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Xem tài khoản cá nhân</title>
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
				<h1>VIEW INFORMATION PAGE</h1>
				<table>
					<tr>
						<td>ID:</td>
						<td>${infor.ID}</td>
					</tr>
					<tr>
						<td>Name:</td>
						<td>${infor.name}</td>
					</tr>
					<tr>
						<td>Phone:</td>
						<td>${infor.phone}</td>
					</tr>
					<tr>
						<td>Gender:</td>
						<td>${infor.gender}</td>
					</tr>
					<tr>
						<td>Birth:</td>
						<td>${infor.birth}</td>
					</tr>
					<tr>
						<td>Email:</td>
						<td>${infor.email}</td>
					</tr>
					<tr>
						<td>Identity Number:</td>
						<td>${infor.identitynumber}</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>