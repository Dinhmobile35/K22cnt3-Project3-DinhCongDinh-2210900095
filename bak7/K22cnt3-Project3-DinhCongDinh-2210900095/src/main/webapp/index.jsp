<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chào mừng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
        }
        .welcome-container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .welcome-container a {
            display: inline-block;
            margin: 10px;
            color: #007BFF;
            text-decoration: none;
        }
        .welcome-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="welcome-container">
    <h2>Chào mừng đến với hệ thống quản lý công dân</h2>
    <p>Vui lòng chọn vai trò:</p>
    <a href="admin/congdan">Đăng nhập với tư cách Quản trị viên</a>
    <a href="user/congdan">Đăng nhập với tư cách Người dùng</a>
</div>
</body>
</html>