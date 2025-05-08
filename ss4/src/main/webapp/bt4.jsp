<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  // Nếu chưa có attribute products thì khởi tạo
  if (request.getAttribute("products") == null) {
    List<Map<String,Object>> products = new ArrayList<>();

    Map<String,Object> p1 = new HashMap<>();
    p1.put("id", 1);
    p1.put("productName", "Sản phẩm 01");
    p1.put("price", null);
    p1.put("description", "Mô tả sp 01");
    products.add(p1);

    Map<String,Object> p2 = new HashMap<>();
    p2.put("id", 2);
    p2.put("productName", "Sản phẩm 02");
    p2.put("price", 3000.0);
    p2.put("description", "Mô tả sp 02");
    products.add(p2);

    Map<String,Object> p3 = new HashMap<>();
    p3.put("id", 3);
    p3.put("productName", "Sản phẩm 03");
    p3.put("price", 5000.0);
    p3.put("description", "Mô tả sp 03");
    products.add(p3);

    request.setAttribute("products", products);
  }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Danh sách sản phẩm</title>
  <style>
    body { font-family: Arial; padding: 20px; }
    table { border-collapse: collapse; width: 80%; margin: auto; }
    th, td { border: 1px solid #666; padding: 8px; text-align: left; }
    th { background: #eee; }
    .no-info { text-align: center; color: #c00; margin-top: 20px; }
    h1 { text-align: center; }
  </style>
</head>
<body>

<h1>Danh sách sản phẩm</h1>

<c:choose>
  <c:when test="${not empty products}">
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Description</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="p" items="${products}">
        <tr>
          <td><c:out value="${p.id}"/></td>
          <td><c:out value="${p.productName}"/></td>
          <td>
            <c:choose>
              <c:when test="${p.price == null}">
                sản phẩm này chưa có thông tin giá
              </c:when>
              <c:otherwise>
                <c:out value="${p.price}"/>
              </c:otherwise>
            </c:choose>
          </td>
          <td><c:out value="${p.description}"/></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:when>

  <c:otherwise>
    <div class="no-info">Sản phẩm không có thông tin.</div>
  </c:otherwise>
</c:choose>

</body>
</html>
