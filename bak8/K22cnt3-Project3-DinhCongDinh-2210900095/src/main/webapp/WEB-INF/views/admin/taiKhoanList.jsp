<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý tài khoản</title>
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
        .btn-danger { background-color: #e74c3c; }
        .btn-success { background-color: #2ecc71; }
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
    <h2>Quản lý tài khoản</h2>
    <table>
        <thead>
        <tr>
            <th>Số điện thoại</th>
            <th>CCCD</th>
            <th>Vai trò</th>
            <th>Trạng thái</th>
            <th>Ngày tạo</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="taiKhoan" items="${taiKhoanList}">
            <tr>
                <td><c:out value="${taiKhoan.soDienThoai}" /></td>
                <td><c:out value="${taiKhoan.cccd}" /></td>
                <td><c:out value="${taiKhoan.vaiTro}" /></td>
                <td><c:out value="${taiKhoan.trangThai}" /></td>
                <td><c:out value="${taiKhoan.ngayTao}" /></td>
                <td>
                    <c:choose>
                        <c:when test="${taiKhoan.trangThai == 'HOAT_DONG'}">
                            <a href="${pageContext.request.contextPath}/admin/taikhoan?action=lock&soDienThoai=${taiKhoan.soDienThoai}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn khóa tài khoản này?')">Khóa</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/admin/taikhoan?action=unlock&soDienThoai=${taiKhoan.soDienThoai}" class="btn btn-success" onclick="return confirm('Bạn có chắc chắn muốn mở khóa tài khoản này?')">Mở khóa</a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>