package dao;

import model.CongDan;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CongDanDAO {
    public void addCongDan(CongDan congDan) throws SQLException {
        String sql = "INSERT INTO DCD_CongDan (DCD_CCCD, DCD_HoTen, DCD_NgaySinh, DCD_GioiTinh, DCD_SoDienThoai, DCD_Email, DCD_DiaChi, DCD_NgayCap, DCD_NgayHetHan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, congDan.getCccd());
            stmt.setString(2, congDan.getHoTen());
            stmt.setDate(3, congDan.getNgaySinh());
            stmt.setString(4, congDan.getGioiTinh());
            stmt.setString(5, congDan.getSoDienThoai());
            stmt.setString(6, congDan.getEmail());
            stmt.setString(7, congDan.getDiaChi());
            stmt.setDate(8, congDan.getNgayCap());
            stmt.setDate(9, congDan.getNgayHetHan());
            stmt.executeUpdate();
        } // Connection tự động đóng nhờ try-with-resources
    }

    public CongDan getCongDan(String cccd) throws SQLException {
        String sql = "SELECT * FROM DCD_CongDan WHERE DCD_CCCD = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cccd);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new CongDan(
                        rs.getString("DCD_CCCD"),
                        rs.getString("DCD_HoTen"),
                        rs.getDate("DCD_NgaySinh"),
                        rs.getString("DCD_GioiTinh"),
                        rs.getString("DCD_SoDienThoai"),
                        rs.getString("DCD_Email"),
                        rs.getString("DCD_DiaChi"),
                        rs.getDate("DCD_NgayCap"),
                        rs.getDate("DCD_NgayHetHan")
                );
            }
            return null;
        }
    }

    public void updateCongDan(CongDan congDan) throws SQLException {
        String sql = "UPDATE DCD_CongDan SET DCD_HoTen = ?, DCD_NgaySinh = ?, DCD_GioiTinh = ?, DCD_SoDienThoai = ?, DCD_Email = ?, DCD_DiaChi = ?, DCD_NgayCap = ?, DCD_NgayHetHan = ? WHERE DCD_CCCD = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, congDan.getHoTen());
            stmt.setDate(2, congDan.getNgaySinh());
            stmt.setString(3, congDan.getGioiTinh());
            stmt.setString(4, congDan.getSoDienThoai());
            stmt.setString(5, congDan.getEmail());
            stmt.setString(6, congDan.getDiaChi());
            stmt.setDate(7, congDan.getNgayCap());
            stmt.setDate(8, congDan.getNgayHetHan());
            stmt.setString(9, congDan.getCccd());
            stmt.executeUpdate();
        }
    }

    public void deleteCongDan(String cccd) throws SQLException {
        String sql = "DELETE FROM DCD_CongDan WHERE DCD_CCCD = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cccd);
            stmt.executeUpdate();
        }
    }

    public List<CongDan> getAllCongDan() throws SQLException {
        List<CongDan> list = new ArrayList<>();
        String sql = "SELECT * FROM DCD_CongDan";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new CongDan(
                        rs.getString("DCD_CCCD"),
                        rs.getString("DCD_HoTen"),
                        rs.getDate("DCD_NgaySinh"),
                        rs.getString("DCD_GioiTinh"),
                        rs.getString("DCD_SoDienThoai"),
                        rs.getString("DCD_Email"),
                        rs.getString("DCD_DiaChi"),
                        rs.getDate("DCD_NgayCap"),
                        rs.getDate("DCD_NgayHetHan")
                ));
            }
        }
        return list;
    }
}