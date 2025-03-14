<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh Sửa Tài Khoản</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Chỉnh Sửa Tài Khoản</h2>
    <form action="admin/taikhoan?action=update" method="post">
        <input type="hidden" name="soDienThoai" value="${taiKhoan.soDienThoai}">
        <div class="form-group">
            <label>CCCD:</label>
            <input type="text" name="cccd" class="form-control" value="${taiKhoan.cccd}" required>
        </div>
        <div class="form-group">
            <label>Mật Khẩu:</label>
            <input type="password" name="matKhau" class="form-control" value="${taiKhoan.matKhau}" required>
        </div>
        <div class="form-group">
            <label>Vai Trò:</label>
            <select name="vaiTro" class="form-control" required>
                <option value="NGUOI_DUNG" ${taiKhoan.vaiTro == 'NGUOI_DUNG' ? 'selected' : ''}>Người Dùng</option>
                <option value="QUAN_TRI" ${taiKhoan.vaiTro == 'QUAN_TRI' ? 'selected' : ''}>Quản Trị</option>
            </select>
        </div>
        <div class="form-group">
            <label>Trạng Thái:</label>
            <select name="trangThai" class="form-control" required>
                <option value="HOAT_DONG" ${taiKhoan.trangThai == 'HOAT_DONG' ? 'selected' : ''}>Hoạt động</option>
                <option value="KHONG_HOAT_DONG" ${taiKhoan.trangThai == 'KHONG_HOAT_DONG' ? 'selected' : ''}>Không hoạt động</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật</button>
        <a href="admin/taikhoan?action=list" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>