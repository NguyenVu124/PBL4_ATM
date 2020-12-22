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
		input[type=text]{
  			width: 90%;
  			padding: 10px 20px;
  			padding-left: 10px;
  			display: inline-block;
  			border: 1px solid #ccc;
  			box-sizing: border-box;
  			border-radius: 5px;
		}
		input[type=date] {
  			width: 90%;
  			padding: 10px 20px;
  			padding-left: 10px;
  			display: inline-block;
  			border: 1px solid #ccc;
  			box-sizing: border-box;
  			border-radius: 5px;
		}
		select {
  			width: 90%;
  			padding: 10px 20px;
  			padding-left: 10px;
  			display: inline-block;
  			border: 1px solid #ccc;
  			box-sizing: border-box;
  			border-radius: 5px;
		}
		button {
  			background-color: #0275d8;
  			color: white;
  			padding: 12px 25px;
  			border: none;
  			cursor: pointer;
  			width: 93%;
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
		.search {
			color: #333333;
			width:25%;
			padding: 20px;
		}
		.content {
			width: 100%;
  			width: 700px;
			margin: auto;
			position: absolute;
  			left: 30%;
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
			<div class="search">
				<form action="${pageContext.request.contextPath}/viewListMonitoring" method="POST">
				<table id="table">
				<tr>
					<th colspan="2"><h2>SEARCH</h2></th>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
    				<td>
						<input type="checkbox" name ="checkID" id="checkID" onclick="functionID()">
						ID: 
        			</td>
        			<td>
        				<input type="text" readonly name="inputID" id="inputID" style="padding-right:20px;">
					</td>
    			</tr>
				<tr>
    				<td>
						<input type="checkbox" name ="checkDate" id="checkDate" onclick="functionDate()">
						Date: 
        			</td>
        			<td>
        				<input type="date" readonly name="inputDate" id="inputDate" style="padding-right:20px;">
					</td>
    			</tr>
    			<tr>
    				<td>
						<input type="checkbox" name ="checkType" id="checkType" onclick="functionType()">
						Type: 
        			</td>
        			<td>
        				<select name="inputType" id="inputType" style="padding-right:20px;">
        					<option id="inputTypeAll" disabled value="ALL">All</option>
        					<option id="inputTypeWithdraw" disabled value="WITHDRAW">Withdraw</option>
        					<option id="inputTypeDeposit" disabled value="DEPOSIT">Deposit</option>
        					<option id="inputTypeTransfer" disabled value="TRANSFER">Transfer</option>
        				</select>
					</td>
    			</tr>	
    			<tr>
    				<td colspan="2" style="padding-bottom: 20px; width:90%;">
            		<button type="submit">SUBMIT</button>
        		</td>
    			</tr>
			</table>	
			</form>
				<p style="color:red; text-align: center;">${error}</p>
			</div>
			<div class="content">
				<table id="table">
					<tr>
						<th colspan="4"><h2>TRANSACTION HISTORY</h2></th>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr style="font-size: 16px; font-weight: bold;">
						<td>ID</td>
						<td style="text-align: right;">&emsp;Time</td>
						<td style="text-align: right;">&emsp;Description</td>
						<td style="text-align: right; padding-right:20px;">&emsp;Type</td>
					</tr>
					<c:forEach items="${list}" var="monitoring">
					<tr>
						<td>${monitoring.ID}</td>
						<td style="text-align:right;">&emsp;${monitoring.time}</td>
						<td style="text-align:right;">&emsp;${monitoring.description}</td>
						<td style="text-align:right; padding-right:20px;">&emsp;${monitoring.type}</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="footer"></div>
	</div>
	<script>
		function functionDate() {
			var checkBox = document.getElementById("checkDate");
			var inputDate = document.getElementById("inputDate");
			if (checkBox.checked == true){
				inputDate.readOnly = false;
			} else {
				inputDate.readOnly = true;
			}
		}
		function functionID() {
			var checkBox = document.getElementById("checkID");
			var inputID = document.getElementById("inputID");
			if (checkBox.checked == true){
				inputID.readOnly = false;
			} else {
				inputID.readOnly = true;
			}
		}
		function functionType() {
			var checkBox = document.getElementById("checkType");
			if (checkBox.checked == true){
				document.getElementById("inputTypeAll").disabled = false;
				document.getElementById("inputTypeWithdraw").disabled = false;
				document.getElementById("inputTypeDeposit").disabled = false;
				document.getElementById("inputTypeTransfer").disabled = false;
			} else {
				document.getElementById("inputTypeAll").disabled = true;
				document.getElementById("inputTypeWithdraw").disabled = true;
				document.getElementById("inputTypeDeposit").disabled = true;
				document.getElementById("inputTypeTransfer").disabled = true;
			}
		}
	</script>
</body>
</html>