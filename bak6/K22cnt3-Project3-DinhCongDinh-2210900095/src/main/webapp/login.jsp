<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; text-align: center; }
        .login-container { max-width: 300px; margin: 0 auto; padding: 20px; border: 1px solid #ccc; }
        .login-container input { width: 100%; margin: 5px 0; padding: 5px; }
        .login-container button { margin-top: 10px; padding: 5px 10px; }
        .error { color: red; }
        .success { color: green; }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Đăng nhập</h2>
    <form method="POST" action="login">
        <input type="text" name="soDienThoai" placeholder="Số điện thoại" required><br>
        <input type="password" name="matKhau" placeholder="Mật khẩu" required><br>
        <button type="submit">Đăng nhập</button>
    </form>
    <p class="error">${errorMessage}</p>
    <p class="success">${successMessage}</p>
    <p>Chưa có tài khoản? <a href="register">Đăng ký</a></p>
</div>
</body>
</html>