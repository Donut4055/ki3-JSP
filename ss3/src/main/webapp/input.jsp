<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đăng ký người dùng</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }
    .form-container {
      background-color: #f4f4f4;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
  </style>
</head>
<body>

<h1>Đăng ký người dùng</h1>

<% if ("true".equals(request.getParameter("success"))) { %>
<p style="color: green;">Đăng ký thành công!</p>
<% } %>

<div class="form-container">
  <form action="UserServlet" method="post">
    <input type="text" name="name" placeholder="Tên người dùng" required /><br/><br/>
    <input type="email" name="email" placeholder="Email" required /><br/><br/>
    <button type="submit">Đăng ký</button>
  </form>
</div>

</body>
</html>
