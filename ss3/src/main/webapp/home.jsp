<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Trang Chủ</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
      text-align: center;
    }
    button {
      background-color: #4CAF50;
      color: white;
      padding: 15px 32px;
      text-align: center;
      font-size: 16px;
      cursor: pointer;
    }
    button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>

<h1>Chào Mừng Bạn Đến Với Trang Chủ</h1>
<p>Nhấn vào nút dưới đây để chuyển đến trang chào mừng.</p>

<form action="home.jsp" method="post">
  <button type="submit">Đi đến Trang Chào Mừng</button>
</form>

<%
  if ("POST".equalsIgnoreCase(request.getMethod())) {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp");
    dispatcher.forward(request, response);
  }
%>

</body>
</html>
