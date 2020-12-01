<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Trang chủ</title>
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
				<h1>HOME PAGE</h1>
				<h1>GẮN BÓ DỮ LIỆU KHI CẬP NHẬT TẠI ATM</h1>
				<p>
				- ĐĂNG NHẬP (SELECT ACCOUNT) <br>			
				- ĐĂNG XUẤT <br>
				- ĐĂNG KÝ (INSERT ACCOUNT, INSERT INFORMATION) <br>			
				- XEM THÔNG TIN CÁ NHÂN (SELECT INFORMATION) <br>			
				- SỬA THÔNG TIN CÁ NHÂN (UPDATE INFORMATION) <br>
				- XOÁ TÀI KHOẢN (DELETE ACCOUNT) <br>
				- KIỂM TRA SỐ DƯ (SELECT BALANCE) <br>
				- KIỂM TRA GIAO DỊCH (SELECT MONITORING) <br>
				- NẠP TIỀN VÀO TÀI KHOẢN (UPDATE BALANCE, INSERT MONITORING) <br>
				- RÚT TIỀN TỪ TÀI KHOẢN (UPDATE BALANCE, INSERT MONITORING) <br>
				- CHUYỂN TIỀN TỪ TÀI KHOẢN (UPDATE BALANCE 2 ACCOUNT, INSERT MONITORING) <br>
				</p>
			</div>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>