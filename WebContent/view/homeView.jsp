<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HOME PAGE</title>
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
  			width: 400px;
			margin: auto;
			position: absolute;
  			top: 40%;
  			left: 49%;
  			transform: translate(-50%, -50%);
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
				
			</div>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>