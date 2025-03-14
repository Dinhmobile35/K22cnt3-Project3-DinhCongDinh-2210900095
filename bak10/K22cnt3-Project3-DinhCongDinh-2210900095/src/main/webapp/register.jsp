<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký Admin</title>
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

        .register-container {
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        .register-container h2 {
            margin-bottom: 20px;
            color: #444;
            font-size: 24px;
        }

        .register-container input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
            transition: border-color 0.3s ease;
        }

        .register-container input:focus {
            border-color: #6e8efb;
            outline: none;
            box-shadow: 0 0 5px rgba(110, 142, 251, 0.5);
        }

        .register-container button {
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

        .register-container button:hover {
            background: #5d7ce0;
        }

        .register-container button:active {
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

        .register-container p {
            margin-top: 15px;
            font-size: 14px;
        }

        .register-container a {
            color: #6e8efb;
            text-decoration: none;
        }

        .register-container a:hover {
            text-decoration: underline;
        }

        /* Responsive design */
        @media (max-width: 480px) {
            .register-container {
                padding: 20px;
                margin: 10px;
            }
        }
    </style>
</head>
<body>
<div class="register-container">
    <h2>Đăng ký</h2>
    <form method="POST" action="adminRegister"> <!-- Đảm bảo action khớp với controller -->
        <input type="text" name="soDienThoai" placeholder="Số điện thoại" required><br>
        <input type="password" name="matKhau" placeholder="Mật khẩu" required><br>
        <button type="submit">Đăng ký</button>
    </form>
    <p class="error">${errorMessage}</p>
    <p class="success">${successMessage}</p>
    <p>Đã có tài khoản? <a href="adminLogin">Đăng nhập</a></p> <!-- Điều chỉnh đường dẫn nếu cần -->
</div>
</body>
</html>