<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<jsp:include page="header.jsp" flush="true"/>
<br/>
<a href="${pageContext.request.contextPath}/productList">Bt1</a>
<a href="${pageContext.request.contextPath}/bt2.jsp">Bt2</a>
<a href="${pageContext.request.contextPath}/bt4.jsp">Bt4</a>
<a href="${pageContext.request.contextPath}/bt5.jsp">Bt5</a>
<a href="${pageContext.request.contextPath}/students">Bt6</a>
<a href="${pageContext.request.contextPath}/ProductServlet">Bt7</a>
<a href="${pageContext.request.contextPath}/RevenueServlet">Bt8</a>
<a href="${pageContext.request.contextPath}/seats">Bt9</a>


</body>
</html>