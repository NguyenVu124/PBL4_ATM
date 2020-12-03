<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<style>
	ul {
		list-style-type: none;
		padding-top:5px;
	}
	li{
		margin-top:12px;
	}
	a {
		text-decoration:none;
	}
</style>
    
<div>
	<ul>
		<li><a href = "${pageContext.request.contextPath}/">Trang chủ</a><li>
		<li><a href = "${pageContext.request.contextPath}/login">Đăng nhập</a><li>
		<li><a href = "${pageContext.request.contextPath}/signup">Đăng ký</a><li>
		<li><a href = "${pageContext.request.contextPath}/viewInformation">Xem tài khoản cá nhân</a><li>
		<li><a href = "${pageContext.request.contextPath}/updateInformation">Sửa tài khoản cá nhân</a><li>
		<li><a href = "${pageContext.request.contextPath}/deleteAccount">Xoá tài khoản cá nhân</a><li>
		<li><a href = "${pageContext.request.contextPath}/viewBalance">Kiểm tra số dư</a><li>
		<li><a href = "${pageContext.request.contextPath}/viewMonitoring">Kiểm tra giao dịch</a><li>
		<li><a href = "${pageContext.request.contextPath}/depositBalance">Nạp tiền vào tài khoản</a><li>
		<li><a href = "${pageContext.request.contextPath}/withdrawBalance">Rút tiền từ tài khoản</a><li>
		<li><a href = "${pageContext.request.contextPath}/transferBalance">Chuyển tiền sang tài khoản khác</a><li>
		<li><a href = "${pageContext.request.contextPath}/logout">Đăng xuất</a><li>
	</ul>
</div>