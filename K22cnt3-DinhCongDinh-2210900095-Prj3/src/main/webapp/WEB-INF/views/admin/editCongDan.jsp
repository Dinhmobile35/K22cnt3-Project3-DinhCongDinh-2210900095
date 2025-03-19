<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.DCD_CongDan" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa công dân</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        body {
            background: #f4f7fc;
            min-height: 100vh;
            display: flex;
            color: #333;
        }
        .sidebar {
            width: 250px;
            background: #2c3e50;
            color: #fff;
            height: 100vh;
            position: fixed;
            padding-top: 20px;
            box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
        }
        .sidebar h2 {
            text-align: center;
            font-size: 24px;
            margin-bottom: 30px;
            color: #ecf0f1;
        }
        .sidebar ul {
            list-style: none;
        }
        .sidebar ul li {
            margin: 10px 0;
        }
        .sidebar ul li a {
            display: block;
            padding: 15px 20px;
            color: #ecf0f1;
            text-decoration: none;
            font-size: 16px;
            transition: background 0.3s ease;
        }
        .sidebar ul li a:hover {
            background: #34495e;
        }
        .main-content {
            margin-left: 250px;
            padding: 30px;
            width: calc(100% - 250px);
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background: #fff;
            padding: 15px 30px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        .header h1 {
            font-size: 26px;
            color: #2c3e50;
        }
        .logout-btn {
            background: #e74c3c;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            font-size: 14px;
            transition: background 0.3s ease;
        }
        .logout-btn:hover {
            background: #c0392b;
        }
        .form-panel {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: 0 auto;
        }
        .form-panel h3 {
            font-size: 20px;
            margin-bottom: 20px;
            color: #2c3e50;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            font-size: 14px;
            color: #555;
            margin-bottom: 5px;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
        }
        .form-group input[type="submit"] {
            background: #3498db;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        .form-group input[type="submit"]:hover {
            background: #2980b9;
        }
        .error {
            color: #e74c3c;
            font-size: 14px;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="sidebar">
    <h2>Admin Panel</h2>
    <ul>
        <li><a href="<%= request.getContextPath() %>/dashboard">Dashboard</a></li>
        <li><a href="<%= request.getContextPath() %>/manageCongDan">Quản lý công dân</a></li>
        <li><a href="<%= request.getContextPath() %>/manageBHYT">Quản lý bảo hiểm y tế</a></li>
        <li><a href="<%= request.getContextPath() %>/manageGPLX">Quản lý giấy phép lái xe</a></li>
        <li><a href="<%= request.getContextPath() %>/manageYeuCau">Quản lý yêu cầu</a></li>
    </ul>
</div>

<div class="main-content">
    <div class="header">
        <h1>Sửa công dân</h1>
        <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Đăng xuất</a>
    </div>

    <div class="form-panel">
        <h3>Sửa thông tin công dân</h3>
        <%
            DCD_CongDan congDan = (DCD_CongDan) request.getAttribute("congDan");
            if (congDan != null) {
        %>
        <% if (request.getAttribute("error") != null) { %>
        <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>
        <form action="<%= request.getContextPath() %>/manageCongDan" method="post">
            <input type="hidden" name="action" value="update">
            <div class="form-group">
                <label for="cccd">CCCD:</label>
                <input type="text" id="cccd" name="cccd" value="<%= congDan.getDCD_CCCD() %>" readonly>
            </div>
            <div class="form-group">
                <label for="hoTen">Họ tên:</label>
                <input type="text" id="hoTen" name="hoTen" value="<%= congDan.getDCD_HoTen() %>" required>
            </div>
            <div class="form-group">
                <label for="ngaySinh">Ngày sinh:</label>
                <input type="date" id="ngaySinh" name="ngaySinh" value="<%= congDan.getDCD_NgaySinh() %>" required>
            </div>
            <div class="form-group">
                <label for="gioiTinh">Giới tính:</label>
                <select id="gioiTinh" name="gioiTinh" required>
                    <option value="Nam" <%= "Nam".equals(congDan.getDCD_GioiTinh()) ? "selected" : "" %>>Nam</option>
                    <option value="Nu" <%= "Nu".equals(congDan.getDCD_GioiTinh()) ? "selected" : "" %>>Nữ</option>
                </select>
            </div>
            <div class="form-group">
                <label for="trangThai">Trạng thái:</label>
                <select id="trangThai" name="trangThai" required>
                    <option value="HOAT_DONG" <%= "HOAT_DONG".equals(congDan.getDCD_TrangThai()) ? "selected" : "" %>>Hoạt động</option>
                    <option value="KHONG_HOAT_DONG" <%= "KHONG_HOAT_DONG".equals(congDan.getDCD_TrangThai()) ? "selected" : "" %>>Không hoạt động</option>
                </select>
            </div>
            <div class="form-group">
                <label for="vaiTro">Vai trò:</label>
                <select id="vaiTro" name="vaiTro" required>
                    <option value="NGUOI_DUNG" <%= "NGUOI_DUNG".equals(congDan.getDCD_VaiTro()) ? "selected" : "" %>>Người dùng</option>
                    <option value="QUAN_TRI" <%= "QUAN_TRI".equals(congDan.getDCD_VaiTro()) ? "selected" : "" %>>Quản trị</option>
                </select>
            </div>
            <div class="form-group">
                <label for="matKhau">Mật khẩu:</label>
                <input type="password" id="matKhau" name="matKhau" value="<%= congDan.getDCD_MatKhau() %>" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Cập nhật công dân">
            </div>
        </form>
        <% } else { %>
        <div class="error">Không tìm thấy công dân.</div>
        <% } %>
    </div>
</div>
</body>
</html>