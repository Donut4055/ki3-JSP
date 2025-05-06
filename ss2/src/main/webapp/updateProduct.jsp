<%@ page import="com.example.ss2.Bt678.Product" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Cập Nhật Sản Phẩm</title>
</head>
<body>
<h1>Cập Nhật Sản Phẩm</h1>
<%
  Product p = (Product) request.getAttribute("product");
  if (p == null) {
%>
<p style="color:red">Không tìm thấy sản phẩm!</p>
<p><a href="product">Quay lại danh sách</a></p>
<%
} else {
%>
<form action="product" method="post">
  <input type="hidden" name="action" value="update" />
  <input type="hidden" name="id" value="<%=p.getId()%>" />
  <label>Tên:</label>
  <input type="text" name="name" value="<%=p.getName()%>" required /><br/><br/>
  <label>Giá:</label>
  <input type="number" name="price" step="0.01" value="<%=p.getPrice()%>" required /><br/><br/>
  <button type="submit">Cập nhật</button>
  <a href="product">Hủy</a>
</form>
<%
  }
%>
</body>
</html>
