<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Danh sách sản phẩm</title>
  <style>
    table { border-collapse: collapse; width: 80%; margin: 20px auto; }
    th, td { border: 1px solid #666; padding: 8px; text-align: left; }
    th { background: #eee; }
    h1 { text-align: center; }
  </style>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Product Name</th>
    <th>Price</th>
    <th>Description</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="p" items="${products}">
    <tr>
      <td><c:out value="${p.id}"/></td>
      <td><c:out value="${p.productName}"/></td>
      <td><c:out value="${p.price}"/></td>
      <td><c:out value="${p.description}"/></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
