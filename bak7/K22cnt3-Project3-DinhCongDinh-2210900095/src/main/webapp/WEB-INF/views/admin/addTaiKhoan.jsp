<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Tài Khoản</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Thêm Tài Khoản Mới</h2>
    <form action="admin/taikhoan?action=add" method="post">
        <div class="form-group">
            <label>Số Điện Thoại:</label>
            <input type="text" name="soDienThoai" class="form-control" required>
        </div>
        <div class="form-group">
            <label>CCCD:</label>
            <input type="text" name="cccd" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Mật Khẩu:</label>
            <input type="password" name="matKhau" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Vai Trò:</label>
            <select name="vaiTro" class="form-control" required>
                <option value="NGUOI_DUNG">Người Dùng</option>
                <option value="QUAN_TRI">Quản Trị</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
        <a href="admin/taikhoan?action=list" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>