<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Yêu cầu chỉnh sửa thông tin</title>
    <style>
        /* CSS đã cung cấp ở trên */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        body {
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }
        .container {
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
            margin: auto;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
            font-size: 28px;
            font-weight: 600;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        label {
            color: #333;
            font-size: 14px;
            font-weight: 500;
        }
        input[type="text"],
        select {
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
            width: 100%;
            transition: border-color 0.3s ease;
        }
        input[type="text"]:focus,
        select:focus {
            border-color: #3498db;
            outline: none;
        }
        input[type="submit"] {
            background: #3498db;
            color: #fff;
            padding: 12px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        input[type="submit"]:hover {
            background: #2980b9;
        }
        a {
            color: #3498db;
            text-decoration: none;
            font-size: 14px;
            transition: color 0.3s ease;
        }
        a:hover {
            color: #2980b9;
        }
        .logout {
            display: inline-block;
            margin-top: 20px;
            background: #e74c3c;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            text-align: center;
        }
        .logout:hover {
            background: #c0392b;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Yêu cầu chỉnh sửa thông tin</h2>
    <%
        String cccd = (String) session.getAttribute("cccd");
        String vaiTro = (String) session.getAttribute("vaiTro");
        if (cccd == null || !"NGUOI_DUNG".equals(vaiTro)) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
    %>
    <form action="<%= request.getContextPath() %>/yeucauChinhSua" method="post">
        <input type="hidden" name="cccd" value="<%= cccd %>">
        <label>Trường cần sửa:</label>
        <select name="truongCanSua" required>
            <option value="DCD_SoDienThoai">Số điện thoại</option>
            <option value="DCD_Email">Email</option>
        </select>
        <label>Giá trị mới:</label>
        <input type="text" name="giaTriMoi" required>
        <input type="submit" value="Gửi yêu cầu">
    </form>
    <a href="<%= request.getContextPath() %>/WEB-INF/views/user/home.jsp">Quay lại</a>
    <a href="<%= request.getContextPath() %>/logout" class="logout">Đăng xuất</a>
    <% } %>
</div>
</body>
</html>