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
    <h2>Dashboard</h2>
    <div style="display: flex; gap: 20px;">
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
</div>
</body>
</html>