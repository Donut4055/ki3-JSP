
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Danh sách học sinh đã đăng ký</title>
  <style>
    body { font-family: Arial; padding: 20px; }
    table { width: 100%; border-collapse: collapse; }
    th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
    th { background: #f0f0f0; }
  </style>
</head>
<body>
<h2>Danh sách học sinh đã đăng ký vé xe</h2>
<table>
  <tr>
    <th>Họ và tên</th>
    <th>Lớp</th>
    <th>Loại xe</th>
    <th>Biển số xe</th>
  </tr>
  <c:forEach var="stu" items="${students}">
    <tr>
      <td>${stu.fullName}</td>
      <td>${stu.className}</td>
      <td>${stu.vehicleType}</td>
      <td>${stu.plateNumber}</td>
    </tr>
  </c:forEach>
</table>
<p><a href="Bt6">Quay lại đăng ký</a></p>
</body>
</html>
