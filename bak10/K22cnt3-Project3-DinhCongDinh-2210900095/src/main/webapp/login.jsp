<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(135deg, #6e8efb, #a777e3); /* Gradient background */
            color: #333;
        }

        .login-container {
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        .login-container h2 {
            margin-bottom: 20px;
            color: #444;
            font-size: 24px;
        }

        .login-container input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
            transition: border-color 0.3s ease;
        }

        .login-container input:focus {
            border-color: #6e8efb;
            outline: none;
            box-shadow: 0 0 5px rgba(110, 142, 251, 0.5);
        }

        .login-container button {
            width: 100%;
            padding: 12px;
            background: #6e8efb;
            border: none;
            border-radius: 5px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        .login-container button:hover {
            background: #5d7ce0;
        }

        .login-container button:active {
            background: #4d6ac8;
        }

        .error {
            color: #e74c3c;
            margin-top: 10px;
            font-size: 14px;
        }

        .success {
            color: #2ecc71;
            margin-top: 10px;
            font-size: 14px;
        }

        .login-container p {
            margin-top: 15px;
            font-size: 14px;
        }

        .login-container a {
            color: #6e8efb;
            text-decoration: none;
        }

        .login-container a:hover {
            text-decoration: underline;
        }

        /* Responsive design */
        @media (max-width: 480px) {
            .login-container {
                padding: 20px;
                margin: 10px;
            }
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Đăng nhập</h2>
    <form method="POST" action="login">
        <input type="text" name="soDienThoai" placeholder="Số điện thoại" required><br>
        <input type="password" name="matKhau" placeholder="Mật khẩu" required><br>
        <button type="submit">Đăng nhập</button>
    </form>
    <p class="error">${errorMessage}</p>
    <p class="success">${successMessage}</p>
    <p>Chưa có tài khoản? <a href="register">Đăng ký</a></p>
</div>
</body>
</html>