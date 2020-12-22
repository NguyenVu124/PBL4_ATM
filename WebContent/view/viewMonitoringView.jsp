<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>TRANSACTION HISTORY</title>
	<link rel="preconnect" href="https://fonts.gstatic.com"> 
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;700&display=swap" rel="stylesheet">
	<style>
		html, body {
			color: #333333;
			font-family: 'Inter', sans-serif;
  			height: 100%;	
  			margin: 0;
  			font-size: 14px;

		}
		.container {
			display:flex;
			padding-top: 30px;
			padding-left: 20px;
		}
		.nav {
			color: #333333;
			width:16%;
			padding: 10px;
		}
		.content {
			width: 60%;
  			width: 600px;
			margin: auto;
			position: absolute;
  			margin-top: 35px;
  			left: 33%;
  			background-color: #white;
  			overflow: auto;
		}
		ul {
			list-style-type: none;
  			margin: 0;
  			padding: 0;
  			width: 80%;
		}
		li a {
			font-size: 14px;
			display: block;
			width: 200px;
			color: #000;
			padding: 12px 22px;
			text-decoration: none;
		}
		a {
			text-decoration:none;
		}
		li a:hover {
			background-color: #0275d8;
			color: white;
			border-radius: 5px;
		}
		h1 {
			text-align: center;
			vertical-align: middle;
			line-height: 100px;
			padding: 10px;
			color:white;
			color:#0275d8;
			font-size: 36px;
		}
		h2 {
			color:  #0275d8;
			text-align: center;
		}
		.header {
			background-color: #fafbfc;
			border-bottom: 1px solid #dddddd;
		}
		table {
			border-spacing: 0;
			width:100%;
			border: 1px solid #e8e8e8;
			border-radius: 5px;
			padding: 10px;
		}
		#table th {
			padding: 10px;
			border: 1px solid #dcebff;
		}
		#table td {
  			padding-bottom: 20px;
  			padding-left: 25px;
  			padding-right: 25px;
		}
		table tr:last-child td:first-child {
    		border-bottom-left-radius: 5px;
		}
		table tr:first-child {
    		border-bottom-right-radius: 5px;
			border: 1px solid #cce1fc;
			background-color: #f2f8fe;
			padding: 15px;
		}
		.login {
			float:right;
			text-align:right;
			color:#333333x;
			vertical-align: middle;
			line-height: 10px;
			padding-right:10px;
		}
	</style>
</head>
<body>
	<div>
		<div class="header">
			<div class="login">
				<p>Welcome, ${loginedUser.username}</p>
			</div>
			<div style="height: 150px; padding: 5px;">
				<h1>ATM MANAGEMENT SYSTEM</h1>
			</div>
		</div>
		<div class="container">
			<div class="nav">
				<ul>
					<li><a href = "${pageContext.request.contextPath}/">Home</a><li>
					<li><a href = "${pageContext.request.contextPath}/viewInformation">View Personal Information</a><li>
					<li><a href = "${pageContext.request.contextPath}/updateInformation">Update Personal Information</a><li>
					<li><a href = "${pageContext.request.contextPath}/viewBalance">Check Personal Balance</a><li>
					<li><a href = "${pageContext.request.contextPath}/viewMonitoring">Transaction History</a><li>
					<li><a href = "${pageContext.request.contextPath}/depositBalance">Deposit Balance</a><li>
					<li><a href = "${pageContext.request.contextPath}/withdrawBalance">Withdraw Balance</a><li>
					<li><a href = "${pageContext.request.contextPath}/transferBalance">Transfer Balance</a><li>
					<li><a href = "${pageContext.request.contextPath}/logout">Log Out</a><li>
				</ul>
			</div>
			<div class="content">
				<table id="table">
					<tr>
						<th colspan="3"><h2>TRANSACTION HISTORY</h2></th>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr style="font-size: 16px; font-weight: bold;">
						<td>Time</td>
						<td style="text-align: right;">&emsp;Description</td>
						<td style="text-align: right;">&emsp;Type</td>
					</tr>
					<c:forEach items="${list}" var="monitoring">
					<tr>
						<td>${monitoring.time}</td>
						<td style="text-align:right;">&emsp;${monitoring.description}</td>
						<td style="text-align:right;">&emsp;${monitoring.type}</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>