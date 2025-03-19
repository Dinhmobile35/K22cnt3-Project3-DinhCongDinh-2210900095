package dao;
import model.TaiKhoan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TaiKhoanDAO {
    private Connection conn;

    public TaiKhoanDAO(Connection conn) {
        this.conn = conn;
    }

    public void addTaiKhoan(TaiKhoan taiKhoan) throws SQLException {
        String sql = "INSERT INTO tai_khoan (so_dien_thoai, cccd, mat_khau, vai_tro, trang_thai, ngay_tao) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, taiKhoan.getSoDienThoai());
        stmt.setString(2, taiKhoan.getCccd());
        stmt.setString(3, taiKhoan.getMatKhau());
        stmt.setString(4, taiKhoan.getVaiTro());
        stmt.setString(5, taiKhoan.getTrangThai());
        stmt.setDate(6, new java.sql.Date(taiKhoan.getNgayTao().getTime()));
        stmt.executeUpdate();
    }

    public boolean isPhoneExists(String soDienThoai) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tai_khoan WHERE so_dien_thoai = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, soDienThoai);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        return false;
    }
}