<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="./view/style/addInfo.css" />
    <title>Thêm thông tin cá nhân</title>
  </head>
  <body>
    <div class="wrapper fadeInDown">
      <div class="content" id="formContent">
        <h1>INSERT INFORMATION</h1>
        <br />
        <form
          action="${pageContext.request.contextPath}/insertInformation"
          method="POST"
        >
          <label>ID: </label>
          <input type="text" name="ID" value="${ID}" readonly />
          <label>Name: </label>
          <input type="text" name="name" />
          <label> Phone: </label>
          <input type="text" name="phone" />
          <label>Gender: </label>
          <input type="text" name="gender" />
          <label>Birth:</label>
          <input type="date" name="birth" />
          <label>Email: </label>
          <input type="text" name="email" />
          <label>Identity Number: </label>
          <input type="text" name="identitynumber" />
          <input type="submit" value="Insert"/>
        </form>
        <p style="color: red;">${error}</p>
			<br>
      </div>
    </div>
    <div class="footer"></div>
  </body>
</html>
