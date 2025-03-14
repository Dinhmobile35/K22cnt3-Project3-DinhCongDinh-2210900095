<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Yêu cầu chỉnh sửa thông tin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Yêu cầu chỉnh sửa thông tin</h2>
    <a href="${pageContext.request.contextPath}/user/userDashboard" class="btn btn-secondary mb-3">Quay lại</a>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <input type="hidden" name="action" value="submitChinhSua">
        <div class="form-group">
            <label for="truongCanSua">Trường cần sửa:</label>
            <select name="truongCanSua" id="truongCanSua" class="form-control" required>
                <option value="DCD_SoDienThoai">Số điện thoại</option>
                <option value="DCD_Email">Email</option>
            </select>
        </div>
        <div class="form-group">
            <label for="giaTriMoi">Giá trị mới:</label>
            <input type="text" name="giaTriMoi" id="giaTriMoi" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Gửi yêu cầu</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>