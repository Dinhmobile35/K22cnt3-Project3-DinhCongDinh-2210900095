<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách yêu cầu đổi mật khẩu</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Danh sách yêu cầu đổi mật khẩu</h2>
    <a href="${pageContext.request.contextPath}/admin/dashboard" class="btn btn-secondary mb-3">Quay lại Dashboard</a>
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th>Mã Yêu Cầu</th>
            <th>Số Điện Thoại</th>
            <th>Mật Khẩu Mới</th>
            <th>Trạng Thái</th>
            <th>Ngày Tạo</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty doiMatKhauRequests}">
            <c:forEach var="request" items="${doiMatKhauRequests}">
                <tr>
                    <td>${request.maYeuCau}</td>
                    <td>${request.soDienThoai}</td>
                    <td>${request.matKhauMoi}</td>
                    <td>${request.trangThai}</td>
                    <td>${request.ngayTao}</td>
                    <td>
                        <c:if test="${request.trangThai == 'CHO_DUYET'}">
                            <form action="${pageContext.request.contextPath}/admin/dashboard" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="approveDoiMatKhau">
                                <input type="hidden" name="maYeuCau" value="${request.maYeuCau}">
                                <button type="submit" class="btn btn-primary">Duyệt</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/admin/dashboard" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="rejectDoiMatKhau">
                                <input type="hidden" name="maYeuCau" value="${request.maYeuCau}">
                                <button type="submit" class="btn btn-danger">Từ chối</button>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty doiMatKhauRequests}">
            <tr>
                <td colspan="6">Không có yêu cầu đổi mật khẩu nào.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>