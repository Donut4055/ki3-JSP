<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Đăng nhập</title></head>
<body>
<h2>Đăng nhập</h2>
<form:form method="POST" action="/login" modelAttribute="user">
    <div>
        <label>Tên người dùng:</label>
        <form:input path="username"/>
    </div>
    <div>
        <label>Mật khẩu:</label>
        <form:password path="password"/>
    </div>
    <div>
        <label>
            <input type="checkbox" name="rememberMe"
                   <c:if test="${not empty user.username and not empty user.password}">checked</c:if>
            /> Ghi nhớ tôi
        </label>
    </div>
    <div style="color:red">${error}</div>
    <button type="submit">Đăng nhập</button>
</form:form>
</body>
</html>
