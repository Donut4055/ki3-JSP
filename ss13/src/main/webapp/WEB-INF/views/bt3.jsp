<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<p><spring:message code="instruction"/></p>
<select id="langSelect">
    <option value="vi" ${pageContext.request.locale.language == 'vi' ? 'selected' : ''}>Tiếng Việt</option>
    <option value="en" ${pageContext.request.locale.language == 'en' ? 'selected' : ''}>English</option>
</select>
<script>
    document.getElementById('langSelect').onchange = function() {
        var selected = this.value;
        var url = window.location.pathname + "?lang=" + selected;
        window.location.href = url;
    };
</script>


