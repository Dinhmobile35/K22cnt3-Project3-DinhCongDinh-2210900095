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
        }
        .card {
            margin-top: 20px;
        }
        .card-header {
            background-color: #007bff;
            color: white;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Chào mừng, ${sessionScope.hoTen}!</h2>

    <!-- Thông tin cá nhân -->
    <div class="card">
        <div class="card-header">
            <h4>Thông tin cá nhân</h4>
        </div>
        <div class="card-body">
            <p><strong>CCCD:</strong> ${sessionScope.cccd}</p>
            <p><strong>Họ và tên:</strong> ${sessionScope.hoTen}</p>
            <p><strong>Ngày sinh:</strong> <fmt:formatDate value="${sessionScope.ngaySinh}" pattern="dd/MM/yyyy" /></p>
            <p><strong>Giới tính:</strong> ${sessionScope.gioiTinh}</p>
            <p><strong>Số điện thoại:</strong> ${sessionScope.soDienThoai}</p>
            <p><strong>Email:</strong> ${sessionScope.email}</p>
            <p><strong>Địa chỉ:</strong> ${sessionScope.diaChi}</p>
            <p><strong>Ngày cấp:</strong> <fmt:formatDate value="${sessionScope.ngayCap}" pattern="dd/MM/yyyy" /></p>
            <p><strong>Ngày hết hạn:</strong> <fmt:formatDate value="${sessionScope.ngayHetHan}" pattern="dd/MM/yyyy" /></p>
            <a href="${pageContext.request.contextPath}/user/editProfile" class="btn btn-primary">Cập nhật thông tin</a>
        </div>
    </div>

    <!-- Các chức năng -->
    <div class="card mt-4">
        <div class="card-header">
            <h4>Các chức năng</h4>
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col-md-4">
                    <div class="card text-center">
                        <div class="card-body">
                            <h5 class="card-title">Yêu cầu cấp lại CCCD</h5>
                            <p class="card-text">Gửi yêu cầu cấp lại chứng minh nhân dân/căn cước công dân.</p>
                            <a href="${pageContext.request.contextPath}/user/capLaiRequest" class="btn btn-primary">Gửi yêu cầu</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card text-center">
                        <div class="card-body">
                            <h5 class="card-title">Chỉnh sửa thông tin</h5>
                            <p class="card-text">Yêu cầu chỉnh sửa thông tin cá nhân (số điện thoại, email).</p>
                            <a href="${pageContext.request.contextPath}/user/chinhSuaRequest" class="btn btn-primary">Gửi yêu cầu</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card text-center">
                        <div class="card-body">
                            <h5 class="card-title">Đổi mật khẩu</h5>
                            <p class="card-text">Yêu cầu đổi mật khẩu tài khoản.</p>
                            <a href="${pageContext.request.contextPath}/user/doiMatKhauRequest" class="btn btn-primary">Gửi yêu cầu</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Đăng xuất -->
    <div class="text-center mt-4">
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit" class="btn btn-danger">Đăng xuất</button>
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>