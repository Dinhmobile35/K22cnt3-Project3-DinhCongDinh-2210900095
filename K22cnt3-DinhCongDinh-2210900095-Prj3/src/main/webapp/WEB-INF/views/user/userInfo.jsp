<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.DCD_CongDan, model.DCD_BaoHiemYTe, model.DCD_GiayPhepLaiXe, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin cá nhân</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        body {
            background: #f4f7fc;
            min-height: 100vh;
            display: flex;
            color: #333;
        }
        .sidebar {
            width: 250px;
            background: #2c3e50;
            color: #fff;
            height: 100vh;
            position: fixed;
            padding-top: 20px;
            box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
        }
        .sidebar h2 {
            text-align: center;
            font-size: 24px;
            margin-bottom: 30px;
            color: #ecf0f1;
        }
        .sidebar ul {
            list-style: none;
        }
        .sidebar ul li {
            margin: 10px 0;
        }
        .sidebar ul li a {
            display: block;
            padding: 15px 20px;
            color: #ecf0f1;
            text-decoration: none;
            font-size: 16px;
            transition: background 0.3s ease;
        }
        .sidebar ul li a:hover {
            background: #34495e;
        }
        .main-content {
            margin-left: 250px;
            padding: 30px;
            width: calc(100% - 250px);
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background: #fff;
            padding: 15px 30px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        .header h1 {
            font-size: 26px;
            color: #2c3e50;
        }
        .logout-btn {
            background: #e74c3c;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            font-size: 14px;
            transition: background 0.3s ease;
        }
        .logout-btn:hover {
            background: #c0392b;
        }
        .info-panel {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        .info-panel h3 {
            font-size: 20px;
            margin-bottom: 15px;
            color: #2c3e50;
        }
        .info-panel p {
            font-size: 16px;
            color: #555;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="sidebar">
    <h2>User Panel</h2>
    <ul>
        <li><a href="<%= request.getContextPath() %>/userInfo">Xem thông tin cá nhân</a></li>
        <li><a href="<%= request.getContextPath() %>/yeucauCapLai">Gửi yêu cầu cấp lại</a></li>
        <li><a href="<%= request.getContextPath() %>/viewYeuCau">Xem danh sách yêu cầu</a></li>
    </ul>
</div>

<div class="main-content">
    <div class="header">
        <h1>Thông tin cá nhân</h1>
        <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Đăng xuất</a>
    </div>

    <div class="info-panel">
        <h3>Thông tin công dân</h3>
        <%
            DCD_CongDan congDan = (DCD_CongDan) request.getAttribute("congDan");
            if (congDan != null) {
        %>
        <p><strong>CCCD:</strong> <%= congDan.getDCD_CCCD() %></p>
        <p><strong>Họ tên:</strong> <%= congDan.getDCD_HoTen() %></p>
        <p><strong>Ngày sinh:</strong> <%= congDan.getDCD_NgaySinh() %></p>
        <p><strong>Giới tính:</strong> <%= congDan.getDCD_GioiTinh() %></p>
        <p><strong>Trạng thái:</strong> <%= congDan.getDCD_TrangThai() %></p>
        <% } else { %>
        <p>Không tìm thấy thông tin công dân.</p>
        <% } %>
    </div>

    <div class="info-panel">
        <h3>Thông tin bảo hiểm y tế</h3>
        <%
            DCD_BaoHiemYTe bhyt = (DCD_BaoHiemYTe) request.getAttribute("bhyt");
            if (bhyt != null) {
        %>
        <p><strong>Mã BHYT:</strong> <%= bhyt.getDCD_MaBHYT() %></p>
        <p><strong>Ngày cấp:</strong> <%= bhyt.getDCD_NgayCap() %></p>
        <p><strong>Ngày hết hạn:</strong> <%= bhyt.getDCD_NgayHetHan() %></p>
        <p><strong>Nơi đăng ký khám bệnh:</strong> <%= bhyt.getDCD_NoiDangKyKhamBenh() %></p>
        <p><strong>Trạng thái:</strong> <%= bhyt.getDCD_TrangThai() %></p>
        <p><strong>Ngày tạo:</strong> <%= bhyt.getDCD_NgayTao() %></p>
        <% } else { %>
        <p>Không có thông tin bảo hiểm y tế.</p>
        <% } %>
    </div>

    <div class="info-panel">
        <h3>Thông tin giấy phép lái xe</h3>
        <%
            DCD_GiayPhepLaiXe gplx = (DCD_GiayPhepLaiXe) request.getAttribute("gplx");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // Định dạng ngày giờ
            if (gplx != null) {
        %>
        <p><strong>Số GPLX:</strong> <%= gplx.getDCD_SoGPLX() %></p>
        <p><strong>Hạng GPLX:</strong> <%= gplx.getDCD_HangGPLX() %></p>
        <p><strong>Ngày cấp:</strong> <%= gplx.getDCD_NgayCap() %></p>
        <p><strong>Ngày hết hạn:</strong> <%= gplx.getDCD_NgayHetHan() %></p>
        <p><strong>Nơi cấp:</strong> <%= gplx.getDCD_NoiCap() %></p>
        <p><strong>Trạng thái:</strong> <%= gplx.getDCD_TrangThai() %></p>
        <p><strong>Ngày tạo:</strong> <%= gplx.getDCD_NgayTao() != null ? sdf.format(gplx.getDCD_NgayTao()) : "N/A" %></p> <!-- Định dạng Timestamp -->
        <% } else { %>
        <p>Không có thông tin giấy phép lái xe.</p>
        <% } %>
    </div>
</div>
</body>
</html>