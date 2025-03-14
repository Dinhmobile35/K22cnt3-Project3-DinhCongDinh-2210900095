package dao;

import model.CongDan;
import model.TaiKhoan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CongDanDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/K22cnt3_DinhCongDinh_2210900095_Project3_db?useSSL=false&allowPublicKeyRetrieval=true";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456"; // Thay bằng mật khẩu MySQL của bạn

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL Driver not found", e);
        }
        return connection;
    }

    public List<CongDan> selectAllCongDan() throws SQLException {
        List<CongDan> congDanList = new ArrayList<>();
        String query = "SELECT * FROM DCD_CongDan";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String cccd = rs.getString("DCD_CCCD");
                String hoTen = rs.getString("DCD_HoTen");
                Date ngaySinh = rs.getDate("DCD_NgaySinh");
                String gioiTinh = rs.getString("DCD_GioiTinh");
                String soDienThoai = rs.getString("DCD_SoDienThoai");
                String email = rs.getString("DCD_Email");
                String diaChi = rs.getString("DCD_DiaChi");
                Date ngayCap = rs.getDate("DCD_NgayCap");
                Date ngayHetHan = rs.getDate("DCD_NgayHetHan");
                congDanList.add(new CongDan(cccd, hoTen, ngaySinh, gioiTinh, soDienThoai, email, diaChi, ngayCap, ngayHetHan, null));
            }
        }
        return congDanList;
    }

    public CongDan selectCongDan(String cccd) throws SQLException {
        CongDan congDan = null;
        String query = "SELECT * FROM DCD_CongDan WHERE DCD_CCCD = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cccd);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String hoTen = rs.getString("DCD_HoTen");
                Date ngaySinh = rs.getDate("DCD_NgaySinh");
                String gioiTinh = rs.getString("DCD_GioiTinh");
                String soDienThoai = rs.getString("DCD_SoDienThoai");
                String email = rs.getString("DCD_Email");
                String diaChi = rs.getString("DCD_DiaChi");
                Date ngayCap = rs.getDate("DCD_NgayCap");
                Date ngayHetHan = rs.getDate("DCD_NgayHetHan");
                congDan = new CongDan(cccd, hoTen, ngaySinh, gioiTinh, soDienThoai, email, diaChi, ngayCap, ngayHetHan, null);
            }
        }
        return congDan;
    }

    public void insertCongDan(CongDan congDan) throws SQLException {
        String query = "INSERT INTO DCD_CongDan (DCD_CCCD, DCD_HoTen, DCD_NgaySinh, DCD_GioiTinh, DCD_SoDienThoai, DCD_Email, DCD_DiaChi, DCD_NgayCap, DCD_NgayHetHan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, congDan.getCccd());
            preparedStatement.setString(2, congDan.getHoTen());
            preparedStatement.setDate(3, congDan.getNgaySinh());
            preparedStatement.setString(4, congDan.getGioiTinh());
            preparedStatement.setString(5, congDan.getSoDienThoai());
            preparedStatement.setString(6, congDan.getEmail());
            preparedStatement.setString(7, congDan.getDiaChi());
            preparedStatement.setDate(8, congDan.getNgayCap());
            preparedStatement.setDate(9, congDan.getNgayHetHan());
            preparedStatement.executeUpdate();
        }
    }

    public void updateCongDan(CongDan congDan) throws SQLException {
        String query = "UPDATE DCD_CongDan SET DCD_HoTen = ?, DCD_NgaySinh = ?, DCD_GioiTinh = ?, DCD_SoDienThoai = ?, DCD_Email = ?, DCD_DiaChi = ?, DCD_NgayCap = ?, DCD_NgayHetHan = ? WHERE DCD_CCCD = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, congDan.getHoTen());
            preparedStatement.setDate(2, congDan.getNgaySinh());
            preparedStatement.setString(3, congDan.getGioiTinh());
            preparedStatement.setString(4, congDan.getSoDienThoai());
            preparedStatement.setString(5, congDan.getEmail());
            preparedStatement.setString(6, congDan.getDiaChi());
            preparedStatement.setDate(7, congDan.getNgayCap());
            preparedStatement.setDate(8, congDan.getNgayHetHan());
            preparedStatement.setString(9, congDan.getCccd());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteCongDan(String cccd) throws SQLException {
        String query = "DELETE FROM DCD_CongDan WHERE DCD_CCCD = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cccd);
            preparedStatement.executeUpdate();
        }
    }

    public String checkLogin(String soDienThoai, String matKhau) throws SQLException {
        String query = "SELECT DCD_VaiTro FROM DCD_TaiKhoan WHERE DCD_SoDienThoai = ? AND DCD_MatKhau = ? AND DCD_TrangThai = 'HOAT_DONG'";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, soDienThoai);
            pstmt.setString(2, matKhau);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("DCD_VaiTro");
            }
        }
        return null;
    }

    public boolean registerAccount(String soDienThoai, String cccd, String matKhau, String vaiTro) throws SQLException {
        String query = "INSERT INTO DCD_TaiKhoan (DCD_SoDienThoai, DCD_CCCD, DCD_MatKhau, DCD_VaiTro) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, soDienThoai);
            pstmt.setString(2, cccd);
            pstmt.setString(3, matKhau);
            pstmt.setString(4, vaiTro);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public boolean isPhoneNumberExists(String soDienThoai) throws SQLException {
        String query = "SELECT DCD_SoDienThoai FROM DCD_TaiKhoan WHERE DCD_SoDienThoai = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, soDienThoai);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }

    // Thêm các phương thức cho Dashboard
    public int countCongDan() throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_CongDan";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

    public int countTaiKhoan() throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_TaiKhoan";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

    public int countLockedTaiKhoan() throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_TaiKhoan WHERE DCD_TrangThai = 'KHOA'";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

    // Phương thức lấy danh sách tài khoản
    public List<TaiKhoan> selectAllTaiKhoan() throws SQLException {
        List<TaiKhoan> taiKhoanList = new ArrayList<>();
        String query = "SELECT * FROM DCD_TaiKhoan";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String soDienThoai = rs.getString("DCD_SoDienThoai");
                String cccd = rs.getString("DCD_CCCD");
                String matKhau = rs.getString("DCD_MatKhau");
                String vaiTro = rs.getString("DCD_VaiTro");
                String trangThai = rs.getString("DCD_TrangThai");
                Timestamp ngayTao = rs.getTimestamp("DCD_NgayTao");
                taiKhoanList.add(new TaiKhoan(soDienThoai, cccd, matKhau, vaiTro, trangThai, ngayTao));
            }
        }
        return taiKhoanList;
    }

    // Phương thức khóa/mở khóa tài khoản
    public void updateTaiKhoanStatus(String soDienThoai, String trangThai) throws SQLException {
        String query = "UPDATE DCD_TaiKhoan SET DCD_TrangThai = ? WHERE DCD_SoDienThoai = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, trangThai);
            pstmt.setString(2, soDienThoai);
            pstmt.executeUpdate();
        }
    }
}