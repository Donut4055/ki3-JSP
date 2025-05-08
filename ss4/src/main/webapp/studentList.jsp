<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Quản Lý Sinh Viên</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    .error { color: red; margin-bottom: 10px; }
    table { border-collapse: collapse; width: 80%; }
    th, td { border: 1px solid #666; padding: 6px 12px; }
    th { background: #eee; }
    form.inline { display: inline; }
  </style>
</head>
<body>

<h1>Quản Lý Sinh Viên</h1>

<c:if test="${not empty error}">
  <div class="error">${error}</div>
</c:if>

<form action="students" method="post">
  <input type="hidden" name="action" value="add"/>
  Tên: <input type="text" name="name" value="${oldName}" />
  Điểm: <input type="number" step="0.1" name="score" value="${oldScore}" />
  Địa chỉ: <input type="text" name="address" value="${oldAddress}" />
  <button type="submit">Thêm</button>
</form>

<hr/>

<table>
  <thead>
  <tr>
    <th>ID</th><th>Tên</th><th>Điểm</th><th>Địa chỉ</th><th>Hành động</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="s" items="${students}">
    <tr>
      <td><c:out value="${s.id}"/></td>
      <td><c:out value="${s.name}"/></td>
      <td><c:out value="${s.score}"/></td>
      <td><c:out value="${s.address}"/></td>
      <td>
        <form action="students" method="post" class="inline">
          <input type="hidden" name="action" value="delete"/>
          <input type="hidden" name="id" value="${s.id}"/>
          <button type="submit">Xóa</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<h3>Số lượng sinh viên có điểm trên 7.0:
  <c:set var="count" value="0" />
  <c:forEach var="s" items="${students}">
    <c:if test="${s.score > 7}">
      <c:set var="count" value="${count + 1}" />
    </c:if>
  </c:forEach>
  <c:out value="${count}"/>
</h3>

</body>
</html>
