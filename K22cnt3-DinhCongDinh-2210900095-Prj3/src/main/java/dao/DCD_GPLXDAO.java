package dao;

import model.DCD_GiayPhepLaiXe;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DCD_GPLXDAO {
    public List<DCD_GiayPhepLaiXe> getAll() {
        List<DCD_GiayPhepLaiXe> list = new ArrayList<>();
        String sql = "SELECT * FROM DCD_GiayPhepLaiXe";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                DCD_GiayPhepLaiXe gplx = new DCD_GiayPhepLaiXe();
                gplx.setDCD_SoGPLX(rs.getString("DCD_SoGPLX"));
                gplx.setDCD_CCCD(rs.getString("DCD_CCCD"));
                gplx.setDCD_HangGPLX(rs.getString("DCD_HangGPLX"));
                gplx.setDCD_NgayCap(rs.getDate("DCD_NgayCap"));
                gplx.setDCD_NgayHetHan(rs.getDate("DCD_NgayHetHan"));
                gplx.setDCD_NoiCap(rs.getString("DCD_NoiCap"));
                gplx.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                gplx.setDCD_NgayTao(rs.getTimestamp("DCD_NgayTao"));
                list.add(gplx);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public DCD_GiayPhepLaiXe getBySoGPLX(String soGPLX) {
        DCD_GiayPhepLaiXe gplx = null;
        String sql = "SELECT * FROM DCD_GiayPhepLaiXe WHERE DCD_SoGPLX = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, soGPLX);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    gplx = new DCD_GiayPhepLaiXe();
                    gplx.setDCD_SoGPLX(rs.getString("DCD_SoGPLX"));
                    gplx.setDCD_CCCD(rs.getString("DCD_CCCD"));
                    gplx.setDCD_HangGPLX(rs.getString("DCD_HangGPLX"));
                    gplx.setDCD_NgayCap(rs.getDate("DCD_NgayCap"));
                    gplx.setDCD_NgayHetHan(rs.getDate("DCD_NgayHetHan"));
                    gplx.setDCD_NoiCap(rs.getString("DCD_NoiCap"));
                    gplx.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                    gplx.setDCD_NgayTao(rs.getTimestamp("DCD_NgayTao"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gplx;
    }

    public boolean create(DCD_GiayPhepLaiXe gplx) {
        String sql = "INSERT INTO DCD_GiayPhepLaiXe (DCD_SoGPLX, DCD_CCCD, DCD_HangGPLX, DCD_NgayCap, DCD_NgayHetHan, DCD_NoiCap, DCD_TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, gplx.getDCD_SoGPLX());
            stmt.setString(2, gplx.getDCD_CCCD());
            stmt.setString(3, gplx.getDCD_HangGPLX());
            stmt.setDate(4, gplx.getDCD_NgayCap());
            stmt.setDate(5, gplx.getDCD_NgayHetHan());
            stmt.setString(6, gplx.getDCD_NoiCap());
            stmt.setString(7, gplx.getDCD_TrangThai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(DCD_GiayPhepLaiXe gplx) {
        String sql = "UPDATE DCD_GiayPhepLaiXe SET DCD_CCCD = ?, DCD_HangGPLX = ?, DCD_NgayCap = ?, DCD_NgayHetHan = ?, DCD_NoiCap = ?, DCD_TrangThai = ? WHERE DCD_SoGPLX = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, gplx.getDCD_CCCD());
            stmt.setString(2, gplx.getDCD_HangGPLX());
            stmt.setDate(3, gplx.getDCD_NgayCap());
            stmt.setDate(4, gplx.getDCD_NgayHetHan());
            stmt.setString(5, gplx.getDCD_NoiCap());
            stmt.setString(6, gplx.getDCD_TrangThai());
            stmt.setString(7, gplx.getDCD_SoGPLX());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String soGPLX) {
        String sql = "DELETE FROM DCD_GiayPhepLaiXe WHERE DCD_SoGPLX = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, soGPLX);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}