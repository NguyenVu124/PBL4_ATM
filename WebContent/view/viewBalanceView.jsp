<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Kiểm tra số dư</title>
    <link rel="stylesheet" href="./view/style/viewBalance.css" />
    <link rel="stylesheet" href="./view/style/nav.css" />
  </head>
  <body>
    <div>
      <div style="background: #56baed; height: 80px; padding: 1px; width: 100%">
        <h2 style="text-align: center; justify-content: center; padding: 10px">
          HỆ THỐNG QUẢN LÍ TÀI KHOẢN ATM
        </h2>
      </div>
      <div class="container">
        <div class="nav">
          <ul>
            <li>
              <a href="${pageContext.request.contextPath}/">Trang chủ</a>
            </li>

            <li>
              <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
            </li>

            <li>
              <a href="${pageContext.request.contextPath}/signup">Đăng ký</a>
            </li>

            <li>
              <a href="${pageContext.request.contextPath}/viewInformation"
                >Xem tài khoản cá nhân</a
              >
            </li>

            <li>
              <a href="${pageContext.request.contextPath}/updateInformation"
                >Sửa tài khoản cá nhân</a
              >
            </li>

            <li>
              <a href="${pageContext.request.contextPath}/deleteAccount"
                >Xoá tài khoản cá nhân</a
              >
            </li>

            <li>
              <a href="${pageContext.request.contextPath}/viewBalance"
                >Kiểm tra số dư</a
              >
            </li>

            <li>
              <a href="${pageContext.request.contextPath}/viewMonitoring"
                >Kiểm tra giao dịch</a
              >
            </li>

            <li>
              <a href="${pageContext.request.contextPath}/depositBalance"
                >Nạp tiền vào tài khoản</a
              >
            </li>

            <li>
              <a href="${pageContext.request.contextPath}/withdrawBalance"
                >Rút tiền từ tài khoản</a
              >
            </li>

            <li>
              <a href="${pageContext.request.contextPath}/transferBalance"
                >Chuyển tiền sang tài khoản khác</a
              >
            </li>

            <li>
              <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
            </li>
          </ul>
        </div>
        <div class="content">
          <h3>VIEW BALANCE PAGE</h3>
          <table>
            <tr>
              <td>Balance:</td>
              <td>${balance.balance}</td>
            </tr>
          </table>
        </div>
      </div>
      <div class="footer"></div>
    </div>
  </body>
</html>
