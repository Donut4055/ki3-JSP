<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thống Kê Doanh Thu</title>
</head>
<body>

<h1>Thống Kê Doanh Thu Theo Tháng</h1>

<table border="1">
    <thead>
    <tr>
        <th>Tháng</th>
        <th>Doanh Thu (VND)</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="revenue" items="${revenues}">
        <tr>
            <td><c:out value="${revenue.month}"/></td>
            <td><c:out value="${revenue.revenue}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<hr/>

<c:set var="totalRevenue" value="0" />
<c:forEach var="revenue" items="${revenues}">
    <c:set var="totalRevenue" value="${totalRevenue + revenue.revenue}" />
</c:forEach>

<h3>Tổng doanh thu: <c:out value="${totalRevenue}"/></h3>

<c:choose>
    <c:when test="${totalRevenue > 10000}">
        <p style="color: green;">Tổng doanh thu vượt quá 10,000 VND. Đây là một kết quả tốt!</p>
    </c:when>
    <c:otherwise>
        <p style="color: red;">Tổng doanh thu chưa đạt 10,000 VND. Cần cải thiện.</p>
    </c:otherwise>
</c:choose>

</body>
</html>
