<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="Model.Book" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Quản Lý Sách</title>
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
      margin-bottom: 20px;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }
    table, th, td {
      border: 1px solid #ddd;
    }
    th, td {
      padding: 12px;
      text-align: left;
    }
    button {
      background-color: #007bff;
      color: white;
      padding: 10px 20px;
      border: none;
      cursor: pointer;
      font-size: 16px;
      border-radius: 5px;
    }
    button:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>

<h1>Quản Lý Sách</h1>

<!-- Form thêm sách -->
<div class="form-container">
  <h3>Thêm Sách Mới</h3>
  <form action="BookServlet" method="post">
    <input type="text" name="name" placeholder="Tên Sách" required /><br/><br/>
    <input type="text" name="author" placeholder="Tác Giả" required /><br/><br/>
    <input type="number" name="year" placeholder="Năm Xuất Bản" required /><br/><br/>
    <button type="submit">Thêm Sách</button>
  </form>
</div>

<!-- Tìm kiếm sách, tự động hiển thị khi người dùng nhập -->
<form action="BookServlet" method="get">
  <input type="text" name="search" id="searchInput" placeholder="Tìm kiếm sách theo tên..." onkeyup="this.form.submit()"/>
</form>

<%
  // Lấy kết quả tìm kiếm từ request
  List<Book> searchResults = (List<Book>) request.getAttribute("searchResults");
  // Lấy danh sách sách từ ngữ cảnh ứng dụng
  List<Book> bookList = (List<Book>) application.getAttribute("bookList");

  if (searchResults == null) {
    searchResults = bookList;
  }

  // Hiển thị danh sách sách
  if (searchResults != null && !searchResults.isEmpty()) {
%>
<h3>Danh sách sách:</h3>
<table>
  <thead>
  <tr>
    <th>Tên Sách</th>
    <th>Tác Giả</th>
    <th>Năm Xuất Bản</th>
  </tr>
  </thead>
  <tbody>
  <% for (Book book : searchResults) { %>
  <tr>
    <td><%= book.getName() %></td>
    <td><%= book.getAuthor() %></td>
    <td><%= book.getYear() %></td>
  </tr>
  <% } %>
  </tbody>
</table>
<%
  } else {
    out.println("<p>Chưa có sách nào hoặc không tìm thấy sách.</p>");
  }
%>

</body>
</html>
