<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết công dân</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .detail { max-width: 500px; margin: 20px auto; padding: 20px; border: 1px solid #ccc; }
        .logout { float: right; }
    </style>
</head>
<body>
<div class="logout">
    <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</div>
<div class="detail">
    <h2>Chi tiết công dân</h2>
    <p><strong>CCCD:</strong> ${congDan.cccd}</p>
    <p><strong>Họ tên:</strong> ${congDan.hoTen}</p>
    <p><strong>Ngày sinh:</strong> ${congDan.ngaySinh}</p>
    <p><strong>Giới tính:</strong> ${congDan.gioiTinh}</p>
    <p><strong>Số điện thoại:</strong> ${congDan.soDienThoai}</p>
    <p><strong>Email:</strong> ${congDan.email}</p>
    <p><strong>Địa chỉ:</strong> ${congDan.diaChi}</p>
    <p><strong>Ngày cấp:</strong> ${congDan.ngayCap}</p>
    <p><strong>Ngày hết hạn:</strong> ${congDan.ngayHetHan}</p>
</div>
</body>
</html>