<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Đăng ký</h2>
    <form action="register" method="post">
        <input type="text" name="cccd" placeholder="CCCD" required><br>
        <input type="text" name="hoTen" placeholder="Họ tên" required><br>
        <input type="date" name="ngaySinh" required><br>
        <select name="gioiTinh" required>
            <option value="NAM">Nam</option>
            <option value="NỮ">Nữ</option>
            <option value="KHÁC">Khác</option>
        </select><br>
        <input type="text" name="soDienThoai" placeholder="Số điện thoại" required><br>
        <input type="email" name="email" placeholder="Email" required><br>
        <input type="text" name="diaChi" placeholder="Địa chỉ" required><br>
        <input type="date" name="ngayCap" required><br>
        <input type="date" name="ngayHetHan" required><br>
        <input type="password" name="matKhau" placeholder="Mật khẩu" required><br>
        <button type="submit">Đăng ký</button>
    </form>
    <p class="error">${error}</p>
</div>
</body>
</html>