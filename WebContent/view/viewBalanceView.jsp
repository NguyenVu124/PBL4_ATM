<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Kiểm tra số dư</title>
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
				<h1>VIEW BALANCE PAGE</h1>
				<table>
					<tr>
						<td>Balance:</td>
						<td>${balance.balance}</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>