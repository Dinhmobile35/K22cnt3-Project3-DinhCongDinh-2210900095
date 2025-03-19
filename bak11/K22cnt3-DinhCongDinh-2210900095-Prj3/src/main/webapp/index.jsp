<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ - Hệ thống Quản lý CCCD</title>
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
        .container {
            width: 70%;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: space-between;
        }
        .info-section {
            width: 70%;
        }
        h1 {
            color: #1a1a1a;
            font-size: 24px;
            margin-bottom: 20px;
        }
        .cccd-info, .notifications {
            background-color: #fff;
            padding: 15px;
            border-radius: 5px;
            margin-bottom: 20px;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
        }
        .cccd-info p, .notifications p {
            margin: 5px 0;
            color: #333;
        }
        .notifications {
            color: #d9534f; /* Màu đỏ cho thông báo */
        }
        .login-button {
            position: fixed;
            top: 20px;
            right: 20px;
            padding: 10px 20px;
            background-color: #1877f2; /* Màu xanh Facebook */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .login-button:hover {
            background-color: #166fe5;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="info-section">
        <h1>Thông tin CCCD</h1>
        <div class="cccd-info">
            <c:choose>
                <c:when test="${not empty sessionScope.congDan}">
                    <p><strong>Số CCCD:</strong> ${sessionScope.congDan.DCD_CCCD}</p>
                    <p><strong>Họ tên:</strong> ${sessionScope.congDan.DCD_HoTen}</p>
                    <p><strong>Địa chỉ:</strong> ${sessionScope.congDan.DCD_DiaChi}</p>
                    <c:if test="${sessionScope.congDan.DCD_CCCD.startsWith('000')}">
                        <p><strong>Quyền:</strong> Admin</p>
                    </c:if>
                    <c:if test="${not sessionScope.congDan.DCD_CCCD.startsWith('000')}">
                        <p><strong>Quyền:</strong> Người dùng</p>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <p>Chưa đăng nhập. Vui lòng đăng nhập để xem thông tin.</p>
                </c:otherwise>
            </c:choose>
        </div>
        <h1>Thông báo</h1>
        <div class="notifications">
            <p>Thông báo 1: Hệ thống đang hoạt động ổn định.</p>
            <p>Thông báo 2: Có yêu cầu cấp lại CCCD đang chờ xử lý.</p>
            <p>Thông báo 3: Cập nhật thông tin cá nhân trước ngày 31/03/2025.</p>
        </div>
    </div>
</div>
<c:if test="${empty sessionScope.congDan}">
    <a href="${pageContext.request.contextPath}/login" class="login-button">Đăng nhập</a>
</c:if>
<c:if test="${not empty sessionScope.congDan}">
    <a href="${pageContext.request.contextPath}/login?logout=true" class="login-button">Đăng xuất</a>
</c:if>
</body>
</html>