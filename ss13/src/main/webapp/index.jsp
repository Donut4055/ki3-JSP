<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/login">bt1-7</a>
<a href="${pageContext.request.contextPath}/product">bt2</a>
<a href="${pageContext.request.contextPath}/bt3">bt3</a>
<a href="${pageContext.request.contextPath}/cart">bt4</a>
// bài 5 khá giống bài 8 nên e skip :v
<a href="${pageContext.request.contextPath}/register">bt6</a>
<a href="${pageContext.request.contextPath}/order/form">bt8</a>
<a href="${pageContext.request.contextPath}/finance/form">bt9</a>
<a href="${pageContext.request.contextPath}/category">bt10</a>

<%--link vid: https://www.youtube.com/watch?v=ZnZ0P8Q3sWY--%>
</body>
</html>