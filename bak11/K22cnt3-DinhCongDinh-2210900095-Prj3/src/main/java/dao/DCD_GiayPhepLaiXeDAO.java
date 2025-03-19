package dao;

import model.DCD_GiayPhepLaiXe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DCD_GiayPhepLaiXeDAO {
    private String url = "jdbc:mysql://localhost:3306/K22cnt3_DinhCongDinh_2210900095_Prj3_db";
    private String username = "root";
    private String password = "123456";

    public DCD_GiayPhepLaiXe getByCCCD(String cccd) {
        DCD_GiayPhepLaiXe gplx = null;
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM DCD_GiayPhepLaiXe WHERE DCD_CCCD = ?")) {
            stmt.setString(1, cccd);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                gplx = new DCD_GiayPhepLaiXe();
                gplx.setDCD_SoGPLX(rs.getString("DCD_SoGPLX"));
                gplx.setDCD_CCCD(rs.getString("DCD_CCCD"));
                gplx.setDCD_LoaiGPLX(rs.getString("DCD_LoaiGPLX"));
                gplx.setDCD_NgayCap(rs.getDate("DCD_NgayCap"));
                gplx.setDCD_NgayHetHan(rs.getDate("DCD_NgayHetHan"));
                gplx.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                gplx.setDCD_NgayTao(rs.getDate("DCD_NgayTao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gplx;
    }

    public List<DCD_GiayPhepLaiXe> getAll() {
        List<DCD_GiayPhepLaiXe> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM DCD_GiayPhepLaiXe")) {
            while (rs.next()) {
                DCD_GiayPhepLaiXe gplx = new DCD_GiayPhepLaiXe();
                gplx.setDCD_SoGPLX(rs.getString("DCD_SoGPLX"));
                gplx.setDCD_CCCD(rs.getString("DCD_CCCD"));
                gplx.setDCD_LoaiGPLX(rs.getString("DCD_LoaiGPLX"));
                gplx.setDCD_NgayCap(rs.getDate("DCD_NgayCap"));
                gplx.setDCD_NgayHetHan(rs.getDate("DCD_NgayHetHan"));
                gplx.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                gplx.setDCD_NgayTao(rs.getDate("DCD_NgayTao"));
                list.add(gplx);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean create(DCD_GiayPhepLaiXe gplx) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO DCD_GiayPhepLaiXe (DCD_SoGPLX, DCD_CCCD, DCD_LoaiGPLX, DCD_NgayCap, DCD_NgayHetHan, DCD_TrangThai) VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, gplx.getDCD_SoGPLX());
            stmt.setString(2, gplx.getDCD_CCCD());
            stmt.setString(3, gplx.getDCD_LoaiGPLX());
            stmt.setDate(4, gplx.getDCD_NgayCap());
            stmt.setDate(5, gplx.getDCD_NgayHetHan());
            stmt.setString(6, gplx.getDCD_TrangThai());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(DCD_GiayPhepLaiXe gplx) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("UPDATE DCD_GiayPhepLaiXe SET DCD_LoaiGPLX = ?, DCD_NgayCap = ?, DCD_NgayHetHan = ?, DCD_TrangThai = ? WHERE DCD_SoGPLX = ? AND DCD_CCCD = ?")) {
            stmt.setString(1, gplx.getDCD_LoaiGPLX());
            stmt.setDate(2, gplx.getDCD_NgayCap());
            stmt.setDate(3, gplx.getDCD_NgayHetHan());
            stmt.setString(4, gplx.getDCD_TrangThai());
            stmt.setString(5, gplx.getDCD_SoGPLX());
            stmt.setString(6, gplx.getDCD_CCCD());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String soGPLX, String cccd) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM DCD_GiayPhepLaiXe WHERE DCD_SoGPLX = ? AND DCD_CCCD = ?")) {
            stmt.setString(1, soGPLX);
            stmt.setString(2, cccd);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}