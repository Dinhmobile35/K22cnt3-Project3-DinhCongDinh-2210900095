package dao;

import model.DCD_BaoHiemYTe;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DCD_BHYTDAO {
    public List<DCD_BaoHiemYTe> getAll() {
        List<DCD_BaoHiemYTe> list = new ArrayList<>();
        String sql = "SELECT * FROM DCD_BaoHiemYTe";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                DCD_BaoHiemYTe bhyt = new DCD_BaoHiemYTe();
                bhyt.setDCD_MaBHYT(rs.getString("DCD_MaBHYT"));
                bhyt.setDCD_CCCD(rs.getString("DCD_CCCD"));
                bhyt.setDCD_NgayCap(rs.getDate("DCD_NgayCap"));
                bhyt.setDCD_NgayHetHan(rs.getDate("DCD_NgayHetHan"));
                bhyt.setDCD_NoiDangKyKhamBenh(rs.getString("DCD_NoiDangKyKhamBenh"));
                bhyt.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                bhyt.setDCD_NgayTao(rs.getTimestamp("DCD_NgayTao")); // Đúng kiểu Timestamp
                list.add(bhyt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public DCD_BaoHiemYTe getByMaBHYT(String maBHYT) {
        DCD_BaoHiemYTe bhyt = null;
        String sql = "SELECT * FROM DCD_BaoHiemYTe WHERE DCD_MaBHYT = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maBHYT);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    bhyt = new DCD_BaoHiemYTe();
                    bhyt.setDCD_MaBHYT(rs.getString("DCD_MaBHYT"));
                    bhyt.setDCD_CCCD(rs.getString("DCD_CCCD"));
                    bhyt.setDCD_NgayCap(rs.getDate("DCD_NgayCap"));
                    bhyt.setDCD_NgayHetHan(rs.getDate("DCD_NgayHetHan"));
                    bhyt.setDCD_NoiDangKyKhamBenh(rs.getString("DCD_NoiDangKyKhamBenh"));
                    bhyt.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                    bhyt.setDCD_NgayTao(rs.getTimestamp("DCD_NgayTao")); // Đúng kiểu Timestamp
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bhyt;
    }

    public boolean create(DCD_BaoHiemYTe bhyt) {
        String sql = "INSERT INTO DCD_BaoHiemYTe (DCD_MaBHYT, DCD_CCCD, DCD_NgayCap, DCD_NgayHetHan, DCD_NoiDangKyKhamBenh, DCD_TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bhyt.getDCD_MaBHYT());
            stmt.setString(2, bhyt.getDCD_CCCD());
            stmt.setDate(3, bhyt.getDCD_NgayCap());
            stmt.setDate(4, bhyt.getDCD_NgayHetHan());
            stmt.setString(5, bhyt.getDCD_NoiDangKyKhamBenh());
            stmt.setString(6, bhyt.getDCD_TrangThai());
            // DCD_NgayTao không cần set vì đã có DEFAULT CURRENT_TIMESTAMP trong DB
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(DCD_BaoHiemYTe bhyt) {
        String sql = "UPDATE DCD_BaoHiemYTe SET DCD_CCCD = ?, DCD_NgayCap = ?, DCD_NgayHetHan = ?, DCD_NoiDangKyKhamBenh = ?, DCD_TrangThai = ? WHERE DCD_MaBHYT = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bhyt.getDCD_CCCD());
            stmt.setDate(2, bhyt.getDCD_NgayCap());
            stmt.setDate(3, bhyt.getDCD_NgayHetHan());
            stmt.setString(4, bhyt.getDCD_NoiDangKyKhamBenh());
            stmt.setString(5, bhyt.getDCD_TrangThai());
            stmt.setString(6, bhyt.getDCD_MaBHYT());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String maBHYT) {
        String sql = "DELETE FROM DCD_BaoHiemYTe WHERE DCD_MaBHYT = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maBHYT);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}