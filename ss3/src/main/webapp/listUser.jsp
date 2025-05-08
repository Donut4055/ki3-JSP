<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="Model.User" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Danh sách người dùng</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
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
      background-color: red;
      color: white;
      padding: 5px 10px;
      border: none;
      cursor: pointer;
      font-size: 14px;
      border-radius: 5px;
    }
    button:hover {
      background-color: darkred;
    }
  </style>
</head>
<body>

<h1>Danh sách người dùng</h1>

<%
  List<User> users = (List<User>) request.getAttribute("users");
  if (users != null && !users.isEmpty()) {
%>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Tên Người Dùng</th>
    <th>Email</th>
    <th>Hành động</th>
  </tr>
  </thead>
  <tbody>
  <% for (User user : users) { %>
  <tr>
    <td><%= user.getId() %></td>
    <td><%= user.getName() %></td>
    <td><%= user.getEmail() %></td>
    <td>
      <form action="UserServlet" method="post" style="display:inline;">
        <input type="hidden" name="id" value="<%= user.getId() %>" />
        <button type="submit" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</button>
      </form>
    </td>
  </tr>
  <% } %>
  </tbody>
</table>

<% } else { %>
<p>Không có người dùng nào trong danh sách.</p>
<% } %>

</body>
</html>
