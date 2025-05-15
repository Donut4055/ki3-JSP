
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>Product Details</h1>

<p><strong>Product Name:</strong> ${product.name}</p>
<p><strong>Quantity:</strong> ${product.quantity}</p>
<p><strong>Price:</strong> ${product.price}</p>

<br>
<a href="${pageContext.request.contextPath}/products">Back to Product List</a>
</body>
</html>

