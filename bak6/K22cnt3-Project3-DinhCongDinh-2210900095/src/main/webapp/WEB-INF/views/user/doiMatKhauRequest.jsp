<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Yêu cầu đổi mật khẩu</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Yêu cầu đổi mật khẩu</h2>
    <a href="${pageContext.request.contextPath}/user/userDashboard" class="btn btn-secondary mb-3">Quay lại</a>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <input type="hidden" name="action" value="submitDoiMatKhau">
        <div class="form-group">
            <label for="matKhauMoi">Mật khẩu mới:</label>
            <input type="password" name="matKhauMoi" id="matKhauMoi" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Gửi yêu cầu</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>