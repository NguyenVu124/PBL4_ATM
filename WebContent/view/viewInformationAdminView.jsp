<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ALL USER INFORMATION</title>
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
			width:100%;
			padding: 10px;
		}
		.content {
			width: 100%;
  			width: 1200px;
			margin: auto;
			position: absolute;
  			left: 17%;
  			padding-top: 20px;
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
  			padding-bottom: 25px;
  			padding-left: 25px;
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
				<table id="table">
					<tr>
						<th colspan="9"><h2>ALL USER INFORMATION</h2></th>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr style="font-size: 16px; font-weight: bold;">
						<td>ID</td>
						<td>Name</td>
						<td>Phone</td>
						<td>Gender</td>
						<td>Birth</td>
						<td>Email</td>
						<td>Identity Number</td>
						<td>Update</td>
						<td style="padding-right:10px;">Delete</td>
					</tr>
					<c:forEach items="${list}" var="infor">
					<tr>
						<td>${infor.ID}</td>
						<td>${infor.name}</td>
						<td>${infor.phone}</td>
						<td>${infor.gender}</td>
						<td>${infor.birth}</td>
						<td>${infor.email}</td>
						<td>${infor.identitynumber}</td>
						<td><a href="updateInformationA?ID=${infor.ID}">Update</a></td>
						<td style="padding-right:10px;"><a href="deleteAccount?ID=${infor.ID}" onClick="return submitResult();">Delete</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="footer"></div>
	</div>
	<script>
		function submitResult() {
			if (confirm("Are you sure to delete?") == false) {
				return false ;
				} else {
			    return true ;
			}
		}
	</script>
</body>
</html>