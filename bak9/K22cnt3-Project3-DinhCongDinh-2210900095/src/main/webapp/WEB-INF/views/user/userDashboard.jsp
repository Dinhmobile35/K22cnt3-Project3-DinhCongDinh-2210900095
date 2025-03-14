<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Người Dùng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }
        .navbar {
            margin-bottom: 20px;
        }
        .navbar-nav .nav-item {
            margin-right: 15px;
        }
        .content-wrapper {
            flex: 1;
            display: flex;
        }
        .id-card {
            max-width: 400px;
            background-color: #ffffff;
            border: 2px solid #000;
            border-radius: 10px;
            padding: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-right: 20px;
        }
        .id-card-header {
            text-align: center;
            margin-bottom: 15px;
            border-bottom: 1px solid #000;
            padding-bottom: 10px;
        }
        .id-card-header h4 {
            margin: 0;
            font-size: 1.5rem;
            color: #000;
        }
        .id-card-body {
            font-size: 0.9rem;
        }
        .id-card-field {
            display: flex;
            justify-content: space-between;
            margin-bottom: 8px;
            line-height: 1.2;
        }
        .id-card-field .label {
            font-weight: bold;
            color: #333;
            width: 40%;
        }
        .id-card-field .value {
            color: #000;
            width: 60%;
            text-align: right;
        }
        .id-card-footer {
            text-align: center;
            margin-top: 15px;
            border-top: 1px solid #000;
            padding-top: 10px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            width: 100%;
            margin-top: 15px;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
        .btn-danger {
            margin-left: 10px;
        }
    </style>
</head>
<body>
<!-- Thanh taskbar (Navbar) -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Hệ Thống CCCD</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <span class="nav-link">Chào mừng, ${sessionScope.hoTen}!</span>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/user?action=capLaiRequest">Yêu cầu cấp lại CCCD</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/user?action=chinhSuaRequest">Chỉnh sửa thông tin</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/user?action=doiMatKhauRequest">Đổi mật khẩu</a>
            </li>
            <li class="nav-item">
                <form action="${pageContext.request.contextPath}/logout" method="post" style="display: inline;">
                    <button type="submit" class="btn btn-danger">Đăng xuất</button>
                </form>
            </li>
        </ul>
    </div>
</nav>

<!-- Nội dung chính -->
<div class="content-wrapper">
    <!-- Cột trái: Thẻ căn cước -->
    <div class="id-card">
        <div class="id-card-header">
            <h4>CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</h4>
            <p class="text-muted">Độc lập - Tự do - Hạnh phúc</p>
        </div>
        <c:if test="${not empty message}">
            <p style="color: green">${message}</p>
        </c:if>
        <c:if test="${not empty error}">
            <p style="color: red">${error}</p>
        </c:if>
        <div class="id-card-body">
            <div class="id-card-field">
                <span class="label">Số CCCD:</span>
                <span class="value">${sessionScope.cccd}</span>
            </div>
            <div class="id-card-field">
                <span class="label">Họ và tên:</span>
                <span class="value">${sessionScope.hoTen}</span>
            </div>
            <div class="id-card-field">
                <span class="label">Ngày sinh:</span>
                <span class="value"><fmt:formatDate value="${sessionScope.ngaySinh}" pattern="dd/MM/yyyy" /></span>
            </div>
            <div class="id-card-field">
                <span class="label">Giới tính:</span>
                <span class="value">${sessionScope.gioiTinh}</span>
            </div>
            <div class="id-card-field">
                <span class="label">Quốc tịch:</span>
                <span class="value">Việt Nam</span>
            </div>
            <div class="id-card-field">
                <span class="label">Địa chỉ:</span>
                <span class="value">${sessionScope.diaChi}</span>
            </div>
            <div class="id-card-field">
                <span class="label">Số điện thoại:</span>
                <span class="value">${sessionScope.soDienThoai}</span>
            </div>
            <div class="id-card-field">
                <span class="label">Email:</span>
                <span class="value">${sessionScope.email}</span>
            </div>
        </div>
        <div class="id-card-footer">
            <div class="id-card-field">
                <span class="label">Ngày cấp:</span>
                <span class="value"><fmt:formatDate value="${sessionScope.ngayCap}" pattern="dd/MM/yyyy" /></span>
            </div>
            <div class="id-card-field">
                <span class="label">Ngày hết hạn:</span>
                <span class="value"><fmt:formatDate value="${sessionScope.ngayHetHan}" pattern="dd/MM/yyyy" /></span>
            </div>
        </div>
        <a href="${pageContext.request.contextPath}/user?action=editProfile" class="btn btn-primary">Cập nhật thông tin</a>
    </div>

    <!-- Cột phải: Có thể thêm nội dung khác nếu cần (hiện để trống) -->
    <div class="flex-grow-1">
        <!-- Nội dung bổ sung có thể được thêm vào đây -->
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>