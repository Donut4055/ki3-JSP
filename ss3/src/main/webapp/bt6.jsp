<%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Sản Phẩm</title>
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

<h1>Quản Lý Sản Phẩm</h1>

<!-- Form thêm sản phẩm -->
<div class="form-container">
    <h3>Thêm Sản Phẩm</h3>
    <form action="bt6.jsp" method="post">
        <input type="number" name="id" placeholder="ID" required /><br/><br/>
        <input type="text" name="productName" placeholder="Tên sản phẩm" required /><br/><br/>
        <input type="number" step="0.01" name="price" placeholder="Giá" required /><br/><br/>
        <input type="text" name="description" placeholder="Mô tả" required /><br/><br/>
        <input type="number" name="stock" placeholder="Số lượng" required /><br/><br/>
        <input type="text" name="status" placeholder="Trạng thái (Còn hàng/Hết hàng)" required /><br/><br/>
        <button type="submit">Thêm sản phẩm</button>
    </form>
</div>

<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        int id = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int stock = Integer.parseInt(request.getParameter("stock"));
        String status = request.getParameter("status");

        Product product = new Product(id, productName, price, description, stock, status);

        List<Product> productList = (List<Product>) application.getAttribute("productList");
        if (productList == null) {
            productList = new ArrayList<>();
        }

        productList.add(product);

        application.setAttribute("productList", productList);
    }

    List<Product> productList = (List<Product>) application.getAttribute("productList");
    if (productList == null) {
        productList = new ArrayList<>();
    }

    if (!productList.isEmpty()) {
%>

<h3>Danh sách sản phẩm đã thêm:</h3>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên Sản Phẩm</th>
        <th>Giá</th>
        <th>Mô Tả</th>
        <th>Số Lượng</th>
        <th>Trạng Thái</th>
    </tr>
    </thead>
    <tbody>
    <% for (Product p : productList) { %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getProductName() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getDescription() %></td>
        <td><%= p.getStock() %></td>
        <td><%= p.getStatus() %></td>
    </tr>
    <% } %>
    </tbody>
</table>

<%
    } else {
        out.println("<p>Chưa có sản phẩm nào.</p>");
    }
%>

</body>
</html>
