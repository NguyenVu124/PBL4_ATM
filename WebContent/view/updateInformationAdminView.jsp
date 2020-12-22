<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>UPDATE USER INFORMATION</title>
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
		input[type=text], input[type=date] {
  			width: 100%;
  			padding: 10px 20px;
  			padding-left: 10px;
  			display: inline-block;
  			border: 1px solid #ccc;
  			box-sizing: border-box;
  			border-radius: 5px;
		}
		input[type=radio] {
  			text-align: left;
		}
		button {
  			background-color: #0275d8;
  			color: white;
  			padding: 12px 25px;
  			border: none;
  			cursor: pointer;
  			width: 100%;
  			border-radius: 5px;
		}
		button:hover {
  			opacity: 0.8;
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
  			width: 470px;
			margin: auto;
			position: absolute;
  			margin-top: 320px;
  			left: 50%;
  			transform: translate(-50%, -50%);
  			background-color: #white;
  			overflow: auto;
  			align-items: center;
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
  			padding-bottom: 15px;
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
			color:#333333;
			vertical-align: middle;
			line-height: 10px;
			padding-right:10px;
		}
		a:visited {
			color: #0275d8;
		}
		a {
			color: #0275d8;
		}
		.topnav {
  			position: relative;
  			overflow: hidden;
  			background-color: #0275d8;
  			padding-left: 710px;
		}
		.topnav a {
  			float: left;
  			color: #f2f2f2;
  			text-align: center;
  			padding: 16px 32px;
  			text-decoration: none;
		}
		.topnav a:hover {
			color: #0275d8;
  			background-color: white;
  			opacity: 0.9;
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
		<div class="topnav">
    			<a href="${pageContext.request.contextPath}/viewListInformation">USER</a>
    			<a href="${pageContext.request.contextPath}/viewListMonitoring">TRANSACTION</a>
    			<a href="${pageContext.request.contextPath}/logout">LOG OUT</a>
		</div>
		<div class="container">
			
						<div class="content">
				<form action="${pageContext.request.contextPath}/updateInformationA" method="POST" onsubmit="return submitResult();">
				<table id="table">
				<tr>
					<th colspan="2"><h2>UPDATE INFORMATION</h2></th>
				</tr>
				<tr>
					<td></td>
				</tr>
					<tr>
						<td>ID:</td>
						<td><input type="text" name="ID" value="${infor.ID}" readonly></td>
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
						<td><input type="radio" name="gender" value="Male" checked> Male &emsp;
						<input type="radio" name="gender" value="Female"> Female
						</td>
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
				<td colspan="2" style="padding-bottom: 20px;">
            		<button type="submit">SUBMIT</button>
        		</td>
				</tr>
				</table>	
				<input type="hidden" name="func" value="withdraw">
			</form>
			<p style="color:red; text-align: center;">${error}</p>
			<p style="color: #0275d8; text-align: center;"><a href = "${pageContext.request.contextPath}/viewListInformation">Back</a></p>
			</div>
		</div>
		<div class="footer"></div>
	</div>
	<script>
		function submitResult() {
			if (confirm("Are you sure to update?") == false) {
				return false ;
				} else {
			    return true ;
			}
		}
	</script>
</body>
</html>