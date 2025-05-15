
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Lịch chiếu phim</title></head>
<body>
<h2>Lịch chiếu phim cho phim ID: ${movieId}</h2>
<table border="1" cellpadding="5">
  <thead>
  <tr>
    <th>ID lịch chiếu</th>
    <th>Tiêu đề phim</th>
    <th>Thời gian chiếu</th>
    <th>ID phòng chiếu</th>
    <th>Số ghế trống</th>
    <th>Định dạng</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="schedule" items="${schedules}">
    <tr>
      <td>${schedule.id}</td>
      <td>${schedule.movieTitle}</td>
      <td>"${schedule.showTime}" </td>
      <td>${schedule.screenRoomId}</td>
      <td>${schedule.availableSeats}</td>
      <td>${schedule.format}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>

