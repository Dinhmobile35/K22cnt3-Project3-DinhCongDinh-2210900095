package dao;

import model.DCD_CongDan;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DCD_CongDanDAO {
    public List<DCD_CongDan> getAll() {
        List<DCD_CongDan> list = new ArrayList<>();
        String sql = "SELECT * FROM DCD_CongDan";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                DCD_CongDan congDan = new DCD_CongDan();
                congDan.setDCD_CCCD(rs.getString("DCD_CCCD"));
                congDan.setDCD_HoTen(rs.getString("DCD_HoTen"));
                congDan.setDCD_NgaySinh(rs.getDate("DCD_NgaySinh"));
                congDan.setDCD_GioiTinh(rs.getString("DCD_GioiTinh"));
                congDan.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                congDan.setDCD_VaiTro(rs.getString("DCD_VaiTro"));
                congDan.setDCD_MatKhau(rs.getString("DCD_MatKhau"));
                list.add(congDan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public DCD_CongDan getByCCCD(String cccd) {
        DCD_CongDan congDan = null;
        String sql = "SELECT * FROM DCD_CongDan WHERE DCD_CCCD = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cccd);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    congDan = new DCD_CongDan();
                    congDan.setDCD_CCCD(rs.getString("DCD_CCCD"));
                    congDan.setDCD_HoTen(rs.getString("DCD_HoTen"));
                    congDan.setDCD_NgaySinh(rs.getDate("DCD_NgaySinh"));
                    congDan.setDCD_GioiTinh(rs.getString("DCD_GioiTinh"));
                    congDan.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                    congDan.setDCD_VaiTro(rs.getString("DCD_VaiTro"));
                    congDan.setDCD_MatKhau(rs.getString("DCD_MatKhau"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return congDan;
    }

    public DCD_CongDan login(String cccd, String matKhau) {
        DCD_CongDan congDan = null;
        String sql = "SELECT * FROM DCD_CongDan WHERE DCD_CCCD = ? AND DCD_MatKhau = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cccd);
            stmt.setString(2, matKhau);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    congDan = new DCD_CongDan();
                    congDan.setDCD_CCCD(rs.getString("DCD_CCCD"));
                    congDan.setDCD_HoTen(rs.getString("DCD_HoTen"));
                    congDan.setDCD_NgaySinh(rs.getDate("DCD_NgaySinh"));
                    congDan.setDCD_GioiTinh(rs.getString("DCD_GioiTinh"));
                    congDan.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                    congDan.setDCD_VaiTro(rs.getString("DCD_VaiTro"));
                    congDan.setDCD_MatKhau(rs.getString("DCD_MatKhau"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return congDan;
    }

    // Thêm công dân mới
    public boolean create(DCD_CongDan congDan) {
        String sql = "INSERT INTO DCD_CongDan (DCD_CCCD, DCD_HoTen, DCD_NgaySinh, DCD_GioiTinh, DCD_TrangThai, DCD_VaiTro, DCD_MatKhau) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, congDan.getDCD_CCCD());
            stmt.setString(2, congDan.getDCD_HoTen());
            stmt.setDate(3, congDan.getDCD_NgaySinh());
            stmt.setString(4, congDan.getDCD_GioiTinh());
            stmt.setString(5, congDan.getDCD_TrangThai());
            stmt.setString(6, congDan.getDCD_VaiTro());
            stmt.setString(7, congDan.getDCD_MatKhau());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật thông tin công dân
    public boolean update(DCD_CongDan congDan) {
        String sql = "UPDATE DCD_CongDan SET DCD_HoTen = ?, DCD_NgaySinh = ?, DCD_GioiTinh = ?, DCD_TrangThai = ?, DCD_VaiTro = ?, DCD_MatKhau = ? WHERE DCD_CCCD = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, congDan.getDCD_HoTen());
            stmt.setDate(2, congDan.getDCD_NgaySinh());
            stmt.setString(3, congDan.getDCD_GioiTinh());
            stmt.setString(4, congDan.getDCD_TrangThai());
            stmt.setString(5, congDan.getDCD_VaiTro());
            stmt.setString(6, congDan.getDCD_MatKhau());
            stmt.setString(7, congDan.getDCD_CCCD());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa công dân
    public boolean delete(String cccd) {
        String sql = "DELETE FROM DCD_CongDan WHERE DCD_CCCD = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cccd);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}