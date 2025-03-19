package dao;

import model.DCD_BaoHiemYTe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DCD_BaoHiemYTeDAO {
    private String url = "jdbc:mysql://localhost:3306/K22cnt3_DinhCongDinh_2210900095_Prj3_db";
    private String username = "root";
    private String password = "123456";

    public DCD_BaoHiemYTe getByCCCD(String cccd) {
        DCD_BaoHiemYTe bhyt = null;
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM DCD_BaoHiemYTe WHERE DCD_CCCD = ?")) {
            stmt.setString(1, cccd);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                bhyt = new DCD_BaoHiemYTe();
                bhyt.setDCD_MaBHYT(rs.getString("DCD_MaBHYT"));
                bhyt.setDCD_CCCD(rs.getString("DCD_CCCD"));
                bhyt.setDCD_NgayCap(rs.getDate("DCD_NgayCap"));
                bhyt.setDCD_NgayHetHan(rs.getDate("DCD_NgayHetHan"));
                bhyt.setDCD_NoiDangKyKhamBenh(rs.getString("DCD_NoiDangKyKhamBenh"));
                bhyt.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                bhyt.setDCD_NgayTao(rs.getDate("DCD_NgayTao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bhyt;
    }

    public List<DCD_BaoHiemYTe> getAll() {
        List<DCD_BaoHiemYTe> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM DCD_BaoHiemYTe")) {
            while (rs.next()) {
                DCD_BaoHiemYTe bhyt = new DCD_BaoHiemYTe();
                bhyt.setDCD_MaBHYT(rs.getString("DCD_MaBHYT"));
                bhyt.setDCD_CCCD(rs.getString("DCD_CCCD"));
                bhyt.setDCD_NgayCap(rs.getDate("DCD_NgayCap"));
                bhyt.setDCD_NgayHetHan(rs.getDate("DCD_NgayHetHan"));
                bhyt.setDCD_NoiDangKyKhamBenh(rs.getString("DCD_NoiDangKyKhamBenh"));
                bhyt.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                bhyt.setDCD_NgayTao(rs.getDate("DCD_NgayTao"));
                list.add(bhyt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean create(DCD_BaoHiemYTe bhyt) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO DCD_BaoHiemYTe (DCD_MaBHYT, DCD_CCCD, DCD_NgayCap, DCD_NgayHetHan, DCD_NoiDangKyKhamBenh, DCD_TrangThai) VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, bhyt.getDCD_MaBHYT());
            stmt.setString(2, bhyt.getDCD_CCCD());
            stmt.setDate(3, bhyt.getDCD_NgayCap());
            stmt.setDate(4, bhyt.getDCD_NgayHetHan());
            stmt.setString(5, bhyt.getDCD_NoiDangKyKhamBenh());
            stmt.setString(6, bhyt.getDCD_TrangThai());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(DCD_BaoHiemYTe bhyt) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("UPDATE DCD_BaoHiemYTe SET DCD_NgayCap = ?, DCD_NgayHetHan = ?, DCD_NoiDangKyKhamBenh = ?, DCD_TrangThai = ? WHERE DCD_MaBHYT = ? AND DCD_CCCD = ?")) {
            stmt.setDate(1, bhyt.getDCD_NgayCap());
            stmt.setDate(2, bhyt.getDCD_NgayHetHan());
            stmt.setString(3, bhyt.getDCD_NoiDangKyKhamBenh());
            stmt.setString(4, bhyt.getDCD_TrangThai());
            stmt.setString(5, bhyt.getDCD_MaBHYT());
            stmt.setString(6, bhyt.getDCD_CCCD());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String maBHYT, String cccd) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM DCD_BaoHiemYTe WHERE DCD_MaBHYT = ? AND DCD_CCCD = ?")) {
            stmt.setString(1, maBHYT);
            stmt.setString(2, cccd);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}