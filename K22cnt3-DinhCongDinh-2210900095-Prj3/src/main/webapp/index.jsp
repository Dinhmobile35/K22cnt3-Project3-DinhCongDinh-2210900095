<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
        }
        body {
            background: #f0f2f5;
            color: #1c1e21;
            line-height: 1.34;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px 0;
            flex-wrap: wrap;
            max-width: 980px;
            margin: 0 auto;
        }
        .left-section {
            max-width: 500px;
            padding: 20px 0 20px 20px;
            text-align: left;
            width: 50%;
        }
        .left-section h1 {
            color: #1877f2;
            font-size: 60px;
            font-weight: 900;
            margin-bottom: 20px;
            line-height: 1;
        }
        .left-section p {
            font-size: 28px;
            line-height: 32px;
            color: #1c1e21;
        }
        .right-section {
            max-width: 396px;
            width: 100%;
            padding: 20px;
            text-align: center;
        }
        .login-form {
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1), 0 8px 16px rgba(0, 0, 0, 0.1);
            padding: 20px 20px 28px;
        }
        .login-form input[type="text"],
        .login-form input[type="password"] {
            width: 100%;
            padding: 14px 16px;
            margin: 6px 0;
            border: 1px solid #dddfe2;
            border-radius: 6px;
            font-size: 17px;
            color: #1d2129;
        }
        .login-form input[type="text"]::placeholder,
        .login-form input[type="password"]::placeholder {
            color: #606770;
        }
        .login-form input[type="submit"] {
            background: #1877f2;
            color: #fff;
            border: none;
            border-radius: 6px;
            padding: 0 16px;
            height: 48px;
            width: 100%;
            font-size: 20px;
            font-weight: 600;
            cursor: pointer;
            margin: 10px 0;
            line-height: 48px;
        }
        .login-form input[type="submit"]:hover {
            background: #166fe5;
        }
        .forgot-password {
            color: #1877f2;
            font-size: 14px;
            text-decoration: none;
            display: block;
            margin: 16px 0;
            font-weight: 500;
        }
        .forgot-password:hover {
            text-decoration: underline;
        }
        .divider {
            border-top: 1px solid #dadde1;
            margin: 20px 16px;
        }
        .create-account {
            background: #42b72a;
            color: #fff;
            border: none;
            border-radius: 6px;
            padding: 0 16px;
            height: 48px;
            font-size: 17px;
            font-weight: 600;
            cursor: pointer;
            display: inline-block;
            line-height: 48px;
            text-decoration: none;
        }
        .create-account:hover {
            background: #36a420;
        }
        .error {
            color: #e74c3c;
            font-size: 14px;
            margin-bottom: 10px;
        }
        footer {
            background: #fff;
            padding: 20px 0;
            text-align: center;
            font-size: 12px;
            color: #8a8d91;
            width: 100%;
        }
        footer a {
            color: #8a8d91;
            text-decoration: none;
            margin: 0 5px;
        }
        footer a:hover {
            text-decoration: underline;
        }
        @media (max-width: 900px) {
            .container {
                flex-direction: column;
                padding: 0;
            }
            .left-section {
                width: 100%;
                text-align: center;
                padding: 20px;
                margin-bottom: 20px;
            }
            .left-section h1 {
                font-size: 40px;
            }
            .left-section p {
                font-size: 20px;
                line-height: 24px;
            }
            .right-section {
                max-width: 100%;
                padding: 0 20px;
            }
            .login-form {
                padding: 16px;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="left-section">
        <h1>Facebook</h1>
        <p>Kết nối với bạn bè và thế giới xung quanh bạn trên Facebook.</p>
    </div>
    <div class="right-section">
        <div class="login-form">
            <% if (request.getAttribute("error") != null) { %>
            <div class="error"><%= request.getAttribute("error") %></div>
            <% } %>
            <form action="<%= request.getContextPath() %>/login" method="post">
                <input type="text" name="cccd" placeholder="Số CCCD" required>
                <input type="password" name="password" placeholder="Mật khẩu" required>
                <input type="submit" value="Đăng nhập">
                <a href="forgotPassword.jsp" class="forgot-password">Quên mật khẩu?</a>
                <div class="divider"></div>
                <a href="register.jsp" class="create-account">Tạo tài khoản mới</a>
            </form>
        </div>
    </div>
</div>
<footer>
    <p> &bull; <a href="#">Ngôn ngữ</a> &bull; <a href="#">Điều khoản</a> &bull; <a href="#">Quyền riêng tư</a> &bull; <a href="#">Trợ giúp</a></p>
</footer>
</body>
</html>