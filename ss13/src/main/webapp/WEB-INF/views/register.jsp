
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head><title><spring:message code="register.title"/></title></head>
<body>
<h2><spring:message code="register.title"/></h2>
<c:if test="${not empty success}">
  <div style="color:green">${success}</div>
</c:if>
<form:form method="POST" action="/register" modelAttribute="userRegisterDto">
  <div>
    <label><spring:message code="register.username"/>:</label>
    <form:input path="username"/>
    <form:errors path="username" cssClass="error"/>
  </div>
  <div>
    <label><spring:message code="register.password"/>:</label>
    <form:password path="password"/>
    <form:errors path="password" cssClass="error"/>
  </div>
  <div>
    <label><spring:message code="register.confirmPassword"/>:</label>
    <form:password path="confirmPassword"/>
    <form:errors path="confirmPassword" cssClass="error"/>
  </div>
  <div>
    <label><spring:message code="register.email"/>:</label>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>
  </div>
  <button type="submit"><spring:message code="register.submit"/></button>
</form:form>
</body>
</html>

