<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý công dân</title>
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

        h2 {
            margin-bottom: 20px;
            color: #2c3e50;
        }

        .action-bar {
            display: flex;
            justify-content: flex-end;
            margin-bottom: 20px;
        }

        .btn {
            padding: 8px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            color: white;
            margin-right: 10px;
            transition: opacity 0.3s;
            font-size: 14px;
        }

        .btn-primary { background-color: #3498db; }
        .btn-warning { background-color: #f1c40f; }
        .btn-danger { background-color: #e74c3c; }
        .btn:hover { opacity: 0.9; }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 100%;
            overflow-x: auto; /* Thêm cuộn ngang nếu bảng quá rộng */
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            white-space: nowrap; /* Ngăn ngắt dòng */
        }

        th {
            background-color: #3498db;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f8f9fa;
        }

        tr:hover {
            background-color: #e9ecef;
        }

        /* Info Section */
        .info-section {
            background: #fff;
            border-radius: 10px;
            padding: 20px;
            margin-top: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            flex: 1;
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

            .action-bar {
                justify-content: center;
                margin-bottom: 15px;
            }

            table {
                display: block;
                overflow-x: auto;
            }

            th, td {
                min-width: 120px; /* Đảm bảo cột không quá hẹp */
            }

            .btn {
                margin-bottom: 5px;
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
    <a href="${pageContext.request.contextPath}/admin/dashboard" class="${pageContext.request.servletPath.contains('dashboard') ? 'active' : ''}">Dashboard</a>
    <a href="${pageContext.request.contextPath}/admin/congdan" class="${pageContext.request.servletPath.contains('congdan') ? 'active' : ''}">Quản lý công dân</a>
    <a href="${pageContext.request.contextPath}/admin/taikhoan" class="${pageContext.request.servletPath.contains('taikhoan') ? 'active' : ''}">Quản lý tài khoản</a>
</div>

<!-- Content -->
<div class="content">
    <h2>Quản lý công dân</h2>
    <div class="action-bar">
        <a href="${pageContext.request.contextPath}/admin/congdan?action=new" class="btn btn-primary">Thêm công dân</a>
    </div>
    <table>
        <thead>
        <tr>
            <th>CCCD</th>
            <th>Họ tên</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>Số điện thoại</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>Ngày cấp</th>
            <th>Ngày hết hạn</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="congDan" items="${congDanList}">
            <tr>
                <td><c:out value="${congDan.cccd}" /></td>
                <td><c:out value="${congDan.hoTen}" /></td>
                <td><c:out value="${congDan.ngaySinh}" /></td>
                <td><c:out value="${congDan.gioiTinh}" /></td>
                <td><c:out value="${congDan.soDienThoai}" /></td>
                <td><c:out value="${congDan.email}" /></td>
                <td><c:out value="${congDan.diaChi}" /></td>
                <td><c:out value="${congDan.ngayCap}" /></td>
                <td><c:out value="${congDan.ngayHetHan}" /></td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/congdan?action=edit&cccd=${congDan.cccd}" class="btn btn-warning">Sửa</a>
                    <a href="${pageContext.request.contextPath}/admin/congdan?action=delete&cccd=${congDan.cccd}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Thông tin bổ sung -->
    <div class="info-section">
        <h4>Hướng dẫn quản lý công dân</h4>
        <ul>
            <li>Thêm công dân mới bằng cách nhấn nút "Thêm công dân" và điền đầy đủ thông tin.</li>
            <li>Sửa hoặc xóa thông tin công dân bằng các nút "Sửa" và "Xóa" tương ứng.</li>
            <li>Kiểm tra ngày hết hạn CCCD để thông báo gia hạn kịp thời.</li>
        </ul>
        <h4>Thông báo</h4>
        <ul>
            <li>Cập nhật danh sách công dân vào ngày 14/03/2025 với dữ liệu mới nhất.</li>
            <li>Đảm bảo bảo mật thông tin cá nhân của công dân khi thực hiện chỉnh sửa.</li>
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