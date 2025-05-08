<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Đăng Nhập</title>
  <style>
    body { font-family: Arial, sans-serif; padding: 20px; }
    .form-box { width: 300px; margin: auto; padding: 20px; border: 1px solid #ccc; }
    input { width: 100%; padding: 8px; margin: 8px 0; }
    button { width: 100%; padding: 8px; }
    .message { text-align: center; margin-top: 15px; font-weight: bold; }
    .success { color: green; }
    .error   { color: red; }
  </style>
</head>
<body>

<div class="form-box">
  <h2>Đăng Nhập</h2>
  <form action="bt2.jsp" method="post">
    <label>Username:</label>
    <input type="text" name="username" required />
    <label>Password:</label>
    <input type="password" name="password" required />
    <button type="submit">Login</button>
  </form>

  <c:if test="${not empty param.username}">
    <c:if test="${param.username eq 'admin' and param.password eq '123456'}">
      <div class="message success">
        Chào mừng <c:out value="${param.username}" />! Đăng nhập thành công.
      </div>
    </c:if>

    <c:if test="${not(param.username eq 'admin' and param.password eq '123456')}">
      <div class="message error">
        Sai tên đăng nhập hoặc mật khẩu. Vui lòng thử lại.
      </div>
    </c:if>
  </c:if>
</div>

</body>
</html>
