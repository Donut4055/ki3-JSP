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
<a href="${pageContext.request.contextPath}/books">Bt1-2</a>
<a href="${pageContext.request.contextPath}/product">Bt3</a>
<a href="${pageContext.request.contextPath}/employee">Bt4</a>
<a href="${pageContext.request.contextPath}/PlayMiniGameServlet">Bt5</a>
</body>
</html>