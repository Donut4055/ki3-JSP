<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Form nhập thông tin người dùng</title>
  <style>
    .error { color: red; }
  </style>
</head>
<body>
<h2>Nhập thông tin người dùng</h2>

<form:form method="post" modelAttribute="user">

  <div>
    <form:label path="name">Name:</form:label>
    <form:input path="name" />
    <form:errors path="name" cssClass="error" delimiter="" />
  </div>

  <div>
    <form:label path="email">Email:</form:label>
    <form:input path="email" />
    <form:errors path="email" cssClass="error" delimiter="" />
  </div>

  <div>
    <form:label path="phone">Phone:</form:label>
    <form:input path="phone" />
    <form:errors path="phone" cssClass="error" delimiter="" />
  </div>

  <div>
    <form:label path="password">Password:</form:label>
    <form:password path="password" />
    <form:errors path="password" cssClass="error" delimiter="" />
  </div>

  <div>
    <form:label path="status">Status:</form:label>
    <form:checkbox path="status" />
    <form:errors path="status" cssClass="error" delimiter="" />
  </div>

  <div>
    <input type="submit" value="Submit" />
  </div>

</form:form>

<c:if test="${not empty message}">
  <p style="color:green">${message}</p>
</c:if>
</body>
</html>

