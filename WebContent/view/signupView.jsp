<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="./view/style/signup.css" />
    <title>Đăng ký</title>
  </head>
  <body>
    <div class="wrapper">
      <div class="content" id="formContent">
        <h1>SIGN UP</h1>
        <br />
        <form action="${pageContext.request.contextPath}/signup" method="POST">
          <label>Username: </label>
          <td>
            <input type="text" name="username" class="input" />

            <label>Password: </label>
          </td>

          <td>
            <input type="password" name="password" class="input" />

            <label>RePassword: </label>
            <input type="password" name="repassword" class="input" />

            <input type="submit" value="Sign up"/>
          </td>
        </form>
        <p style="color: red;">${error}</p>
			<br>
      </div>
    </div>
    
    <div class="footer"></div>
  </body>
</html>
