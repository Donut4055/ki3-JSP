
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head><title><spring:message code="finance.list"/></title></head>
<body>
<h2><spring:message code="finance.list"/></h2>
<p><spring:message code="finance.username"/>: ${username}</p>
<a href="${pageContext.request.contextPath}/finance/form"><spring:message code="finance.add"/></a>
<br/>
<a href="${pageContext.request.contextPath}/finance/list?lang=vi">Tiếng Việt</a> |
<a href="${pageContext.request.contextPath}/finance/list?lang=en">English</a>
<br/><br/>
<c:choose>
    <c:when test="${not empty transactions}">
        <table border="1">
            <tr>
                <th>ID</th>
                <th><spring:message code="finance.description"/></th>
                <th><spring:message code="finance.amount"/></th>
                <th><spring:message code="finance.type"/></th>
                <th><spring:message code="finance.action"/></th>
            </tr>
            <c:forEach var="t" items="${transactions}">
                <tr>
                    <td>${t.id}</td>
                    <td>${t.description}</td>
                    <td>${t.amount}</td>
                    <td>
                        <c:choose>
                            <c:when test="${t.type == 'income'}"><spring:message code="finance.income"/></c:when>
                            <c:otherwise><spring:message code="finance.expense"/></c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="/finance/delete/${t.id}"><spring:message code="finance.delete"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p><spring:message code="finance.no.transaction"/></p>
    </c:otherwise>
</c:choose>
</body>
</html>

