<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Yêu Cầu Chỉnh Sửa Thông Tin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Hệ Thống CCCD</a>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <form action="${pageContext.request.contextPath}/logout" method="post" style="display: inline;">
                    <button type="submit" class="btn btn-danger">Đăng xuất</button>
                </form>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <h2>Yêu Cầu Chỉnh Sửa Thông Tin</h2>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
    <form action="${pageContext.request.contextPath}/user?action=submitChinhSua" method="post">
        <div class="form-group">
            <label for="truongCanSua">Trường cần sửa:</label>
            <select class="form-control" id="truongCanSua" name="truongCanSua" required>
                <option value="DCD_SoDienThoai">Số điện thoại</option>
                <option value="DCD_Email">Email</option>
            </select>
        </div>
        <div class="form-group">
            <label for="giaTriMoi">Giá trị mới:</label>
            <input type="text" class="form-control" id="giaTriMoi" name="giaTriMoi" required>
        </div>
        <button type="submit" class="btn btn-primary">Gửi yêu cầu</button>
        <a href="${pageContext.request.contextPath}/user" class="btn btn-secondary">Hủy</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script>
    if (typeof jQuery == 'undefined') {
        document.write('<script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.slim.min.js"><\/script>');
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
    if (typeof bootstrap == 'undefined') {
        document.write('<script src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js"><\/script>');
    }
</script>
</body>
</html>