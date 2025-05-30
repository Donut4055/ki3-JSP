<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <title>Danh sách khóa học</title>
</head>
<body>
<h2>Danh sách khóa học</h2>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Tên khóa học</th>
    <th>Mô tả</th>
    <th>Thao tác</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="course" items="${courses}">
    <tr>
      <td>${course.id}</td>
      <td>${course.name}</td>
      <td>${course.description}</td>
      <td>
        <a href="/bt10/courses/delete/${course.id}">Xóa</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="${pageContext.request.contextPath}/bt10/courses/add">Thêm khóa học mới</a>
</body>
</html>
