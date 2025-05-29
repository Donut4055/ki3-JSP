<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Đặt hàng</title></head>
<body>
<h2>Đặt hàng sản phẩm</h2>
<form:form method="POST" action="/order/submit" modelAttribute="order">
    <div>
        <label>Tên người dùng:</label>
        <form:input path="customerName"/>
    </div>
    <div>
        <label>Sản phẩm:</label>
        <form:input path="product"/>
    </div>
    <div>
        <label>Số lượng:</label>
        <form:input path="quantity" type="number"/>
    </div>
    <button type="submit">Đặt hàng</button>
</form:form>
<a href="${pageContext.request.contextPath}/order/view">Xem đơn hàng đã đặt</a>
</body>
</html>

