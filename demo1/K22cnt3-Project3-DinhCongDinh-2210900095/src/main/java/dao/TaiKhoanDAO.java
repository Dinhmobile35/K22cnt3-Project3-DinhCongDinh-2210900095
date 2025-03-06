package dao;

import model.TaiKhoan;
import util.DatabaseConnection;

import java.sql.*;

public class TaiKhoanDAO {
    public TaiKhoan getTaiKhoan(String soDienThoai, String matKhau) throws SQLException {
        String sql = "SELECT * FROM DCD_TaiKhoan WHERE DCD_SoDienThoai = ? AND DCD_MatKhau = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, soDienThoai);
            stmt.setString(2, matKhau);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TaiKhoan(
                        rs.getString("DCD_SoDienThoai"),
                        rs.getString("DCD_CCCD"),
                        rs.getString("DCD_MatKhau"),
                        rs.getString("DCD_VaiTro"),
                        rs.getString("DCD_TrangThai")
                );
            }
            return null;
        }
    }
}