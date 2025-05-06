<%@ page import="com.example.ss2.Bt678.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Danh Sách Sản Phẩm</title>
  <script>
    function confirmDelete(id) {
      if (confirm("Bạn có chắc muốn xóa?")) {
        document.getElementById("del-"+id).submit();
      }
    }
  </script>
</head>
<body>
<h1>Danh Sách Sản Phẩm</h1>

<!-- Form thêm -->
<fieldset>
  <legend>Thêm Sản Phẩm</legend>
  <form action="product" method="post">
    <input type="hidden" name="action" value="add" />
    <label>Tên:</label>
    <input type="text" name="name" required />
    <label>Giá:</label>
    <input type="number" name="price" step="0.01" required />
    <button type="submit">Thêm</button>
  </form>
</fieldset>

<!-- Bảng danh sách -->
<table border="1" cellpadding="5" cellspacing="0">
  <thead>
  <tr><th>ID</th><th>Tên</th><th>Giá</th><th>Hành Động</th></tr>
  </thead>
  <tbody>
  <%
    List<Product> list = (List<Product>) application.getAttribute("productList");
    for (Product p : list) {
  %>
  <tr>
    <td><%=p.getId()%></td>
    <td><%=p.getName()%></td>
    <td><%=p.getPrice()%></td>
    <td>
      <a href="product?action=edit&id=<%=p.getId()%>">Sửa</a>
      &nbsp;|&nbsp;
      <form id="del-<%=p.getId()%>" action="product" method="post" style="display:inline">
        <input type="hidden" name="action" value="delete" />
        <input type="hidden" name="id" value="<%=p.getId()%>" />
        <a href="#" onclick="confirmDelete(<%=p.getId()%>)">Xóa</a>
      </form>
    </td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>
