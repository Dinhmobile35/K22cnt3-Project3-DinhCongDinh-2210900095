package dao;

import model.YeuCauCapLai;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class YeuCauCapLaiDAO {
    public void addYeuCau(YeuCauCapLai yeuCau) throws SQLException {
        String sql = "INSERT INTO DCD_YeuCauCapLai (DCD_CCCD, DCD_LoaiYeuCau, DCD_TenNguoiNhan, DCD_SoDienThoaiNhan, DCD_DiaChiNhan) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, yeuCau.getCccd());
            stmt.setString(2, yeuCau.getLoaiYeuCau());
            stmt.setString(3, yeuCau.getTenNguoiNhan());
            stmt.setString(4, yeuCau.getSoDienThoaiNhan());
            stmt.setString(5, yeuCau.getDiaChiNhan());
            stmt.executeUpdate();
        }
    }

    public List<YeuCauCapLai> getAllYeuCau() throws SQLException {
        List<YeuCauCapLai> list = new ArrayList<>();
        String sql = "SELECT * FROM DCD_YeuCauCapLai WHERE DCD_TrangThai = 'CHO_DUYET'";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new YeuCauCapLai(
                        rs.getInt("DCD_MaYeuCau"),
                        rs.getString("DCD_CCCD"),
                        rs.getString("DCD_LoaiYeuCau"),
                        rs.getString("DCD_TrangThai"),
                        rs.getString("DCD_TrangThaiGiaoHang"),
                        rs.getString("DCD_TenNguoiNhan"),
                        rs.getString("DCD_SoDienThoaiNhan"),
                        rs.getString("DCD_DiaChiNhan")
                ));
            }
        }
        return list;
    }

    public void approveYeuCau(int maYeuCau) throws SQLException {
        String sql = "UPDATE DCD_YeuCauCapLai SET DCD_TrangThai = 'DA_DUYET' WHERE DCD_MaYeuCau = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maYeuCau);
            stmt.executeUpdate();
        }
    }

    public void rejectYeuCau(int maYeuCau) throws SQLException {
        String sql = "UPDATE DCD_YeuCauCapLai SET DCD_TrangThai = 'TU_CHOI' WHERE DCD_MaYeuCau = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maYeuCau);
            stmt.executeUpdate();
        }
    }
}