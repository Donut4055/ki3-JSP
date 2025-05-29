<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Quản lý sản phẩm với Cookie</title></head>
<body>
<h2>Thêm sản phẩm mới</h2>
<form:form method="POST" action="/product/add" modelAttribute="product">
    <div>
        <label>Mã sản phẩm:</label>
        <form:input path="code"/>
    </div>
    <div>
        <label>Tên sản phẩm:</label>
        <form:input path="name"/>
    </div>
    <div>
        <label>Giá:</label>
        <form:input path="price" type="number"/>
    </div>
    <button type="submit">Thêm</button>
</form:form>

<h2>Danh sách sản phẩm đã thêm</h2>
<table border="1">
    <tr>
        <th>Mã</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Xóa</th>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.code}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>
                <a href="/product/delete/${p.code}" onclick="return confirm('Bạn chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

