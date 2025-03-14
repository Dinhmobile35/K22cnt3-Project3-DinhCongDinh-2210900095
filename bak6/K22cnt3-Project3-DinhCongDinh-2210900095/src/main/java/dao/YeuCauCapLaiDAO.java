package dao;

import model.YeuCauCapLai;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class YeuCauCapLaiDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/K22cnt3_DinhCongDinh_2210900095_Project3_db?useSSL=false&allowPublicKeyRetrieval=true";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456"; // Thay bằng mật khẩu MySQL của bạn

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL Driver not found", e);
        }
        return connection;
    }

    public List<YeuCauCapLai> getAllCapLaiRequests() throws SQLException {
        List<YeuCauCapLai> requests = new ArrayList<>();
        String query = "SELECT * FROM DCD_YeuCauCapLai";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int maYeuCau = rs.getInt("DCD_MaYeuCau");
                String cccd = rs.getString("DCD_CCCD");
                String loaiYeuCau = rs.getString("DCD_LoaiYeuCau");
                String trangThai = rs.getString("DCD_TrangThai");
                String trangThaiGiaoHang = rs.getString("DCD_TrangThaiGiaoHang");
                String tenNguoiNhan = rs.getString("DCD_TenNguoiNhan");
                String soDienThoaiNhan = rs.getString("DCD_SoDienThoaiNhan");
                String diaChiNhan = rs.getString("DCD_DiaChiNhan");
                Timestamp ngayTao = rs.getTimestamp("DCD_NgayTao");
                Timestamp ngayCapNhat = rs.getTimestamp("DCD_NgayCapNhat");
                requests.add(new YeuCauCapLai(maYeuCau, cccd, loaiYeuCau, trangThai, trangThaiGiaoHang, tenNguoiNhan, soDienThoaiNhan, diaChiNhan, ngayTao, ngayCapNhat));
            }
        }
        return requests;
    }
}