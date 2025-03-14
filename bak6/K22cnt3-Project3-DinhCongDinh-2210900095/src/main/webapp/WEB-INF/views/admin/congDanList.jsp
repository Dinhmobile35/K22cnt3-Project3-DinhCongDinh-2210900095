<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý công dân</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #3498db;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f8f9fa;
        }
        tr:hover {
            background-color: #e9ecef;
        }
        .btn {
            padding: 5px 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            color: white;
            margin-right: 5px;
        }
        .btn-primary { background-color: #3498db; }
        .btn-warning { background-color: #f1c40f; }
        .btn-danger { background-color: #e74c3c; }
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
    <h2>Quản lý công dân</h2>
    <a href="${pageContext.request.contextPath}/admin/congdan?action=new" class="btn btn-primary">Thêm công dân</a>
    <table>
        <thead>
        <tr>
            <th>CCCD</th>
            <th>Họ tên</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>Số điện thoại</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>Ngày cấp</th>
            <th>Ngày hết hạn</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="congDan" items="${congDanList}">
            <tr>
                <td><c:out value="${congDan.cccd}" /></td>
                <td><c:out value="${congDan.hoTen}" /></td>
                <td><c:out value="${congDan.ngaySinh}" /></td>
                <td><c:out value="${congDan.gioiTinh}" /></td>
                <td><c:out value="${congDan.soDienThoai}" /></td>
                <td><c:out value="${congDan.email}" /></td>
                <td><c:out value="${congDan.diaChi}" /></td>
                <td><c:out value="${congDan.ngayCap}" /></td>
                <td><c:out value="${congDan.ngayHetHan}" /></td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/congdan?action=edit&cccd=${congDan.cccd}" class="btn btn-warning">Sửa</a>
                    <a href="${pageContext.request.contextPath}/admin/congdan?action=delete&cccd=${congDan.cccd}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>