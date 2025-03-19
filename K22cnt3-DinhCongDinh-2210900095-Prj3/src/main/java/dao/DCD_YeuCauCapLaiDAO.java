package dao;

import model.DCD_YeuCauCapLai;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DCD_YeuCauCapLaiDAO {
    public List<DCD_YeuCauCapLai> getAll() {
        List<DCD_YeuCauCapLai> list = new ArrayList<>();
        String sql = "SELECT * FROM DCD_YeuCauCapLai";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                DCD_YeuCauCapLai yeuCau = new DCD_YeuCauCapLai();
                yeuCau.setDCD_MaYeuCau(rs.getInt("DCD_MaYeuCau"));
                yeuCau.setDCD_CCCD(rs.getString("DCD_CCCD"));
                yeuCau.setDCD_LoaiYeuCau(rs.getString("DCD_LoaiYeuCau"));
                yeuCau.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                yeuCau.setDCD_TrangThaiGiaoHang(rs.getString("DCD_TrangThaiGiaoHang"));
                yeuCau.setDCD_TenNguoiNhan(rs.getString("DCD_TenNguoiNhan"));
                yeuCau.setDCD_SoDienThoaiNhan(rs.getString("DCD_SoDienThoaiNhan"));
                yeuCau.setDCD_DiaChiNhan(rs.getString("DCD_DiaChiNhan"));
                yeuCau.setDCD_NgayTao(rs.getTimestamp("DCD_NgayTao"));
                yeuCau.setDCD_NgayCapNhat(rs.getTimestamp("DCD_NgayCapNhat"));
                list.add(yeuCau);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<DCD_YeuCauCapLai> getByCCCD(String cccd) {
        List<DCD_YeuCauCapLai> list = new ArrayList<>();
        String sql = "SELECT * FROM DCD_YeuCauCapLai WHERE DCD_CCCD = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cccd);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    DCD_YeuCauCapLai yeuCau = new DCD_YeuCauCapLai();
                    yeuCau.setDCD_MaYeuCau(rs.getInt("DCD_MaYeuCau"));
                    yeuCau.setDCD_CCCD(rs.getString("DCD_CCCD"));
                    yeuCau.setDCD_LoaiYeuCau(rs.getString("DCD_LoaiYeuCau"));
                    yeuCau.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                    yeuCau.setDCD_TrangThaiGiaoHang(rs.getString("DCD_TrangThaiGiaoHang"));
                    yeuCau.setDCD_TenNguoiNhan(rs.getString("DCD_TenNguoiNhan"));
                    yeuCau.setDCD_SoDienThoaiNhan(rs.getString("DCD_SoDienThoaiNhan"));
                    yeuCau.setDCD_DiaChiNhan(rs.getString("DCD_DiaChiNhan"));
                    yeuCau.setDCD_NgayTao(rs.getTimestamp("DCD_NgayTao"));
                    yeuCau.setDCD_NgayCapNhat(rs.getTimestamp("DCD_NgayCapNhat"));
                    list.add(yeuCau);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean create(DCD_YeuCauCapLai yeuCau) {
        String sql = "INSERT INTO DCD_YeuCauCapLai (DCD_CCCD, DCD_LoaiYeuCau, DCD_TrangThai, DCD_TrangThaiGiaoHang, DCD_TenNguoiNhan, DCD_SoDienThoaiNhan, DCD_DiaChiNhan) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, yeuCau.getDCD_CCCD());
            stmt.setString(2, yeuCau.getDCD_LoaiYeuCau());
            stmt.setString(3, yeuCau.getDCD_TrangThai());
            stmt.setString(4, yeuCau.getDCD_TrangThaiGiaoHang());
            stmt.setString(5, yeuCau.getDCD_TenNguoiNhan());
            stmt.setString(6, yeuCau.getDCD_SoDienThoaiNhan());
            stmt.setString(7, yeuCau.getDCD_DiaChiNhan());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTrangThai(int maYeuCau, String trangThai) {
        String sql = "UPDATE DCD_YeuCauCapLai SET DCD_TrangThai = ? WHERE DCD_MaYeuCau = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trangThai);
            stmt.setInt(2, maYeuCau);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTrangThaiGiaoHang(int maYeuCau, String trangThaiGiaoHang) {
        String sql = "UPDATE DCD_YeuCauCapLai SET DCD_TrangThaiGiaoHang = ? WHERE DCD_MaYeuCau = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trangThaiGiaoHang);
            stmt.setInt(2, maYeuCau);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}