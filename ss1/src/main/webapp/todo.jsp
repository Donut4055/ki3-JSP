<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Todo List JSP + Servlet</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      padding: 20px;
      max-width: 600px;
      margin: auto;
    }
    /* Form thêm công việc */
    form.add-form {
      display: flex;
      gap: 10px;
      margin-bottom: 20px;
    }
    form.add-form input[type="text"] {
      flex: 1;
      padding: 8px 12px;
      border: 1px solid #ccc;
      border-radius: 20px;
      box-sizing: border-box;
    }
    form.add-form button {
      padding: 8px 20px;
      border: none;
      border-radius: 20px;
      background: #4B4BFB;
      color: #fff;
      cursor: pointer;
    }

    /* Bảng công việc */
    table {
      width: 100%;
      border-collapse: collapse;
    }
    th, td {
      padding: 8px;
      border: 1px solid #ccc;
      text-align: center;
    }
    th {
      background: #333;
      color: #fff;
    }

    /* Dòng Doing (chưa hoàn thành) */
    .doing {
      background: #FFFF00;
      color: #000;
    }
    /* Dòng Completed (đã hoàn thành) */
    .completed {
      background: #4B4BFB;
      color: #fff;
    }

    /* Button đổi trạng thái */
    form.inline {
      display: inline;
      margin: 0;
      padding: 0;
    }
    form.inline button {
      padding: 4px 8px;
      border: 1px solid #666;
      border-radius: 4px;
      background: #fff;
      cursor: pointer;
    }
  </style>
</head>
<body>
<h2>Todo List</h2>

<!-- Form thêm công việc -->
<form class="add-form" action="Bt8" method="post">
  <input type="hidden" name="action" value="add"/>
  <input type="text" name="description" placeholder="Enter new job" required/>
  <button type="submit">Add</button>
</form>

<!-- Bảng hiển thị công việc -->
<table>
  <tr>
    <th>ID</th>
    <th>Job Name</th>
    <th>Status</th>
    <th>Action</th>
  </tr>
  <c:forEach var="todo" items="${todos}" varStatus="st">
    <tr class="${todo.completed ? 'completed' : 'doing'}">
      <td>${st.count}</td>
      <td>${todo.description}</td>
      <td>
        <c:choose>
          <c:when test="${todo.completed}">Completed</c:when>
          <c:otherwise>Doing</c:otherwise>
        </c:choose>
      </td>
      <td>
        <form class="inline" action="Bt8" method="post">
          <input type="hidden" name="action" value="toggle"/>
          <input type="hidden" name="index"  value="${st.index}"/>
          <button type="submit">Change status</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
