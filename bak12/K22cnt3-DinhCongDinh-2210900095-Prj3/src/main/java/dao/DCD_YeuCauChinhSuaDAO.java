package dao;

import model.DCD_YeuCauChinhSua;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DCD_YeuCauChinhSuaDAO {
    private String url = "jdbc:mysql://localhost:3306/K22cnt3_DinhCongDinh_2210900095_Prj3_db";
    private String username = "root";
    private String password = "123456";

    public DCD_YeuCauChinhSua getById(int maYeuCau) {
        DCD_YeuCauChinhSua yeuCau = null;
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM DCD_YeuCauChinhSua WHERE DCD_MaYeuCau = ?")) {
            stmt.setInt(1, maYeuCau);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                yeuCau = new DCD_YeuCauChinhSua();
                yeuCau.setDCD_MaYeuCau(rs.getInt("DCD_MaYeuCau"));
                yeuCau.setDCD_CCCD(rs.getString("DCD_CCCD"));
                yeuCau.setDCD_TruongCanSua(rs.getString("DCD_TruongCanSua"));
                yeuCau.setDCD_GiaTriMoi(rs.getString("DCD_GiaTriMoi"));
                yeuCau.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                yeuCau.setDCD_NgayTao(rs.getDate("DCD_NgayTao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return yeuCau;
    }

    public List<DCD_YeuCauChinhSua> getAll() {
        List<DCD_YeuCauChinhSua> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM DCD_YeuCauChinhSua")) {
            while (rs.next()) {
                DCD_YeuCauChinhSua yeuCau = new DCD_YeuCauChinhSua();
                yeuCau.setDCD_MaYeuCau(rs.getInt("DCD_MaYeuCau"));
                yeuCau.setDCD_CCCD(rs.getString("DCD_CCCD"));
                yeuCau.setDCD_TruongCanSua(rs.getString("DCD_TruongCanSua"));
                yeuCau.setDCD_GiaTriMoi(rs.getString("DCD_GiaTriMoi"));
                yeuCau.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                yeuCau.setDCD_NgayTao(rs.getDate("DCD_NgayTao"));
                list.add(yeuCau);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean create(DCD_YeuCauChinhSua yeuCau) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO DCD_YeuCauChinhSua (DCD_CCCD, DCD_TruongCanSua, DCD_GiaTriMoi, DCD_TrangThai) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, yeuCau.getDCD_CCCD());
            stmt.setString(2, yeuCau.getDCD_TruongCanSua());
            stmt.setString(3, yeuCau.getDCD_GiaTriMoi());
            stmt.setString(4, yeuCau.getDCD_TrangThai());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(DCD_YeuCauChinhSua yeuCau) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("UPDATE DCD_YeuCauChinhSua SET DCD_TrangThai = ? WHERE DCD_MaYeuCau = ?")) {
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
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM DCD_YeuCauChinhSua WHERE DCD_MaYeuCau = ?")) {
            stmt.setInt(1, maYeuCau);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}