<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:if test="${not empty message}">
        <p style="color: green">${message}</p>
    </c:if>
    <c:if test="${not empty error}">
        <p style="color: red">${error}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <input type="hidden" name="action" value="submitCapLai">
        <div class="form-group">
            <label>Loại yêu cầu:</label>
            <select name="loaiYeuCau" class="form-control" required>
                <option value="MOI">Mới</option>
                <option value="CAP_LAI">Cấp lại</option>
                <option value="MAT">Mất</option>
            </select>
        </div>
        <div class="form-group">
            <label>Tên người nhận:</label>
            <input type="text" name="tenNguoiNhan" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Số điện thoại nhận:</label>
            <input type="text" name="soDienThoaiNhan" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Địa chỉ nhận:</label>
            <textarea name="diaChiNhan" class="form-control" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Gửi yêu cầu</button>
        <a href="${pageContext.request.contextPath}/user" class="btn btn-secondary">Hủy</a>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>