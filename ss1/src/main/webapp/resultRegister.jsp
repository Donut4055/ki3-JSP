<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Kết quả đăng ký</title>
    <style>
        body { font-family: Arial; padding: 20px; }
        .info { margin: 10px 0; }
        .label { font-weight: bold; }
    </style>
</head>
<body>
<h2>Đăng ký vé xe thành công!</h2>
<div class="info">
    <span class="label">Họ và tên:</span> ${requestScope.fullName}
</div>
<div class="info">
    <span class="label">Lớp:</span> ${requestScope.className}
</div>
<div class="info">
    <span class="label">Loại xe:</span> ${requestScope.vehicleType}
</div>
<div class="info">
    <span class="label">Biển số xe:</span> ${requestScope.plateNumber}
</div>

<p><a href="index.jsp">Quay lại</a></p>
</body>
</html>
