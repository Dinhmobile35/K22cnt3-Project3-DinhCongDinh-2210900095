package dao;

import model.DCD_YeuCauCapLai;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DCD_YeuCauCapLaiDAO {
    private String url = "jdbc:mysql://localhost:3306/K22cnt3_DinhCongDinh_2210900095_Prj3_db";
    private String username = "root";
    private String password = "123456";

    public DCD_YeuCauCapLai getById(int maYeuCau) {
        DCD_YeuCauCapLai yeuCau = null;
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM DCD_YeuCauCapLai WHERE DCD_MaYeuCau = ?")) {
            stmt.setInt(1, maYeuCau);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                yeuCau = new DCD_YeuCauCapLai();
                yeuCau.setDCD_MaYeuCau(rs.getInt("DCD_MaYeuCau"));
                yeuCau.setDCD_CCCD(rs.getString("DCD_CCCD"));
                yeuCau.setDCD_LoaiYeuCau(rs.getString("DCD_LoaiYeuCau"));
                yeuCau.setDCD_TenNguoiNhan(rs.getString("DCD_TenNguoiNhan"));
                yeuCau.setDCD_SoDienThoaiNhan(rs.getString("DCD_SoDienThoaiNhan"));
                yeuCau.setDCD_DiaChiNhan(rs.getString("DCD_DiaChiNhan"));
                yeuCau.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                yeuCau.setDCD_NgayTao(rs.getDate("DCD_NgayTao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return yeuCau;
    }

    public List<DCD_YeuCauCapLai> getAll() {
        List<DCD_YeuCauCapLai> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM DCD_YeuCauCapLai")) {
            while (rs.next()) {
                DCD_YeuCauCapLai yeuCau = new DCD_YeuCauCapLai();
                yeuCau.setDCD_MaYeuCau(rs.getInt("DCD_MaYeuCau"));
                yeuCau.setDCD_CCCD(rs.getString("DCD_CCCD"));
                yeuCau.setDCD_LoaiYeuCau(rs.getString("DCD_LoaiYeuCau"));
                yeuCau.setDCD_TenNguoiNhan(rs.getString("DCD_TenNguoiNhan"));
                yeuCau.setDCD_SoDienThoaiNhan(rs.getString("DCD_SoDienThoaiNhan"));
                yeuCau.setDCD_DiaChiNhan(rs.getString("DCD_DiaChiNhan"));
                yeuCau.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                yeuCau.setDCD_NgayTao(rs.getDate("DCD_NgayTao"));
                list.add(yeuCau);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean create(DCD_YeuCauCapLai yeuCau) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO DCD_YeuCauCapLai (DCD_CCCD, DCD_LoaiYeuCau, DCD_TenNguoiNhan, DCD_SoDienThoaiNhan, DCD_DiaChiNhan, DCD_TrangThai) VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, yeuCau.getDCD_CCCD());
            stmt.setString(2, yeuCau.getDCD_LoaiYeuCau());
            stmt.setString(3, yeuCau.getDCD_TenNguoiNhan());
            stmt.setString(4, yeuCau.getDCD_SoDienThoaiNhan());
            stmt.setString(5, yeuCau.getDCD_DiaChiNhan());
            stmt.setString(6, yeuCau.getDCD_TrangThai());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(DCD_YeuCauCapLai yeuCau) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("UPDATE DCD_YeuCauCapLai SET DCD_TrangThai = ? WHERE DCD_MaYeuCau = ?")) {
            stmt.setString(1, yeuCau.getDCD_TrangThai());
            stmt.setInt(2, yeuCau.getDCD_MaYeuCau());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int maYeuCau) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM DCD_YeuCauCapLai WHERE DCD_MaYeuCau = ?")) {
            stmt.setInt(1, maYeuCau);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}