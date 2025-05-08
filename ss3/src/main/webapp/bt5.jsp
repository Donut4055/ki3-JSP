<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đăng Ký Người Dùng</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
      text-align: center;
    }
    .form-container {
      background-color: #fff;
      padding: 20px;
      margin: 50px auto;
      width: 300px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      border-radius: 5px;
    }
    input {
      padding: 10px;
      margin: 10px;
      width: 100%;
      font-size: 16px;
      border: 1px solid #ddd;
      border-radius: 5px;
    }
    button {
      padding: 10px;
      background-color: #007bff;
      color: white;
      border: none;
      border-radius: 5px;
      width: 100%;
      font-size: 16px;
      cursor: pointer;
    }
    button:hover {
      background-color: #0056b3;
    }
    .message {
      font-size: 1.2em;
      margin-top: 20px;
    }
  </style>
</head>
<body>

<div class="form-container">
  <h2>Đăng Ký Người Dùng</h2>

  <form action="bt5.jsp" method="post">
    <input type="text" name="username" placeholder="Username" required /><br/>
    <input type="password" name="password" placeholder="Password" required /><br/>
    <input type="email" name="email" placeholder="Email" required /><br/>
    <button type="submit">Đăng Ký</button>
  </form>

  <%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      String email = request.getParameter("email");

      out.println("<div class='message'>");
      out.println("<p>Cảm ơn bạn đã đăng ký!</p>");
      out.println("<p><strong>Tên người dùng:</strong> " + username + "</p>");
      out.println("<p><strong>Email:</strong> " + email + "</p>");
      out.println("</div>");
    }
  %>
</div>

</body>
</html>
