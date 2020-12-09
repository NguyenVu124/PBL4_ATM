<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet" href="./view/style/style.css" />
<title>Home</title>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->
			<h2>
				<a href="">Sign In</a>
			</h2>
			<h2>
				<a href="${pageContext.request.contextPath}/signup">Sign Up</a>
			</h2>

			<!-- Login Form -->
			<form action="${pageContext.request.contextPath}/login" method="post">
				<input type="text" name="username" placeholder="username" /> <input
					type="password" name="password" placeholder="password" /> <input
					type="submit" value="Log In" />
			</form>
			<p style="color: red;">${error}</p>
			<br>
			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>
		</div>
	</div>
</body>
</html>