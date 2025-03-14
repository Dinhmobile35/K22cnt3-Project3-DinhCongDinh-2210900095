<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
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
            background-color: #3498db;
            padding: 10px 20px;
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 1000;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .navbar a {
            color: white;
            text-decoration: none;
            font-size: 18px;
            font-weight: bold;
        }

        .navbar a:hover {
            color: #ecf0f1;
        }

        .sidebar {
            width: 250px;
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            background-color: #2c3e50;
            color: white;
            padding-top: 70px; /* Tăng padding-top để tránh chồng lên navbar */
            transition: width 0.3s;
        }

        .sidebar a {
            display: block;
            padding: 15px 20px;
            color: white;
            text-decoration: none;
            font-size: 16px;
            transition: background 0.3s;
        }

        .sidebar a:hover, .sidebar a.active {
            background-color: #34495e;
        }

        .content {
            margin-left: 250px;
            padding: 80px 30px 20px 30px; /* Tăng padding-top để tránh chồng navbar */
            flex: 1;
            display: flex;
            flex-direction: column;
        }

        .section-title {
            margin-top: 20px;
            font-size: 24px;
            color: #2c3e50;
            margin-bottom: 15px;
        }

        .card-container {
            display: flex;
            gap: 10px; /* Giảm khoảng cách giữa các card */
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .card {
            flex: 1;
            min-width: 150px; /* Giảm kích thước tối thiểu của card */
            background-color: white;
            border-radius: 8px;
            padding: 15px; /* Giảm padding */
            margin-bottom: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            transition: transform 0.3s;
        }

        .card:hover {
            transform: translateY(-5px);
        }

        .card.blue { background-color: #3498db; color: white; }
        .card.green { background-color: #2ecc71; color: white; }
        .card.yellow { background-color: #f1c40f; color: white; }
        .card.red { background-color: #e74c3c; color: white; }

        .card h5 {
            font-size: 1rem; /* Giảm kích thước tiêu đề */
            margin-bottom: 5px;
        }

        .card p {
            font-size: 1.2rem; /* Giảm kích thước số liệu */
            font-weight: bold;
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

        /* Info Section */
        .info-section {
            background: #fff;
            border-radius: 10px;
            padding: 20px;
            margin-top: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .info-section h4 {
            color: #6e8efb;
            margin-bottom: 15px;
            font-size: 1.2rem;
        }

        .info-section ul {
            list-style-type: none;
            padding-left: 0;
        }

        .info-section ul li {
            margin-bottom: 10px;
            font-size: 1rem;
            color: #555;
        }

        .info-section ul li:before {
            content: "•";
            color: #6e8efb;
            font-weight: bold;
            margin-right: 10px;
        }

        /* Responsive design */
        @media (max-width: 768px) {
            .sidebar {
                width: 100%;
                height: auto;
                position: relative;
                padding-top: 20px;
            }

            .content {
                margin-left: 0;
                padding: 60px 15px 20px 15px;
            }

            .card-container {
                flex-direction: column;
            }

            .card {
                min-width: 100%;
            }

            footer {
                padding: 15px 0;
            }
        }
    </style>
</head>
<body>
<!-- Navbar -->
<div class="navbar">
    <a href="${pageContext.request.contextPath}/admin/dashboard">Admin Dashboard</a>
    <a href="${pageContext.request.contextPath}/logout" style="float: right;">Đăng xuất</a>
</div>

<!-- Sidebar -->
<div class="sidebar">
    <a href="${pageContext.request.contextPath}/admin/dashboard" class="${pageContext.request.servletPath.contains('dashboard') && empty param.action ? 'active' : ''}">Dashboard</a>
    <a href="${pageContext.request.contextPath}/admin/congdan" class="${pageContext.request.servletPath.contains('congdan') ? 'active' : ''}">Quản lý công dân</a>
    <a href="${pageContext.request.contextPath}/admin/taikhoan" class="${pageContext.request.servletPath.contains('taikhoan') ? 'active' : ''}">Quản lý tài khoản</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard?action=capLaiList" class="${param.action == 'capLaiList' ? 'active' : ''}">Yêu cầu cấp lại CCCD</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard?action=chinhSuaList" class="${param.action == 'chinhSuaList' ? 'active' : ''}">Yêu cầu chỉnh sửa</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard?action=doiMatKhauList" class="${param.action == 'doiMatKhauList' ? 'active' : ''}">Yêu cầu đổi mật khẩu</a>
</div>

<!-- Content -->
<div class="content">
    <h2>Dashboard</h2>

    <!-- Tổng quan -->
    <div class="section-title">Tổng quan</div>
    <div class="card-container">
        <div class="card blue">
            <h5>Tổng số công dân</h5>
            <p>${totalCongDan}</p>
        </div>
        <div class="card green">
            <h5>Tổng số tài khoản</h5>
            <p>${totalTaiKhoan}</p>
        </div>
        <div class="card yellow">
            <h5>Tài khoản bị khóa</h5>
            <p>${lockedTaiKhoan}</p>
        </div>
    </div>

    <!-- Yêu cầu cấp lại CCCD -->
    <div class="section-title">Yêu cầu cấp lại CCCD</div>
    <div class="card-container">
        <div class="card blue">
            <h5>Chờ duyệt</h5>
            <p>${capLaiChoDuyet}</p>
        </div>
        <div class="card green">
            <h5>Đã duyệt</h5>
            <p>${capLaiDaDuyet}</p>
        </div>
        <div class="card red">
            <h5>Từ chối</h5>
            <p>${capLaiTuChoi}</p>
        </div>
        <div class="card yellow">
            <h5>Chưa giao</h5>
            <p>${capLaiChuaGiao}</p>
        </div>
        <div class="card green">
            <h5>Đang giao</h5>
            <p>${capLaiDangGiao}</p>
        </div>
        <div class="card blue">
            <h5>Đã nhận</h5>
            <p>${capLaiDaNhan}</p>
        </div>
    </div>

    <!-- Yêu cầu chỉnh sửa thông tin -->
    <div class="section-title">Yêu cầu chỉnh sửa thông tin</div>
    <div class="card-container">
        <div class="card blue">
            <h5>Chờ duyệt</h5>
            <p>${chinhSuaChoDuyet}</p>
        </div>
        <div class="card green">
            <h5>Đã duyệt</h5>
            <p>${chinhSuaDaDuyet}</p>
        </div>
        <div class="card red">
            <h5>Từ chối</h5>
            <p>${chinhSuaTuChoi}</p>
        </div>
    </div>

    <!-- Yêu cầu đổi mật khẩu -->
    <div class="section-title">Yêu cầu đổi mật khẩu</div>
    <div class="card-container">
        <div class="card blue">
            <h5>Chờ duyệt</h5>
            <p>${doiMatKhauChoDuyet}</p>
        </div>
        <div class="card green">
            <h5>Hoàn thành</h5>
            <p>${doiMatKhauHoanThanh}</p>
        </div>
        <div class="card red">
            <h5>Từ chối</h5>
            <p>${doiMatKhauTuChoi}</p>
        </div>
    </div>

    <!-- Thông tin bổ sung -->
    <div class="info-section">
        <h4>Hướng dẫn quản trị</h4>
        <ul>
            <li>Phê duyệt hoặc từ chối yêu cầu cấp lại CCCD trong vòng 24h để đảm bảo tiến độ.</li>
            <li>Kiểm tra thông tin công dân trước khi cập nhật hoặc khóa tài khoản.</li>
            <li>Liên hệ hỗ trợ nếu phát hiện lỗi hệ thống hoặc yêu cầu khẩn cấp.</li>
        </ul>
        <h4>Thông báo hệ thống</h4>
        <ul>
            <li>Cập nhật phiên bản hệ thống vào ngày 14/03/2025 với tính năng quản lý trực tuyến.</li>
            <li>Đảm bảo sao lưu dữ liệu định kỳ để tránh mất mát thông tin.</li>
        </ul>
    </div>
</div>

<!-- Footer -->
<footer>
    <p>© 2025 Hệ Thống Quản lý Căn cước Công dân. Đã đăng ký bản quyền.</p>
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