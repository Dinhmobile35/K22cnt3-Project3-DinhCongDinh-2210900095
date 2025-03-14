<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách công dân</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 80%; border-collapse: collapse; margin: 20px 0; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .logout { float: right; }
    </style>
</head>
<body>
<div class="logout">
    <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</div>
<h2>Danh sách công dân</h2>
<table>
    <tr>
        <th>CCCD</th>
        <th>Họ tên</th>
        <th>Ngày sinh</th>
        <th>Giới tính</th>
        <th>Số điện thoại</th>
        <th>Email</th>
        <th>Địa chỉ</th>
        <th>Ngày cấp</th>
        <th>Ngày hết hạn</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="congDan" items="${congDanList}">
        <tr>
            <td><c:out value="${congDan.cccd}" /></td>
            <td><c:out value="${congDan.hoTen}" /></td>
            <td><c:out value="${congDan.ngaySinh}" /></td>
            <td><c:out value="${congDan.gioiTinh}" /></td>
            <td><c:out value="${congDan.soDienThoai}" /></td>
            <td><c:out value="${congDan.email}" /></td>
            <td><c:out value="${congDan.diaChi}" /></td>
            <td><c:out value="${congDan.ngayCap}" /></td>
            <td><c:out value="${congDan.ngayHetHan}" /></td>
            <td>
                <a href="${pageContext.request.contextPath}/user/congdan?action=view&cccd=${congDan.cccd}">Xem chi tiết</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>