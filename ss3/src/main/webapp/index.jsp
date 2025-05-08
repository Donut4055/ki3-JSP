<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="${pageContext.request.contextPath}/info.jsp">Bt1</a>
<a href="${pageContext.request.contextPath}/bt2.jsp">Bt2</a>
<a href="${pageContext.request.contextPath}/home.jsp">Bt3</a>
<a href="${pageContext.request.contextPath}/bt4.jsp">Bt4</a>
<a href="${pageContext.request.contextPath}/bt5.jsp">Bt5</a>
<a href="${pageContext.request.contextPath}/bt6.jsp">Bt6</a>
<a href="${pageContext.request.contextPath}/bt7.jsp">Bt7</a>
<a href="${pageContext.request.contextPath}/bt8.jsp">Bt8</a>
<a href="${pageContext.request.contextPath}/input.jsp">Bt9</a>
<a href="${pageContext.request.contextPath}/product.jsp">Bt10</a>
</body>
</html>