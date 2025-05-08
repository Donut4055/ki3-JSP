<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="Model.Order" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Form</title>
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

<h1>Order Form</h1>

<div class="form-container">
    <form action="bt7.jsp" method="post">
        <label for="product">Product:</label>
        <select name="product" id="product">
            <option value="Product A">Product A</option>
            <option value="Product B">Product B</option>
            <option value="Product C">Product C</option>
        </select><br/><br/>

        <label for="quantity">Quantity:</label>
        <input type="number" name="quantity" id="quantity" required /><br/><br/>

        <label for="price">Price per Unit:</label>
        <input type="number" name="price" id="price" required step="0.01" /><br/><br/>

        <button type="submit">Submit</button>
    </form>
</div>

<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String product = request.getParameter("product");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        Order order = new Order(product, quantity, price);
        double totalPrice = order.calculateTotal();

        out.println("<h3>Thông Tin Đơn Hàng:</h3>");
        out.println("<table>");
        out.println("<tr><th>Product</th><td>" + order.getProductName() + "</td></tr>");
        out.println("<tr><th>Quantity</th><td>" + order.getQuantity() + "</td></tr>");
        out.println("<tr><th>Price per Unit</th><td>" + order.getPricePerUnit() + "</td></tr>");
        out.println("<tr><th>Total Price</th><td>" + totalPrice + "</td></tr>");
        out.println("</table>");
    }
%>

</body>
</html>
