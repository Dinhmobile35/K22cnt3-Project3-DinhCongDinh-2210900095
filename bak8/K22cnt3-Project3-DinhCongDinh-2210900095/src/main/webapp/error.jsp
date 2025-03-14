<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lỗi Đăng nhập</title>
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
        .error-container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        .error-container h2 {
            color: #d9534f;
        }
        .error-container a {
            display: inline-block;
            margin-top: 10px;
            color: #007BFF;
            text-decoration: none;
        }
        .error-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h2>Lỗi Đăng nhập</h2>
    <p>Số điện thoại hoặc mật khẩu không đúng. Vui lòng thử lại.</p>
    <a href="login.jsp">Quay lại trang đăng nhập</a>
</div>
</body>
</html>