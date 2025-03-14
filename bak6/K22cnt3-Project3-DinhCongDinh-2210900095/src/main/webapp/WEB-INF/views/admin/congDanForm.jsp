<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${congDan == null ? 'Thêm công dân' : 'Sửa công dân'}</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f6f9;
        }
        .sidebar {
            width: 250px;
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            background-color: #2c3e50;
            color: white;
            padding-top: 60px;
        }
        .sidebar a {
            display: block;
            padding: 15px;
            color: white;
            text-decoration: none;
            font-size: 16px;
        }
        .sidebar a:hover, .sidebar a.active {
            background-color: #34495e;
        }
        .content {
            margin-left: 250px;
            padding: 20px;
            min-height: 100vh;
        }
        .navbar {
            background-color: #3498db;
            padding: 10px 20px;
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 1000;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            font-size: 18px;
        }
        .navbar a:hover {
            color: #ecf0f1;
        }
        .form-container {
            max-width: 600px;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input, select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            color: white;
            margin-right: 10px;
        }
        .btn-primary { background-color: #3498db; }
        .btn-secondary { background-color: #7f8c8d; }
        .btn:hover { opacity: 0.9; }
    </style>
</head>
<body>
<!-- Navbar -->
<div class="navbar">
    <a href="${pageContext.request.contextPath}/admin/dashboard">Admin Dashboard</a>
    <a href="${pageContext.request.contextPath}/logout" style="float: right;">Đăng xuất</a>
</div>

<!-- Sidebar -->
<div class="sidebar">
    <a href="${pageContext.request.contextPath}/admin/dashboard" class="${pageContext.request.servletPath.contains('dashboard') ? 'active' : ''}">Dashboard</a>
    <a href="${pageContext.request.contextPath}/admin/congdan" class="${pageContext.request.servletPath.contains('congdan') ? 'active' : ''}">Quản lý công dân</a>
    <a href="${pageContext.request.contextPath}/admin/taikhoan" class="${pageContext.request.servletPath.contains('taikhoan') ? 'active' : ''}">Quản lý tài khoản</a>
</div>

<!-- Content -->
<div class="content">
    <h2>${congDan == null ? 'Thêm công dân' : 'Sửa công dân'}</h2>
    <div class="form-container">
        <form action="${pageContext.request.contextPath}/admin/congdan" method="post">
            <input type="hidden" name="action" value="${congDan == null ? 'insert' : 'update'}">
            <c:if test="${congDan != null}">
                <input type="hidden" name="cccd" value="${congDan.cccd}">
            </c:if>
            <div class="form-group">
                <label for="cccd">CCCD</label>
                <input type="text" id="cccd" name="cccd" value="${congDan.cccd}" ${congDan != null ? 'readonly' : ''} required>
            </div>
            <div class="form-group">
                <label for="hoTen">Họ tên</label>
                <input type="text" id="hoTen" name="hoTen" value="${congDan.hoTen}" required>
            </div>
            <div class="form-group">
                <label for="ngaySinh">Ngày sinh</label>
                <input type="date" id="ngaySinh" name="ngaySinh" value="${congDan.ngaySinh}" required>
            </div>
            <div class="form-group">
                <label for="gioiTinh">Giới tính</label>
                <select id="gioiTinh" name="gioiTinh" required>
                    <option value="Nam" ${congDan.gioiTinh == 'Nam' ? 'selected' : ''}>Nam</option>
                    <option value="Nu" ${congDan.gioiTinh == 'Nu' ? 'selected' : ''}>Nữ</option>
                </select>
            </div>
            <div class="form-group">
                <label for="soDienThoai">Số điện thoại</label>
                <input type="text" id="soDienThoai" name="soDienThoai" value="${congDan.soDienThoai}" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" value="${congDan.email}" required>
            </div>
            <div class="form-group">
                <label for="diaChi">Địa chỉ</label>
                <input type="text" id="diaChi" name="diaChi" value="${congDan.diaChi}" required>
            </div>
            <div class="form-group">
                <label for="ngayCap">Ngày cấp</label>
                <input type="date" id="ngayCap" name="ngayCap" value="${congDan.ngayCap}" required>
            </div>
            <div class="form-group">
                <label for="ngayHetHan">Ngày hết hạn</label>
                <input type="date" id="ngayHetHan" name="ngayHetHan" value="${congDan.ngayHetHan}" required>
            </div>
            <button type="submit" class="btn btn-primary">Lưu</button>
            <a href="${pageContext.request.contextPath}/admin/congdan" class="btn btn-secondary">Hủy</a>
        </form>
    </div>
</div>
</body>
</html>