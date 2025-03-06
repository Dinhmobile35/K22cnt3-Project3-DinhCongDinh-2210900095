package dao;

import model.YeuCauChinhSua;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class YeuCauChinhSuaDAO {
    public void addYeuCau(YeuCauChinhSua yeuCau) throws SQLException {
        String sql = "INSERT INTO DCD_YeuCauChinhSua (DCD_CCCD, DCD_TruongCanSua, DCD_GiaTriMoi) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, yeuCau.getCccd());
            stmt.setString(2, yeuCau.getTruongCanSua());
            stmt.setString(3, yeuCau.getGiaTriMoi());
            stmt.executeUpdate();
        }
    }

    public List<YeuCauChinhSua> getAllYeuCau() throws SQLException {
        List<YeuCauChinhSua> list = new ArrayList<>();
        String sql = "SELECT * FROM DCD_YeuCauChinhSua WHERE DCD_TrangThai = 'CHO_DUYET'";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new YeuCauChinhSua(
                        rs.getInt("DCD_MaYeuCau"),
                        rs.getString("DCD_CCCD"),
                        rs.getString("DCD_TruongCanSua"),
                        rs.getString("DCD_GiaTriMoi"),
                        rs.getString("DCD_TrangThai")
                ));
            }
        }
        return list;
    }

    public void approveYeuCau(int maYeuCau) throws SQLException {
        String sql = "UPDATE DCD_YeuCauChinhSua SET DCD_TrangThai = 'DA_DUYET' WHERE DCD_MaYeuCau = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maYeuCau);
            stmt.executeUpdate();
        }
    }

    public void rejectYeuCau(int maYeuCau) throws SQLException {
        String sql = "UPDATE DCD_YeuCauChinhSua SET DCD_TrangThai = 'TU_CHOI' WHERE DCD_MaYeuCau = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maYeuCau);
            stmt.executeUpdate();
        }
    }
}