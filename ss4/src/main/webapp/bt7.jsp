<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Lọc Sản Phẩm</title>
</head>
<body>

<h1>Lọc Sản Phẩm Theo Giá</h1>

<form action="ProductServlet" method="get">
    Giá Tối Thiểu: <input type="number" step="0.01" name="minPrice" />
    Giá Tối Đa: <input type="number" step="0.01" name="maxPrice" />
    <button type="submit">Lọc</button>
</form>

<hr/>

<h2>Danh Sách Sản Phẩm</h2>

<c:if test="${empty products}">
    <p>Không có sản phẩm nào trong khoảng giá này.</p>
</c:if>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên Sản Phẩm</th>
        <th>Giá</th>
        <th>Mô Tả</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.productName}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.description}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
