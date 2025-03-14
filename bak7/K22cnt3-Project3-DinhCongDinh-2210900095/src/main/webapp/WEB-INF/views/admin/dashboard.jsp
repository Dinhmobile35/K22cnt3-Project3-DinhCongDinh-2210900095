<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
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
        .card {
            background-color: white;
            border-radius: 8px;
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            text-align: center;
        }
        .card.blue { background-color: #3498db; color: white; }
        .card.green { background-color: #2ecc71; color: white; }
        .card.yellow { background-color: #f1c40f; color: white; }
        .card.red { background-color: #e74c3c; color: white; }
        .card-container {
            display: flex;
            gap: 20px;
            flex-wrap: wrap;
        }
        .section-title {
            margin-top: 20px;
            font-size: 24px;
            color: #2c3e50;
        }
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
    <a href="${pageContext.request.contextPath}/admin/dashboard" class="${pageContext.request.servletPath.contains('dashboard') && empty param.action ? 'active' : ''}">Dashboard</a>
    <a href="${pageContext.request.contextPath}/admin/congdan" class="${pageContext.request.servletPath.contains('congdan') ? 'active' : ''}">Quản lý công dân</a>
    <a href="${pageContext.request.contextPath}/admin/taikhoan" class="${pageContext.request.servletPath.contains('taikhoan') ? 'active' : ''}">Quản lý tài khoản</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard?action=capLaiList" class="${param.action == 'capLaiList' ? 'active' : ''}">Yêu cầu cấp lại CCCD</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard?action=chinhSuaList" class="${param.action == 'chinhSuaList' ? 'active' : ''}">Yêu cầu chỉnh sửa</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard?action=doiMatKhauList" class="${param.action == 'doiMatKhauList' ? 'active' : ''}">Yêu cầu đổi mật khẩu</a>
</div>

<!-- Content -->
<div class="content">
    <h2>Dashboard</h2>

    <!-- Tổng quan -->
    <div class="section-title">Tổng quan</div>
    <div class="card-container">
        <div class="card blue" style="flex: 1;">
            <h5>Tổng số công dân</h5>
            <p>${totalCongDan}</p>
        </div>
        <div class="card green" style="flex: 1;">
            <h5>Tổng số tài khoản</h5>
            <p>${totalTaiKhoan}</p>
        </div>
        <div class="card yellow" style="flex: 1;">
            <h5>Tài khoản bị khóa</h5>
            <p>${lockedTaiKhoan}</p>
        </div>
    </div>

    <!-- Yêu cầu cấp lại CCCD -->
    <div class="section-title">Yêu cầu cấp lại CCCD</div>
    <div class="card-container">
        <div class="card blue" style="flex: 1;">
            <h5>Chờ duyệt</h5>
            <p>${capLaiChoDuyet}</p>
        </div>
        <div class="card green" style="flex: 1;">
            <h5>Đã duyệt</h5>
            <p>${capLaiDaDuyet}</p>
        </div>
        <div class="card red" style="flex: 1;">
            <h5>Từ chối</h5>
            <p>${capLaiTuChoi}</p>
        </div>
        <div class="card yellow" style="flex: 1;">
            <h5>Chưa giao</h5>
            <p>${capLaiChuaGiao}</p>
        </div>
        <div class="card green" style="flex: 1;">
            <h5>Đang giao</h5>
            <p>${capLaiDangGiao}</p>
        </div>
        <div class="card blue" style="flex: 1;">
            <h5>Đã nhận</h5>
            <p>${capLaiDaNhan}</p>
        </div>
    </div>

    <!-- Yêu cầu chỉnh sửa thông tin -->
    <div class="section-title">Yêu cầu chỉnh sửa thông tin</div>
    <div class="card-container">
        <div class="card blue" style="flex: 1;">
            <h5>Chờ duyệt</h5>
            <p>${chinhSuaChoDuyet}</p>
        </div>
        <div class="card green" style="flex: 1;">
            <h5>Đã duyệt</h5>
            <p>${chinhSuaDaDuyet}</p>
        </div>
        <div class="card red" style="flex: 1;">
            <h5>Từ chối</h5>
            <p>${chinhSuaTuChoi}</p>
        </div>
    </div>

    <!-- Yêu cầu đổi mật khẩu -->
    <div class="section-title">Yêu cầu đổi mật khẩu</div>
    <div class="card-container">
        <div class="card blue" style="flex: 1;">
            <h5>Chờ duyệt</h5>
            <p>${doiMatKhauChoDuyet}</p>
        </div>
        <div class="card green" style="flex: 1;">
            <h5>Hoàn thành</h5>
            <p>${doiMatKhauHoanThanh}</p>
        </div>
    </div>
</div>
</body>
</html>