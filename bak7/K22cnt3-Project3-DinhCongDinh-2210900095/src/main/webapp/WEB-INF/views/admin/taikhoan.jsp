<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Tài Khoản</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Quản lý Tài Khoản</h2>
    <a href="${pageContext.request.contextPath}/admin/dashboard" class="btn btn-secondary mb-3">Quay lại Dashboard</a>
    <a href="${pageContext.request.contextPath}/admin/taikhoan?action=new" class="btn btn-primary mb-3">Thêm Tài Khoản Mới</a>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Số Điện Thoại</th>
            <th>CCCD</th>
            <th>Mật Khẩu</th>
            <th>Vai Trò</th>
            <th>Trạng Thái</th>
            <th>Ngày Tạo</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="taiKhoan" items="${taiKhoanList}">
            <tr>
                <td>${taiKhoan.soDienThoai}</td>
                <td>${taiKhoan.cccd}</td>
                <td>${taiKhoan.matKhau}</td>
                <td>${taiKhoan.vaiTro}</td>
                <td>${taiKhoan.trangThai}</td>
                <td>${taiKhoan.ngayTao}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/taikhoan?action=edit&soDienThoai=${taiKhoan.soDienThoai}" class="btn btn-warning btn-sm">Sửa</a>
                    <a href="${pageContext.request.contextPath}/admin/taikhoan?action=delete&soDienThoai=${taiKhoan.soDienThoai}" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>