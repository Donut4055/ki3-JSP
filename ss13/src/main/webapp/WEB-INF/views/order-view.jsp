<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Đơn hàng của bạn</title></head>
<body>
<c:choose>
  <c:when test="${order != null}">
    <h2>Thông tin đơn hàng:</h2>
    <ul>
      <li>Tên người dùng: ${order.customerName}</li>
      <li>Sản phẩm: ${order.product}</li>
      <li>Số lượng: ${order.quantity}</li>
    </ul>
  </c:when>
  <c:otherwise>
    <h2>${message}</h2>
  </c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath}/order/form">Đặt hàng mới</a>
</body>
</html>

