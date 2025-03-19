<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm GPLX</title>
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
        <h1>Thêm GPLX</h1>
        <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Đăng xuất</a>
    </div>

    <div class="form-panel">
        <h3>Thêm giấy phép lái xe mới</h3>
        <% if (request.getAttribute("error") != null) { %>
        <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>
        <form action="<%= request.getContextPath() %>/manageGPLX" method="post">
            <input type="hidden" name="action" value="create">
            <div class="form-group">
                <label for="soGPLX">Số GPLX:</label>
                <input type="text" id="soGPLX" name="soGPLX" required>
            </div>
            <div class="form-group">
                <label for="cccd">CCCD:</label>
                <input type="text" id="cccd" name="cccd" required>
            </div>
            <div class="form-group">
                <label for="hangGPLX">Hạng GPLX:</label>
                <select id="hangGPLX" name="hangGPLX" required>
                    <option value="A1">A1</option>
                    <option value="A2">A2</option>
                    <option value="B1">B1</option>
                    <option value="B2">B2</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                    <option value="E">E</option>
                    <option value="F">F</option>
                </select>
            </div>
            <div class="form-group">
                <label for="ngayCap">Ngày cấp:</label>
                <input type="date" id="ngayCap" name="ngayCap" required>
            </div>
            <div class="form-group">
                <label for="ngayHetHan">Ngày hết hạn:</label>
                <input type="date" id="ngayHetHan" name="ngayHetHan">
            </div>
            <div class="form-group">
                <label for="noiCap">Nơi cấp:</label>
                <input type="text" id="noiCap" name="noiCap" required>
            </div>
            <div class="form-group">
                <label for="trangThai">Trạng thái:</label>
                <select id="trangThai" name="trangThai" required>
                    <option value="HOAT_DONG">Hoạt động</option>
                    <option value="HET_HAN">Hết hạn</option>
                    <option value="BI_THU_HOI">Bị thu hồi</option>
                </select>
            </div>
            <div class="form-group">
                <input type="submit" value="Thêm GPLX">
            </div>
        </form>
    </div>
</div>
</body>
</html>