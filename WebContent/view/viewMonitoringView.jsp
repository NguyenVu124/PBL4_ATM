<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Kiểm tra giao dịch</title>

<link rel="stylesheet" href="./view/style/nav.css" />
<link rel="stylesheet" href="./view/style/mornitoring.css" />
</head>
<body>
	<div style="background: #56baed; height: 80px; padding: 1px;width: 100%;">
		<h2 style="text-align: center; justify-content: center; padding: 10px">
			HỆ THỐNG QUẢN LÍ TÀI KHOẢN ATM</h2>
	</div>

	<div>
		<div class="container">
			<div class="nav">
				<ul>
					

					<li><a
						href="${pageContext.request.contextPath}/viewInformation">Xem
							tài khoản cá nhân</a></li>

					<li><a
						href="${pageContext.request.contextPath}/updateInformation">Sửa
							tài khoản cá nhân</a></li>

					<li><a href="${pageContext.request.contextPath}/deleteAccount">Xoá
							tài khoản cá nhân</a></li>

					<li><a href="${pageContext.request.contextPath}/viewBalance">Kiểm
							tra số dư</a></li>

					<li><a
						href="${pageContext.request.contextPath}/viewMonitoring">Kiểm
							tra giao dịch</a></li>

					<li><a
						href="${pageContext.request.contextPath}/depositBalance">Nạp
							tiền vào tài khoản</a></li>

					<li><a
						href="${pageContext.request.contextPath}/withdrawBalance">Rút
							tiền từ tài khoản</a></li>

					<li><a
						href="${pageContext.request.contextPath}/transferBalance">Chuyển
							tiền sang tài khoản khác</a></li>

					<li><a href="${pageContext.request.contextPath}/logout">Đăng
							xuất</a></li>
				</ul>
			</div>
			<div class="content">
				<h3>HISTORY TRANSFER</h3>
				<div class="table-header">
					<div class="header__item">
						<a id="name" class="filter__link" href="#">Name</a>
					</div>
					<div class="header__item">
						<a id="wins" class="filter__link filter__link--number" href="#">Wins</a>
					</div>
				</div>

				<c:forEach items="${list}" var="monitoring">
					<div class="table-row">
						<div class="table-data">${monitoring.time}</div>
						<div class="table-data">&emsp;${monitoring.description}</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
</body>
</html>
