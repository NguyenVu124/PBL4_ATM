<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>SIGN UP</title>
	<link rel="preconnect" href="https://fonts.gstatic.com"> 
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;700&display=swap" rel="stylesheet">
	<style>
		* {
			font-family: 'Inter', sans-serif;
		}
		input[type=text], input[type=password] {
  			width: 100%;
  			padding: 12px 20px;
  			margin: 8px 0;
  			display: inline-block;
  			border: 1px solid #ccc;
  			box-sizing: border-box;
  			border-radius: 5px;
		}
		button {
  			background-color: #0275d8;
  			color: white;
  			padding: 14px 20px;
  			margin: 8px 0;
  			border: none;
  			cursor: pointer;
  			width: 100%;
  			border-radius: 5px;
		}
		button:hover {
  			opacity: 0.8;
		}
		body {
			background-color: #f7f7f7;
		}
		.text-center {
			text-align: center;
			color: #0275d8;
		}
		.centered {
			border-radius: 5px;
  			padding: 35px;
  			width: 320px;
  			height: 41%;
			margin: auto;
			position: absolute;
  			margin-top: 385px;
  			left: 50%;
  			transform: translate(-50%, -50%);
  			box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.05), 0 6px 50px 0 rgba(0, 0, 0, 0.1);
  			background-color: white;
		}
		a {
			text-align: center;
			text-decoration: none;
			color: #0275d8;
		}
	</style>
</head>
<body>
	<div class="bgcolor">
	<div class="centered">
    	<form action="${pageContext.request.contextPath}/signup" method="POST">
        	<h1 class="text-center">SIGN UP</h1>       
        	<div>
            	<input type="text" placeholder="Username" required="required" name="username">
        	</div>
        	<div>
            	<input type="password" placeholder="Password" required="required" name="password">
        	</div>
        	<div>
            	<input type="password" placeholder="Confirm Password" required="required" name="repassword">
        	</div>
        	<div>
            	<button type="submit">SIGN UP</button>
        	</div>  
        	<div>
        		<p style="font-size: 14px; text-align: center;">Already have account? <a style="font-size: 14px;" href="${pageContext.request.contextPath}/login">Log In</a></p>
				
        	</div> 
        	<div>
            	<p style="color:red; font-size:12px; text-align: center;">${error}</p>
        	</div>      
   		</form>
	</div>
	</div>
</body>
</html>