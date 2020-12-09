<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Kiểm tra giao dịch</title>
    <link rel="stylesheet" href="./view/style/table.css" />
  </head>
  <body>
    <div>
      <div class="header"><jsp:include page="_header.jsp"></jsp:include></div>
      <div class="container">
        <div class="nav"><jsp:include page="_nav.jsp"></jsp:include></div>
        <div class="content">
          <h1>HISTORY TRANSFER</h1>
          <table>
            <div class="table-header">
              <div class="header__item">
                <a id="name" class="filter__link" href="#">Name</a>
              </div>
              <div class="header__item">
                <a id="wins" class="filter__link filter__link--number" href="#"
                  >Wins</a
                >
              </div>
            </div>
            <c:forEach items="${list}" var="monitoring">
              <div class="table-row">
                <div class="table-data">${monitoring.time}</div>
                <div class="table-data">&emsp;${monitoring.description}</div>
              </div>
              
            </c:forEach>
          </table>
        </div>
      </div>
      <div class="footer"></div>
    </div>
  </body>
</html>