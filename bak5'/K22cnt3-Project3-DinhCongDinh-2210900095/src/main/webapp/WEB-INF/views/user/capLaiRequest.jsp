<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Yêu cầu cấp lại CCCD</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Yêu cầu cấp lại CCCD</h2>
    <a href="${pageContext.request.contextPath}/user/userDashboard" class="btn btn-secondary mb-3">Quay lại</a>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <input type="hidden" name="action" value="submitCapLai">
        <div class="form-group">
            <label for="loaiYeuCau">Loại yêu cầu:</label>
            <select name="loaiYeuCau" id="loaiYeuCau" class="form-control" required>
                <option value="MAT">Mất</option>
                <option value="HU">Hư</option>
            </select>
        </div>
        <div class="form-group">
            <label for="tenNguoiNhan">Tên người nhận:</label>
            <input type="text" name="tenNguoiNhan" id="tenNguoiNhan" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="soDienThoaiNhan">Số điện thoại nhận:</label>
            <input type="text" name="soDienThoaiNhan" id="soDienThoaiNhan" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="diaChiNhan">Địa chỉ nhận:</label>
            <input type="text" name="diaChiNhan" id="diaChiNhan" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Gửi yêu cầu</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>