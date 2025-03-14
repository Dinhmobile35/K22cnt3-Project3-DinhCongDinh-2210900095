<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách yêu cầu cấp lại CCCD</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Danh sách yêu cầu cấp lại CCCD</h2>
    <a href="${pageContext.request.contextPath}/admin/dashboard" class="btn btn-secondary mb-3">Quay lại Dashboard</a>
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th>Mã Yêu Cầu</th>
            <th>CCCD</th>
            <th>Loại Yêu Cầu</th>
            <th>Trạng Thái</th>
            <th>Trạng Thái Giao Hàng</th>
            <th>Tên Người Nhận</th>
            <th>Số Điện Thoại Nhận</th>
            <th>Địa Chỉ Nhận</th>
            <th>Ngày Tạo</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty capLaiRequests}">
            <c:forEach var="request" items="${capLaiRequests}">
                <tr>
                    <td>${request.maYeuCau}</td>
                    <td>${request.cccd}</td>
                    <td>${request.loaiYeuCau}</td>
                    <td>${request.trangThai}</td>
                    <td>${request.trangThaiGiaoHang}</td>
                    <td>${request.tenNguoiNhan}</td>
                    <td>${request.soDienThoaiNhan}</td>
                    <td>${request.diaChiNhan}</td>
                    <td>${request.ngayTao}</td>
                    <td>
                        <c:if test="${request.trangThai == 'CHO_DUYET'}">
                            <form action="${pageContext.request.contextPath}/admin/dashboard" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="approveCapLai">
                                <input type="hidden" name="maYeuCau" value="${request.maYeuCau}">
                                <button type="submit" class="btn btn-primary">Duyệt</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/admin/dashboard" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="rejectCapLai">
                                <input type="hidden" name="maYeuCau" value="${request.maYeuCau}">
                                <button type="submit" class="btn btn-danger">Từ chối</button>
                            </form>
                        </c:if>
                        <c:if test="${request.trangThai == 'DA_DUYET'}">
                            <form action="${pageContext.request.contextPath}/admin/dashboard" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="updateDeliveryCapLai">
                                <input type="hidden" name="maYeuCau" value="${request.maYeuCau}">
                                <select name="trangThaiGiaoHang" onchange="this.form.submit()">
                                    <option value="CHUA_GIAO" ${request.trangThaiGiaoHang == 'CHUA_GIAO' ? 'selected' : ''}>Chưa giao</option>
                                    <option value="DANG_GIAO" ${request.trangThaiGiaoHang == 'DANG_GIAO' ? 'selected' : ''}>Đang giao</option>
                                    <option value="DA_NHAN" ${request.trangThaiGiaoHang == 'DA_NHAN' ? 'selected' : ''}>Đã nhận</option>
                                </select>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty capLaiRequests}">
            <tr>
                <td colspan="10">Không có yêu cầu cấp lại CCCD nào.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>