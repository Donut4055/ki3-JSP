<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cộng Hai Số</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
      text-align: center;
    }
    input {
      padding: 8px;
      font-size: 16px;
      margin: 5px;
    }
    button {
      padding: 10px 20px;
      font-size: 16px;
      background-color: #4CAF50;
      color: white;
      border: none;
      cursor: pointer;
    }
    button:hover {
      background-color: #45a049;
    }
    .result {
      margin-top: 20px;
      font-size: 1.2em;
    }
  </style>
</head>
<body>

<h1>Nhập Hai Số Và Thực Hiện Phép Cộng</h1>

<form action="bt4.jsp" method="post">
  <input type="number" name="num1" placeholder="Số 1" required />
  <input type="number" name="num2" placeholder="Số 2" required />
  <button type="submit">Cộng</button>
</form>

<%
  if ("POST".equalsIgnoreCase(request.getMethod())) {
    try {
      double num1 = Double.parseDouble(request.getParameter("num1"));
      double num2 = Double.parseDouble(request.getParameter("num2"));

      double result = num1 + num2;

      out.println("<div class='result'>");
      out.println("<strong>Kết quả: </strong>" + num1 + " + " + num2 + " = " + result);
      out.println("</div>");
    } catch (NumberFormatException e) {
      out.println("<p class='result' style='color:red;'>Vui lòng nhập các số hợp lệ.</p>");
    }
  }
%>

</body>
</html>
