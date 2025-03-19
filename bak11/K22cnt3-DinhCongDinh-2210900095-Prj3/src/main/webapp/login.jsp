<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập - Hệ thống Quản lý CCCD</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .login-container {
            background-color: white;
            width: 400px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .login-container h2 {
            color: #1a1a1a;
            margin-bottom: 20px;
        }
        .login-container input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #dddfe2;
            border-radius: 5px;
            font-size: 16px;
        }
        .login-container button {
            width: 100%;
            padding: 10px;
            background-color: #1877f2;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        .login-container button:hover {
            background-color: #166fe5;
        }
        .error {
            color: #d9534f;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Đăng nhập</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" name="cccd" placeholder="Số CCCD" required>
        <input type="password" name="matKhau" placeholder="Mật khẩu" required>
        <button type="submit">Đăng nhập</button>
    </form>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <p>Chưa có tài khoản? <a href="${pageContext.request.contextPath}/register" style="color: #1877f2;">Đăng ký</a></p>
</div>
</body>
</html>