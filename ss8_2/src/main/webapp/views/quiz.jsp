<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Quiz</title>
</head>
<body>
<h1>Quiz Game</h1>

<img src="${question.imageUrl}" alt="Question Image" width="300"><br>
<form action="${pageContext.request.contextPath}/guess" method="post">
  <input type="hidden" name="questionId" value="${question.id}">
  <input type="text" name="answer" placeholder="Your answer" required><br>
  <button type="submit">Đoán</button>
</form>

<p>${message}</p>

<p>Số lần đoán: ${attempts}</p>

<c:if test="${attempts >= 3}">
  <a href="${pageContext.request.contextPath}/quiz">Chơi lại</a>
</c:if>
</body>
</html>

