<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background: linear-gradient(120deg, #74ebd5 0%, #acb6e5 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .container {
            background: rgba(255, 255, 255, 0.95);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 450px;
            backdrop-filter: blur(5px);
            animation: fadeIn 0.5s ease-in-out;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 25px;
            font-size: 28px;
            font-weight: 700;
            letter-spacing: 1px;
        }

        .error {
            color: #e74c3c;
            text-align: center;
            margin-bottom: 20px;
            font-size: 14px;
            background: #fceae9;
            padding: 8px;
            border-radius: 5px;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        label {
            color: #34495e;
            font-size: 14px;
            font-weight: 600;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="password"],
        input[type="date"],
        select {
            padding: 12px 15px;
            border: 2px solid #ecf0f1;
            border-radius: 8px;
            font-size: 15px;
            width: 100%;
            transition: all 0.3s ease;
            background: #f9f9f9;
        }

        input[type="text"]:focus,
        input[type="password"]:focus,
        input[type="date"]:focus,
        select:focus {
            border-color: #1abc9c;
            box-shadow: 0 0 8px rgba(26, 188, 156, 0.3);
            outline: none;
            background: #fff;
        }

        input[type="submit"] {
            background: linear-gradient(90deg, #1abc9c, #16a085);
            color: #fff;
            padding: 14px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        input[type="submit"]:hover {
            background: linear-gradient(90deg, #16a085, #1abc9c);
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(26, 188, 156, 0.4);
        }

        .note {
            font-size: 12px;
            color: #7f8c8d;
            text-align: center;
            margin-top: 20px;
        }

        a {
            color: #1abc9c;
            text-decoration: none;
            font-weight: 600;
        }

        a:hover {
            text-decoration: underline;
        }

        @media (max-width: 480px) {
            .container {
                padding: 20px;
                max-width: 90%;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Tạo tài khoản mới</h2>
    <% if (request.getAttribute("error") != null) { %>
    <p class="error"><%= request.getAttribute("error") %></p>
    <% } %>
    <form action="register" method="post">
        <label>Họ và tên:</label>
        <input type="text" name="hoTen" required>
        <label>CCCD:</label>
        <input type="text" name="cccd" required>
        <label>Ngày sinh:</label>
        <input type="date" name="ngaySinh" required>
        <label>Giới tính:</label>
        <select name="gioiTinh" required>
            <option value="">Chọn giới tính</option>
            <option value="NAM">Nam</option>
            <option value="NỮ">Nữ</option>
            <option value="KHÁC">Khác</option>
        </select>
        <label>Địa chỉ:</label>
        <input type="text" name="diaChi" required>
        <label>Ngày cấp CCCD:</label>
        <input type="date" name="ngayCap" required>
        <label>Mật khẩu:</label>
        <input type="password" name="password" required>
        <input type="submit" value="Đăng ký">
    </form>
    <p class="note">Đã có tài khoản? <a href="login.jsp">Đăng nhập</a></p>
</div>
</body>
</html>