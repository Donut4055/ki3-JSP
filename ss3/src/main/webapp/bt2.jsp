<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Thông Tin Người Dùng</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }
    .form-container {
      background-color: #f4f4f4;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
      margin-bottom: 20px;
    }
    .message {
      font-size: 1.2em;
      margin-top: 20px;
    }
  </style>
</head>
<body>

<h1>Nhập Thông Tin Người Dùng</h1>

<div class="form-container">
  <form action="bt2.jsp" method="post">
    <label for="name">Tên:</label>
    <input type="text" id="name" name="name" required /><br/><br/>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required /><br/><br/>

    <button type="submit">Lưu Thông Tin</button>
  </form>
</div>

<%
  if ("POST".equalsIgnoreCase(request.getMethod())) {
    String name = request.getParameter("name");
    String email = request.getParameter("email");

    application.setAttribute("userName", name);
    application.setAttribute("userEmail", email);

    out.println("<div class='message'>Thông tin của bạn đã được lưu trữ.</div>");
  }

  String storedName = (String) application.getAttribute("userName");
  String storedEmail = (String) application.getAttribute("userEmail");

  if (storedName != null && storedEmail != null) {
%>
<h2>Thông Tin Người Dùng Đã Lưu:</h2>
<p><strong>Tên:</strong> <%= storedName %></p>
<p><strong>Email:</strong> <%= storedEmail %></p>
<%
  } else {
    out.println("<p class='message'>Chưa có thông tin người dùng nào.</p>");
  }
%>

</body>
</html>
