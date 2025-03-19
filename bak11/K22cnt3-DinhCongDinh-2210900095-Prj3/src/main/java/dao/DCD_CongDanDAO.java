package dao;

import model.DCD_CongDan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DCD_CongDanDAO {
    private String url = "jdbc:mysql://localhost:3306/K22cnt3_DinhCongDinh_2210900095_Prj3_db";
    private String username = "root";
    private String password = "123456";

    public DCD_CongDan getByCCCD(String cccd) {
        DCD_CongDan congDan = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Đăng ký driver MySQL
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM DCD_CongDan WHERE DCD_CCCD = ?")) {
                stmt.setString(1, cccd);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    congDan = new DCD_CongDan();
                    congDan.setDCD_CCCD(rs.getString("DCD_CCCD"));
                    congDan.setDCD_HoTen(rs.getString("DCD_HoTen"));
                    congDan.setDCD_NgaySinh(rs.getDate("DCD_NgaySinh"));
                    congDan.setDCD_GioiTinh(rs.getString("DCD_GioiTinh"));
                    congDan.setDCD_SoDienThoai(rs.getString("DCD_SoDienThoai"));
                    congDan.setDCD_Email(rs.getString("DCD_Email"));
                    congDan.setDCD_DiaChi(rs.getString("DCD_DiaChi"));
                    congDan.setDCD_NgayCap(rs.getDate("DCD_NgayCap"));
                    congDan.setDCD_NgayHetHan(rs.getDate("DCD_NgayHetHan"));
                    congDan.setDCD_MatKhau(rs.getString("DCD_MatKhau") != null ? rs.getString("DCD_MatKhau") : "");
                    congDan.setDCD_VaiTro(rs.getString("DCD_VaiTro"));
                    congDan.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                    congDan.setDCD_NgayTao(rs.getDate("DCD_NgayTao"));
                    System.out.println("Đã tìm thấy người dùng: " + congDan.getDCD_CCCD() + ", MatKhau: " + congDan.getDCD_MatKhau());
                } else {
                    System.out.println("Không tìm thấy người dùng với CCCD: " + cccd);
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi: Driver MySQL không được tìm thấy - " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Lỗi SQL khi truy vấn CCCD " + cccd + ": " + e.getMessage());
            e.printStackTrace();
        }
        return congDan;
    }

    public boolean updateMatKhau(String cccd, String matKhauCu, String matKhauMoi) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement stmt = conn.prepareStatement("UPDATE DCD_CongDan SET DCD_MatKhau = ? WHERE DCD_CCCD = ? AND DCD_MatKhau = ?")) {
                stmt.setString(1, matKhauMoi);
                stmt.setString(2, cccd);
                stmt.setString(3, matKhauCu);
                int rows = stmt.executeUpdate();
                return rows > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi cập nhật mật khẩu: " + e.getMessage());
        }
        return false;
    }

    public boolean updateInfo(String cccd, String soDienThoai, String email) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement stmt = conn.prepareStatement("UPDATE DCD_CongDan SET DCD_SoDienThoai = ?, DCD_Email = ? WHERE DCD_CCCD = ?")) {
                stmt.setString(1, soDienThoai);
                stmt.setString(2, email);
                stmt.setString(3, cccd);
                int rows = stmt.executeUpdate();
                return rows > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi cập nhật thông tin: " + e.getMessage());
        }
        return false;
    }

    public List<DCD_CongDan> getAll() {
        List<DCD_CongDan> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM DCD_CongDan")) {
                while (rs.next()) {
                    DCD_CongDan congDan = new DCD_CongDan();
                    congDan.setDCD_CCCD(rs.getString("DCD_CCCD"));
                    congDan.setDCD_HoTen(rs.getString("DCD_HoTen"));
                    congDan.setDCD_NgaySinh(rs.getDate("DCD_NgaySinh"));
                    congDan.setDCD_GioiTinh(rs.getString("DCD_GioiTinh"));
                    congDan.setDCD_SoDienThoai(rs.getString("DCD_SoDienThoai"));
                    congDan.setDCD_Email(rs.getString("DCD_Email"));
                    congDan.setDCD_DiaChi(rs.getString("DCD_DiaChi"));
                    congDan.setDCD_NgayCap(rs.getDate("DCD_NgayCap"));
                    congDan.setDCD_NgayHetHan(rs.getDate("DCD_NgayHetHan"));
                    congDan.setDCD_MatKhau(rs.getString("DCD_MatKhau") != null ? rs.getString("DCD_MatKhau") : "");
                    congDan.setDCD_VaiTro(rs.getString("DCD_VaiTro"));
                    congDan.setDCD_TrangThai(rs.getString("DCD_TrangThai"));
                    congDan.setDCD_NgayTao(rs.getDate("DCD_NgayTao"));
                    list.add(congDan);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi lấy danh sách: " + e.getMessage());
        }
        return list;
    }

    public boolean create(DCD_CongDan congDan) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO DCD_CongDan (DCD_CCCD, DCD_HoTen, DCD_NgaySinh, DCD_GioiTinh, DCD_SoDienThoai, DCD_Email, DCD_DiaChi, DCD_NgayCap, DCD_NgayHetHan, DCD_MatKhau, DCD_VaiTro, DCD_TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                stmt.setString(1, congDan.getDCD_CCCD());
                stmt.setString(2, congDan.getDCD_HoTen());
                stmt.setDate(3, congDan.getDCD_NgaySinh());
                stmt.setString(4, congDan.getDCD_GioiTinh());
                stmt.setString(5, congDan.getDCD_SoDienThoai());
                stmt.setString(6, congDan.getDCD_Email());
                stmt.setString(7, congDan.getDCD_DiaChi());
                stmt.setDate(8, congDan.getDCD_NgayCap());
                stmt.setDate(9, congDan.getDCD_NgayHetHan());
                stmt.setString(10, congDan.getDCD_MatKhau());
                stmt.setString(11, congDan.getDCD_VaiTro());
                stmt.setString(12, congDan.getDCD_TrangThai());
                int rows = stmt.executeUpdate();
                return rows > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi tạo người dùng: " + e.getMessage());
        }
        return false;
    }

    public boolean update(DCD_CongDan congDan) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement stmt = conn.prepareStatement("UPDATE DCD_CongDan SET DCD_HoTen = ?, DCD_NgaySinh = ?, DCD_GioiTinh = ?, DCD_SoDienThoai = ?, DCD_Email = ?, DCD_DiaChi = ?, DCD_NgayCap = ?, DCD_NgayHetHan = ?, DCD_MatKhau = ?, DCD_VaiTro = ?, DCD_TrangThai = ? WHERE DCD_CCCD = ?")) {
                stmt.setString(1, congDan.getDCD_HoTen());
                stmt.setDate(2, congDan.getDCD_NgaySinh());
                stmt.setString(3, congDan.getDCD_GioiTinh());
                stmt.setString(4, congDan.getDCD_SoDienThoai());
                stmt.setString(5, congDan.getDCD_Email());
                stmt.setString(6, congDan.getDCD_DiaChi());
                stmt.setDate(7, congDan.getDCD_NgayCap());
                stmt.setDate(8, congDan.getDCD_NgayHetHan());
                stmt.setString(9, congDan.getDCD_MatKhau());
                stmt.setString(10, congDan.getDCD_VaiTro());
                stmt.setString(11, congDan.getDCD_TrangThai());
                stmt.setString(12, congDan.getDCD_CCCD());
                int rows = stmt.executeUpdate();
                return rows > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi cập nhật người dùng: " + e.getMessage());
        }
        return false;
    }

    public boolean delete(String cccd) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement stmt = conn.prepareStatement("DELETE FROM DCD_CongDan WHERE DCD_CCCD = ?")) {
                stmt.setString(1, cccd);
                int rows = stmt.executeUpdate();
                return rows > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi xóa người dùng: " + e.getMessage());
        }
        return false;
    }
}