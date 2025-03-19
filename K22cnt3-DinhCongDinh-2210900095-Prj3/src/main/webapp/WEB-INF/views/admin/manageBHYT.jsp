<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.DCD_BaoHiemYTe, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý bảo hiểm y tế</title>
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
        <h1>Quản lý bảo hiểm y tế</h1>
        <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Đăng xuất</a>
    </div>

    <table>
        <thead>
        <tr>
            <th>Mã BHYT</th>
            <th>CCCD</th>
            <th>Ngày cấp</th>
            <th>Ngày hết hạn</th>
            <th>Nơi đăng ký khám bệnh</th>
            <th>Trạng thái</th>
            <th>Ngày tạo</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<DCD_BaoHiemYTe> bhytList = (List<DCD_BaoHiemYTe>) request.getAttribute("bhytList");
            if (bhytList != null) {
                for (DCD_BaoHiemYTe bhyt : bhytList) {
        %>
        <tr>
            <td><%= bhyt.getDCD_MaBHYT() %></td>
            <td><%= bhyt.getDCD_CCCD() %></td>
            <td><%= bhyt.getDCD_NgayCap() %></td>
            <td><%= bhyt.getDCD_NgayHetHan() %></td>
            <td><%= bhyt.getDCD_NoiDangKyKhamBenh() %></td>
            <td><%= bhyt.getDCD_TrangThai() %></td>
            <td><%= bhyt.getDCD_NgayTao() %></td>
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