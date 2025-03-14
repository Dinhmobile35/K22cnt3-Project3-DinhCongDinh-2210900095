<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${empty taiKhoan ? 'Thêm Tài Khoản' : 'Sửa Thông Tin Tài Khoản'}</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>${empty taiKhoan ? 'Thêm Tài Khoản' : 'Sửa Thông Tin Tài Khoản'}</h2>
    <a href="${pageContext.request.contextPath}/admin/taikhoan" class="btn btn-secondary mb-3">Quay lại</a>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/admin/taikhoan" method="post">
        <input type="hidden" name="action" value="${empty taiKhoan ? 'insert' : 'update'}">
        <c:if test="${not empty taiKhoan}">
            <input type="hidden" name="soDienThoai" value="${taiKhoan.soDienThoai}">
        </c:if>

        <div class="form-group">
            <label for="soDienThoai">Số Điện Thoại:</label>
            <input type="text" id="soDienThoai" name="soDienThoai" class="form-control" value="${taiKhoan.soDienThoai}" ${empty taiKhoan ? '' : 'readonly'} required>
        </div>
        <div class="form-group">
            <label for="cccd">CCCD:</label>
            <input type="text" id="cccd" name="cccd" class="form-control" value="${taiKhoan.cccd}" required>
        </div>
        <div class="form-group">
            <label for="matKhau">Mật Khẩu:</label>
            <input type="password" id="matKhau" name="matKhau" class="form-control" value="${taiKhoan.matKhau}" required>
        </div>
        <div class="form-group">
            <label for="vaiTro">Vai Trò:</label>
            <select id="vaiTro" name="vaiTro" class="form-control" required>
                <option value="QUAN_TRI" ${taiKhoan.vaiTro == 'QUAN_TRI' ? 'selected' : ''}>Quản trị</option>
                <option value="NGUOI_DUNG" ${taiKhoan.vaiTro == 'NGUOI_DUNG' ? 'selected' : ''}>Người dùng</option>
            </select>
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng Thái:</label>
            <select id="trangThai" name="trangThai" class="form-control" required>
                <option value="HOAT_DONG" ${taiKhoan.trangThai == 'HOAT_DONG' ? 'selected' : ''}>Hoạt động</option>
                <option value="KHOA" ${taiKhoan.trangThai == 'KHOA' ? 'selected' : ''}>Khóa</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">${empty taiKhoan ? 'Thêm' : 'Cập nhật'}</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>