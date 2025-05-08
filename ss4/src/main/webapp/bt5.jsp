<%@ page import="com.example.ss4.bt1.Product" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    Product found = null;
    String idParam = request.getParameter("id");
    if (idParam != null && !idParam.isEmpty()) {
        try {
            int searchId = Integer.parseInt(idParam);
            for (Product p : products) {
                if (p.getId() == searchId) {
                    found = p;
                    break;
                }
            }
        } catch (NumberFormatException ignored) { }
    }
    request.setAttribute("foundProduct", found);
%>
<!DOCTYPE html><html><head><meta charset="utf-8"/><title>Search</title></head><body>
<h1>Tìm sản phẩm theo ID</h1>
<form action="${pageContext.request.contextPath}/Bt5" method="get">
    ID: <input name="id" value="${param.id}" />
    <button>Tìm</button>
</form>

<c:choose>
    <c:when test="${not empty foundProduct}">
        <h2>Thông tin sản phẩm</h2>
        <table border="1">
            <tr><th>ID</th><td>${foundProduct.id}</td></tr>
            <tr><th>Name</th><td>${foundProduct.productName}</td></tr>
            <tr><th>Price</th><td>${foundProduct.price}</td></tr>
            <tr><th>Description</th><td>${foundProduct.description}</td></tr>
        </table>
    </c:when>
    <c:otherwise>
        <c:if test="${not empty param.id}">
            <p style="color:red;">Sản phẩm không tìm thấy.</p>
        </c:if>
        <c:if test="${empty param.id}">
            <p style="color:red;">Sản phẩm không tìm thấy.</p>
        </c:if>
    </c:otherwise>
</c:choose>
</body></html>
