<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gửi yêu cầu cấp lại</title>
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
        .form-group select, .form-group input, .form-group textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
        }
        .form-group textarea {
            height: 100px;
            resize: vertical;
        }
        .form-group input[type="submit"] {
            background: #3498db;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
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
    <h2>User Panel</h2>
    <ul>
        <li><a href="<%= request.getContextPath() %>/userInfo">Xem thông tin cá nhân</a></li>
        <li><a href="<%= request.getContextPath() %>/yeucauCapLai">Gửi yêu cầu cấp lại</a></li>
        <li><a href="<%= request.getContextPath() %>/viewYeuCau">Xem danh sách yêu cầu</a></li>
    </ul>
</div>

<div class="main-content">
    <div class="header">
        <h1>Gửi yêu cầu cấp lại</h1>
        <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Đăng xuất</a>
    </div>

    <div class="form-panel">
        <h3>Gửi yêu cầu cấp lại CCCD</h3>
        <% if (request.getAttribute("error") != null) { %>
        <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>
        <form action="<%= request.getContextPath() %>/yeucauCapLai" method="post">
            <div class="form-group">
                <label for="loaiYeuCau">Loại yêu cầu:</label>
                <select id="loaiYeuCau" name="loaiYeuCau" required>
                    <option value="MOI">Mới</option>
                    <option value="CAP_LAI">Cấp lại</option>
                    <option value="MAT">Mất</option>
                </select>
            </div>
            <div class="form-group">
                <label for="tenNguoiNhan">Tên người nhận:</label>
                <input type="text" id="tenNguoiNhan" name="tenNguoiNhan" required>
            </div>
            <div class="form-group">
                <label for="soDienThoaiNhan">Số điện thoại nhận:</label>
                <input type="text" id="soDienThoaiNhan" name="soDienThoaiNhan" required>
            </div>
            <div class="form-group">
                <label for="diaChiNhan">Địa chỉ nhận:</label>
                <textarea id="diaChiNhan" name="diaChiNhan" required></textarea>
            </div>
            <div class="form-group">
                <input type="submit" value="Gửi yêu cầu">
            </div>
        </form>
    </div>
</div>
</body>
</html>