<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; text-align: center; }
        .register-container { max-width: 300px; margin: 0 auto; padding: 20px; border: 1px solid #ccc; }
        .register-container input { width: 100%; margin: 5px 0; padding: 5px; }
        .register-container button { margin-top: 10px; padding: 5px 10px; }
        .error { color: red; }
        .success { color: green; }
    </style>
</head>
<body>
<div class="register-container">
    <h2>Đăng ký</h2>
    <form method="POST" action="register">
        <input type="text" name="soDienThoai" placeholder="Số điện thoại" required><br>
        <input type="text" name="cccd" placeholder="CCCD" required><br>
        <input type="password" name="matKhau" placeholder="Mật khẩu" required><br>
        <select name="vaiTro" required>
            <option value="QUAN_TRI">Quản trị</option>
            <option value="NGUOI_DUNG" selected>Người dùng</option>
        </select><br>
        <button type="submit">Đăng ký</button>
    </form>
    <p class="error">${errorMessage}</p>
    <p class="success">${successMessage}</p>
    <p>Đã có tài khoản? <a href="login">Đăng nhập</a></p>
</div>
</body>
</html>