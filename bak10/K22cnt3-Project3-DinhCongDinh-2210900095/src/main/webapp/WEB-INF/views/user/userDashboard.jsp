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
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            background: linear-gradient(135deg, #6e8efb, #a777e3); /* Gradient background */
            color: #333;
        }

        .navbar {
            margin-bottom: 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .navbar-brand {
            font-size: 1.5rem;
            font-weight: bold;
            color: #6e8efb !important;
        }

        .navbar-nav .nav-item {
            margin-right: 15px;
        }

        .navbar-nav .nav-link {
            color: #333 !important;
            font-size: 1rem;
        }

        .navbar-nav .nav-link:hover {
            color: #6e8efb !important;
        }

        .content-wrapper {
            flex: 1;
            display: flex;
            justify-content: center;
            padding: 20px;
        }

        .id-card {
            max-width: 400px;
            background-color: #ffffff;
            border: 2px solid #000;
            border-radius: 10px;
            padding: 20px;
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

        .id-card-header .text-muted {
            font-size: 0.9rem;
            color: #666;
        }

        .id-card-body, .id-card-footer {
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
            background-color: #6e8efb;
            border-color: #6e8efb;
            width: 100%;
            margin-top: 15px;
            transition: background 0.3s ease;
        }

        .btn-primary:hover {
            background-color: #5d7ce0;
            border-color: #5d7ce0;
        }

        .btn-danger {
            margin-left: 10px;
            background-color: #e74c3c;
            border-color: #e74c3c;
            transition: background 0.3s ease;
        }

        .btn-danger:hover {
            background-color: #c0392b;
            border-color: #c0392b;
        }

        .info-panel {
            flex: 1;
            max-width: 600px;
            background: #fff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-left: 20px;
        }

        .info-panel h3 {
            color: #6e8efb;
            margin-bottom: 15px;
        }

        .info-panel p {
            font-size: 0.95rem;
            color: #555;
            margin-bottom: 10px;
        }

        .info-panel ul {
            list-style-type: none;
            padding-left: 0;
        }

        .info-panel ul li {
            margin-bottom: 10px;
            font-size: 0.95rem;
            color: #555;
        }

        .info-panel ul li:before {
            content: "•";
            color: #6e8efb;
            font-weight: bold;
            margin-right: 10px;
        }

        .info-panel ul li a {
            color: #6e8efb;
            text-decoration: none;
        }

        .info-panel ul li a:hover {
            text-decoration: underline;
        }

        /* Footer */
        footer {
            background-color: #fff;
            padding: 20px 0;
            text-align: center;
            box-shadow: 0 -2px 4px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }

        footer p {
            font-size: 0.9rem;
            color: #666;
            margin-bottom: 5px;
        }

        footer a {
            color: #6e8efb;
            text-decoration: none;
            margin: 0 10px;
        }

        footer a:hover {
            text-decoration: underline;
        }

        /* Responsive design */
        @media (max-width: 768px) {
            .content-wrapper {
                flex-direction: column;
                align-items: center;
            }

            .id-card, .info-panel {
                margin: 0 0 20px 0;
                max-width: 100%;
            }

            footer {
                padding: 15px 0;
            }
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

    <!-- Cột phải: Nội dung bổ sung -->
    <div class="info-panel">
        <h3>Thông tin & Dịch vụ liên quan đến CCCD</h3>
        <p>Chào mừng bạn đến với Hệ thống Quản lý Căn cước Công dân! Đây là nơi bạn có thể quản lý thông tin cá nhân và thực hiện các yêu cầu liên quan đến CCCD.</p>

        <h4>Hướng dẫn sử dụng</h4>
        <ul>
            <li>Yêu cầu cấp lại CCCD nếu bạn mất hoặc hỏng thẻ.</li>
            <li>Chỉnh sửa thông tin cá nhân (địa chỉ, số điện thoại, email, v.v.) khi cần thiết.</li>
            <li>Đổi mật khẩu để bảo vệ tài khoản của bạn.</li>
        </ul>

        <h4>Tin tức mới nhất (Tính đến 14/03/2025)</h4>
        <ul>
            <li>Chính phủ Việt Nam triển khai CCCD gắn chip từ năm 2021, với hơn 90% dân số đã được cấp.</li>
            <li>Cập nhật quy trình cấp lại CCCD trực tuyến bắt đầu từ tháng 3/2025.</li>
            <li>Đảm bảo an toàn thông tin cá nhân khi sử dụng hệ thống này.</li>
        </ul>

        <h4>Dịch vụ phổ biến</h4>
        <ul>
            <li><a href="${pageContext.request.contextPath}/user?action=capLaiRequest" style="color: #6e8efb;">Yêu cầu cấp lại CCCD</a></li>
            <li><a href="${pageContext.request.contextPath}/user?action=chinhSuaRequest" style="color: #6e8efb;">Chỉnh sửa thông tin</a></li>
            <li><a href="${pageContext.request.contextPath}/user?action=doiMatKhauRequest" style="color: #6e8efb;">Đổi mật khẩu</a></li>
        </ul>
    </div>
</div>

<!-- Footer -->
<footer>
    <p>&copy; 2025 Hệ Thống Quản lý Căn cước Công dân. Đã đăng ký bản quyền.</p>
    <p>
        <a href="${pageContext.request.contextPath}/privacy">Chính sách bảo mật</a> |
        <a href="${pageContext.request.contextPath}/contact">Liên hệ</a>
    </p>
    <p>Hỗ trợ: <a href="tel:+84912345678">0912 345 678</a> | Email: <a href="mailto:support@cccd.gov.vn">support@cccd.gov.vn</a></p>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>