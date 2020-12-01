<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Kiểm tra giao dịch</title>
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
				<h1>VIEW MONITORING PAGE</h1>
				<table>
					<tr>
						<td>Time</td>
						<td>&emsp;Description</td>
					</tr>
					<c:forEach items="${list}" var="monitoring">
					<tr>
						<td>${monitoring.time}</td>
						<td style="text-align:right;">&emsp;${monitoring.description}</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>