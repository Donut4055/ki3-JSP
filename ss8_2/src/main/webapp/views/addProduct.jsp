
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Add Product</title>
</head>
<body>
<h1>Add New Product</h1>
<form action="/products/add" method="post">
  <label for="name">Product Name:</label>
  <input type="text" name="name" id="name" required><br><br>

  <label for="quantity">Quantity:</label>
  <input type="number" name="quantity" id="quantity" required><br><br>

  <label for="price">Price:</label>
  <input type="number" name="price" id="price" step="0.01" required><br><br>

  <button type="submit">Add Product</button>
</form>
<br>
<a href="${pageContext.request.contextPath}/products">Back to Product List</a>
</body>
</html>

