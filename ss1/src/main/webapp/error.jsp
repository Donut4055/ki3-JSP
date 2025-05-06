<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Đã xảy ra lỗi</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f8f8f8;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
      margin: 0;
    }
    .error-box {
      background: #fff;
      padding: 30px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
      text-align: center;
    }
    .error-box h1 { color: #c00; }
    .error-box p { margin: 20px 0; }
    .error-box a { color: #06c; text-decoration: none; }
  </style>
</head>
<body>
<div class="error-box">
  <p>${requestScope.errorMessage}</p>
  <a href="index.jsp">Quay về Trang chủ</a>
</div>
</body>
</html>
