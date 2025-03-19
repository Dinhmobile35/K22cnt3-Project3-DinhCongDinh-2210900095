<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.DCD_YeuCauCapLai, java.util.List, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý yêu cầu</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        table th, table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        table th {
            background: #3498db;
            color: #fff;
        }
        table tr:hover {
            background: #f5f5f5;
        }
        .action-btn {
            padding: 5px 10px;
            border-radius: 5px;
            text-decoration: none;
            margin-right: 5px;
        }
        .accept-btn {
            background: #2ecc71;
            color: #fff;
        }
        .accept-btn:hover {
            background: #27ae60;
        }
        .reject-btn {
            background: #e74c3c;
            color: #fff;
        }
        .reject-btn:hover {
            background: #c0392b;
        }
        .form-group select {
            padding: 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="sidebar">
    <h2>Admin Panel</h2>
    <ul>
        <li><a href="<%= request.getContextPath() %>/dashboard">Dashboard</a></li>
        <li><a href="<%= request.getContextPath() %>/manageCongDan">Quản lý công dân</a></li>
        <li><a href="<%= request.getContextPath() %>/manageBHYT">Quản lý bảo hiểm y tế</a></li>
        <li><a href="<%= request.getContextPath() %>/manageGPLX">Quản lý giấy phép lái xe</a></li>
        <li><a href="<%= request.getContextPath() %>/manageYeuCau">Quản lý yêu cầu</a></li>
    </ul>
</div>

<div class="main-content">
    <div class="header">
        <h1>Quản lý yêu cầu</h1>
        <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Đăng xuất</a>
    </div>

    <table>
        <thead>
        <tr>
            <th>Mã yêu cầu</th>
            <th>CCCD</th>
            <th>Loại yêu cầu</th>
            <th>Trạng thái</th>
            <th>Trạng thái giao hàng</th>
            <th>Tên người nhận</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ nhận</th>
            <th>Ngày tạo</th>
            <th>Ngày cập nhật</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<DCD_YeuCauCapLai> yeuCauList = (List<DCD_YeuCauCapLai>) request.getAttribute("yeuCauList");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            if (yeuCauList != null) {
                for (DCD_YeuCauCapLai yeuCau : yeuCauList) {
        %>
        <tr>
            <td><%= yeuCau.getDCD_MaYeuCau() %></td>
            <td><%= yeuCau.getDCD_CCCD() %></td>
            <td><%= yeuCau.getDCD_LoaiYeuCau() %></td>
            <td><%= yeuCau.getDCD_TrangThai() %></td>
            <td>
                <% if ("DA_DUYET".equals(yeuCau.getDCD_TrangThai())) { %>
                <form action="<%= request.getContextPath() %>/manageYeuCau" method="get" style="display:inline;">
                    <input type="hidden" name="action" value="updateGiaoHang">
                    <input type="hidden" name="maYeuCau" value="<%= yeuCau.getDCD_MaYeuCau() %>">
                    <div class="form-group">
                        <select name="trangThaiGiaoHang" onchange="this.form.submit()">
                            <option value="CHUA_GIAO" <%= "CHUA_GIAO".equals(yeuCau.getDCD_TrangThaiGiaoHang()) ? "selected" : "" %>>Chưa giao</option>
                            <option value="DANG_GIAO" <%= "DANG_GIAO".equals(yeuCau.getDCD_TrangThaiGiaoHang()) ? "selected" : "" %>>Đang giao</option>
                            <option value="DA_NHAN" <%= "DA_NHAN".equals(yeuCau.getDCD_TrangThaiGiaoHang()) ? "selected" : "" %>>Đã nhận</option>
                        </select>
                    </div>
                </form>
                <% } else { %>
                <%= yeuCau.getDCD_TrangThaiGiaoHang() %>
                <% } %>
            </td>
            <td><%= yeuCau.getDCD_TenNguoiNhan() %></td>
            <td><%= yeuCau.getDCD_SoDienThoaiNhan() %></td>
            <td><%= yeuCau.getDCD_DiaChiNhan() %></td>
            <td><%= yeuCau.getDCD_NgayTao() != null ? sdf.format(yeuCau.getDCD_NgayTao()) : "N/A" %></td>
            <td><%= yeuCau.getDCD_NgayCapNhat() != null ? sdf.format(yeuCau.getDCD_NgayCapNhat()) : "N/A" %></td>
            <td>
                <% if ("CHO_DUYET".equals(yeuCau.getDCD_TrangThai())) { %>
                <a href="<%= request.getContextPath() %>/manageYeuCau?action=accept&maYeuCau=<%= yeuCau.getDCD_MaYeuCau() %>" class="action-btn accept-btn">Chấp nhận</a>
                <a href="<%= request.getContextPath() %>/manageYeuCau?action=reject&maYeuCau=<%= yeuCau.getDCD_MaYeuCau() %>" class="action-btn reject-btn">Từ chối</a>
                <% } %>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>