<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thông Tin Người Dùng</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .info { margin: 20px; }
        .info p { margin: 5px 0; }
        .label { font-weight: bold; }
    </style>
</head>
<body>
<div class="info">
    <h1>Thông Tin Bạn Vừa Đăng Ký</h1>
    <p><span class="label">Tên:</span> ${userName}</p>
    <p><span class="label">Email:</span> ${userEmail}</p>
    <p><span class="label">Mật khẩu:</span> ${userPass}</p>
    <p><a href="registerBt5">Quay lại đăng ký</a></p>
</div>
</body>
</html>
