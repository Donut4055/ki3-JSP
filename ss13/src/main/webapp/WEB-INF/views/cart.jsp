<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Giỏ hàng</title></head>
<body>
<h2>Thêm sản phẩm vào giỏ hàng</h2>
<form:form method="POST" action="/cart/add" modelAttribute="product">
  <div>
    <label>Tên sản phẩm:</label>
    <form:input path="name" list="productNamesList"/>
    <datalist id="productNamesList">
      <c:forEach var="n" items="${productNames}">
        <option value="${n}"/>
      </c:forEach>
    </datalist>
  </div>
  <div>
    <label>Số lượng:</label>
    <form:input path="quantity" type="number"/>
  </div>
  <button type="submit">Thêm vào giỏ</button>
</form:form>

<h2>Danh sách sản phẩm trong giỏ hàng</h2>
<table border="1">
  <tr>
    <th>STT</th>
    <th>Tên sản phẩm</th>
    <th>Số lượng</th>
    <th>Xóa</th>
  </tr>
  <c:forEach var="p" items="${cart}" varStatus="status">
    <tr>
      <td>${status.index + 1}</td>
      <td>${p.name}</td>
      <td>${p.quantity}</td>
      <td>
        <a href="/cart/delete/${status.index}" onclick="return confirm('Bạn chắc chắn muốn xóa?')">Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>

