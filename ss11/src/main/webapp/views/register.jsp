<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Đăng ký</title>
</head>
<body>
<h2>Đăng ký</h2>

<form:form method="POST" modelAttribute="registerForm">
  <div>
    <label>Tên:</label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/>
  </div>

  <div>
    <label>Email:</label>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>
  </div>

  <div>
    <label>Vai trò:</label>
    <form:select path="role">
      <form:option value="">-- Chọn vai trò --</form:option>
      <form:option value="admin">Admin</form:option>
      <form:option value="user">User</form:option>
    </form:select>
    <form:errors path="role" cssClass="error"/>
  </div>

  <c:if test="${registerForm.role == 'user'}">
    <div>
      <label>Tuổi:</label>
      <form:input path="age" type="number"/>
      <form:errors path="age" cssClass="error"/>
    </div>
  </c:if>

  <c:if test="${registerForm.role == 'admin'}">
    <div>
      <label>Mã Admin:</label>
      <form:input path="adminCode"/>
      <form:errors path="adminCode" cssClass="error"/>
    </div>
  </c:if>

  <button type="submit">Đăng ký</button>
</form:form>
</body>
</html>
