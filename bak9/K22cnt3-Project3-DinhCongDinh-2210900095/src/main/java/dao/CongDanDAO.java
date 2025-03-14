package dao;

import model.CongDan;
import model.TaiKhoan;
import model.YeuCauCapLai;
import model.YeuCauChinhSua;
import model.YeuCauDoiMatKhau;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CongDanDAO {
    private static final Logger LOGGER = Logger.getLogger(CongDanDAO.class.getName());
    private String jdbcURL = "jdbc:mysql://localhost:3306/K22cnt3_DinhCongDinh_2210900095_Project3_db?useSSL=false&allowPublicKeyRetrieval=true";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456"; // Thay bằng mật khẩu MySQL của bạn

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            LOGGER.info("Database connection established successfully.");
        } catch (ClassNotFoundException e) {
            LOGGER.severe("MySQL Driver not found: " + e.getMessage());
            throw new SQLException("MySQL Driver not found", e);
        } catch (SQLException e) {
            LOGGER.severe("Failed to connect to database: " + e.getMessage());
            throw e;
        }
        return connection;
    }

    public List<CongDan> selectAllCongDan() throws SQLException {
        List<CongDan> congDanList = new ArrayList<>();
        String query = "SELECT * FROM DCD_CongDan";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            LOGGER.info("Executing query: " + query);
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
            LOGGER.info("Fetched " + congDanList.size() + " citizens.");
        } catch (SQLException e) {
            LOGGER.severe("Error in selectAllCongDan: " + e.getMessage());
            throw e;
        }
        return congDanList;
    }

    public CongDan selectCongDan(String cccd) throws SQLException {
        if (cccd == null || cccd.trim().isEmpty()) {
            LOGGER.warning("Invalid CCCD provided: " + cccd);
            return null;
        }

        CongDan congDan = null;
        String query = "SELECT * FROM DCD_CongDan WHERE DCD_CCCD = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cccd);
            LOGGER.info("Executing query: " + query + " with CCCD: " + cccd);
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
                LOGGER.info("Citizen found with CCCD: " + cccd);
            } else {
                LOGGER.info("No citizen found with CCCD: " + cccd);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in selectCongDan: " + e.getMessage());
            throw e;
        }
        return congDan;
    }

    public CongDan getCongDanByPhone(String soDienThoai) throws SQLException {
        if (soDienThoai == null || soDienThoai.trim().isEmpty()) {
            LOGGER.warning("Invalid phone number provided: " + soDienThoai);
            return null;
        }

        CongDan congDan = null;
        String query = "SELECT * FROM DCD_CongDan WHERE DCD_SoDienThoai = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, soDienThoai);
            LOGGER.info("Executing query: " + query + " with phone: " + soDienThoai);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String cccd = rs.getString("DCD_CCCD");
                String hoTen = rs.getString("DCD_HoTen");
                Date ngaySinh = rs.getDate("DCD_NgaySinh");
                String gioiTinh = rs.getString("DCD_GioiTinh");
                String email = rs.getString("DCD_Email");
                String diaChi = rs.getString("DCD_DiaChi");
                Date ngayCap = rs.getDate("DCD_NgayCap");
                Date ngayHetHan = rs.getDate("DCD_NgayHetHan");
                congDan = new CongDan(cccd, hoTen, ngaySinh, gioiTinh, soDienThoai, email, diaChi, ngayCap, ngayHetHan, null);
                LOGGER.info("Citizen found with phone: " + soDienThoai);
            } else {
                LOGGER.info("No citizen found with phone: " + soDienThoai);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in getCongDanByPhone: " + e.getMessage());
            throw e;
        }
        return congDan;
    }

    public void insertCongDan(CongDan congDan) throws SQLException {
        if (congDan == null || congDan.getCccd() == null) {
            LOGGER.warning("Invalid CongDan object provided for insertion.");
            throw new SQLException("CongDan object or CCCD cannot be null.");
        }

        String query = "INSERT INTO DCD_CongDan (DCD_CCCD, DCD_HoTen, DCD_NgaySinh, DCD_GioiTinh, DCD_SoDienThoai, DCD_Email, DCD_DiaChi, DCD_NgayCap, DCD_NgayHetHan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, congDan.getCccd());
            preparedStatement.setString(2, congDan.getHoTen());
            preparedStatement.setDate(3, congDan.getNgaySinh());
            preparedStatement.setString(4, congDan.getGioiTinh().equals("Nữ") ? "Nu" : congDan.getGioiTinh());
            preparedStatement.setString(5, congDan.getSoDienThoai());
            preparedStatement.setString(6, congDan.getEmail());
            preparedStatement.setString(7, congDan.getDiaChi());
            preparedStatement.setDate(8, congDan.getNgayCap());
            preparedStatement.setDate(9, congDan.getNgayHetHan());
            LOGGER.info("Inserting new citizen with CCCD: " + congDan.getCccd());
            preparedStatement.executeUpdate();
            LOGGER.info("Citizen inserted successfully with CCCD: " + congDan.getCccd());
        } catch (SQLException e) {
            LOGGER.severe("Error in insertCongDan: " + e.getMessage());
            throw e;
        }
    }

    public void updateCongDan(CongDan congDan) throws SQLException {
        if (congDan == null || congDan.getCccd() == null) {
            LOGGER.warning("Invalid CongDan object provided for update.");
            throw new SQLException("CongDan object or CCCD cannot be null.");
        }

        String query = "UPDATE DCD_CongDan SET DCD_HoTen = ?, DCD_NgaySinh = ?, DCD_GioiTinh = ?, DCD_SoDienThoai = ?, DCD_Email = ?, DCD_DiaChi = ?, DCD_NgayCap = ?, DCD_NgayHetHan = ? WHERE DCD_CCCD = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, congDan.getHoTen());
            preparedStatement.setDate(2, congDan.getNgaySinh());
            preparedStatement.setString(3, congDan.getGioiTinh().equals("Nữ") ? "Nu" : congDan.getGioiTinh());
            preparedStatement.setString(4, congDan.getSoDienThoai());
            preparedStatement.setString(5, congDan.getEmail());
            preparedStatement.setString(6, congDan.getDiaChi());
            preparedStatement.setDate(7, congDan.getNgayCap());
            preparedStatement.setDate(8, congDan.getNgayHetHan());
            preparedStatement.setString(9, congDan.getCccd());
            LOGGER.info("Updating citizen with CCCD: " + congDan.getCccd());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                LOGGER.info("Citizen updated successfully with CCCD: " + congDan.getCccd());
            } else {
                LOGGER.warning("No citizen updated with CCCD: " + congDan.getCccd());
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in updateCongDan: " + e.getMessage());
            throw e;
        }
    }

    public void deleteCongDan(String cccd) throws SQLException {
        if (cccd == null || cccd.trim().isEmpty()) {
            LOGGER.warning("Invalid CCCD provided for deletion: " + cccd);
            throw new SQLException("CCCD cannot be null or empty.");
        }

        String query = "DELETE FROM DCD_CongDan WHERE DCD_CCCD = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cccd);
            LOGGER.info("Deleting citizen with CCCD: " + cccd);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                LOGGER.info("Citizen deleted successfully with CCCD: " + cccd);
            } else {
                LOGGER.warning("No citizen deleted with CCCD: " + cccd);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in deleteCongDan: " + e.getMessage());
            throw e;
        }
    }

    public String checkLogin(String soDienThoai, String matKhau) throws SQLException {
        if (soDienThoai == null || matKhau == null || soDienThoai.trim().isEmpty() || matKhau.trim().isEmpty()) {
            LOGGER.warning("Invalid login credentials: soDienThoai=" + soDienThoai + ", matKhau=" + matKhau);
            return null;
        }

        String query = "SELECT DCD_VaiTro FROM DCD_TaiKhoan WHERE DCD_SoDienThoai = ? AND DCD_MatKhau = ? AND DCD_TrangThai = 'HOAT_DONG'";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, soDienThoai);
            pstmt.setString(2, matKhau);
            LOGGER.info("Checking login for phone: " + soDienThoai);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String vaiTro = rs.getString("DCD_VaiTro");
                LOGGER.info("Login successful for phone: " + soDienThoai + ", role: " + vaiTro);
                return vaiTro;
            } else {
                LOGGER.info("Login failed for phone: " + soDienThoai);
                return null;
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in checkLogin: " + e.getMessage());
            throw e;
        }
    }

    public boolean registerAccount(String soDienThoai, String cccd, String matKhau, String vaiTro) throws SQLException {
        if (soDienThoai == null || cccd == null || matKhau == null || vaiTro == null ||
                soDienThoai.trim().isEmpty() || cccd.trim().isEmpty() || matKhau.trim().isEmpty() || vaiTro.trim().isEmpty()) {
            LOGGER.warning("Invalid registration data: soDienThoai=" + soDienThoai + ", cccd=" + cccd + ", vaiTro=" + vaiTro);
            return false;
        }

        String query = "INSERT INTO DCD_TaiKhoan (DCD_SoDienThoai, DCD_CCCD, DCD_MatKhau, DCD_VaiTro, DCD_TrangThai, DCD_NgayTao) VALUES (?, ?, ?, ?, 'HOAT_DONG', NOW())";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, soDienThoai);
            pstmt.setString(2, cccd);
            pstmt.setString(3, matKhau);
            pstmt.setString(4, vaiTro);
            LOGGER.info("Registering account for phone: " + soDienThoai + ", CCCD: " + cccd);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                LOGGER.info("Account registered successfully for phone: " + soDienThoai);
                return true;
            } else {
                LOGGER.warning("Failed to register account for phone: " + soDienThoai);
                return false;
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in registerAccount: " + e.getMessage());
            throw e;
        }
    }

    public boolean isPhoneNumberExists(String soDienThoai) throws SQLException {
        if (soDienThoai == null || soDienThoai.trim().isEmpty()) {
            LOGGER.warning("Invalid phone number provided: " + soDienThoai);
            return false;
        }

        String query = "SELECT DCD_SoDienThoai FROM DCD_TaiKhoan WHERE DCD_SoDienThoai = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, soDienThoai);
            LOGGER.info("Checking if phone number exists: " + soDienThoai);
            ResultSet rs = pstmt.executeQuery();
            boolean exists = rs.next();
            LOGGER.info("Phone number " + soDienThoai + " exists: " + exists);
            return exists;
        } catch (SQLException e) {
            LOGGER.severe("Error in isPhoneNumberExists: " + e.getMessage());
            throw e;
        }
    }

    public boolean isCccdExists(String cccd) throws SQLException {
        if (cccd == null || cccd.trim().isEmpty()) {
            LOGGER.warning("Invalid CCCD provided: " + cccd);
            return false;
        }

        String query = "SELECT DCD_CCCD FROM DCD_CongDan WHERE DCD_CCCD = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, cccd);
            LOGGER.info("Checking if CCCD exists: " + cccd);
            ResultSet rs = pstmt.executeQuery();
            boolean exists = rs.next();
            LOGGER.info("CCCD " + cccd + " exists: " + exists);
            return exists;
        } catch (SQLException e) {
            LOGGER.severe("Error in isCccdExists: " + e.getMessage());
            throw e;
        }
    }

    public int countCongDan() throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_CongDan";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            LOGGER.info("Counting total citizens.");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                LOGGER.info("Total citizens: " + count);
                return count;
            }
            return 0;
        } catch (SQLException e) {
            LOGGER.severe("Error in countCongDan: " + e.getMessage());
            throw e;
        }
    }

    public int countTaiKhoan() throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_TaiKhoan";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            LOGGER.info("Counting total accounts.");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                LOGGER.info("Total accounts: " + count);
                return count;
            }
            return 0;
        } catch (SQLException e) {
            LOGGER.severe("Error in countTaiKhoan: " + e.getMessage());
            throw e;
        }
    }

    public int countLockedTaiKhoan() throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_TaiKhoan WHERE DCD_TrangThai = 'KHOA'";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            LOGGER.info("Counting locked accounts.");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                LOGGER.info("Total locked accounts: " + count);
                return count;
            }
            return 0;
        } catch (SQLException e) {
            LOGGER.severe("Error in countLockedTaiKhoan: " + e.getMessage());
            throw e;
        }
    }

    public List<TaiKhoan> selectAllTaiKhoan() throws SQLException {
        List<TaiKhoan> taiKhoanList = new ArrayList<>();
        String query = "SELECT * FROM DCD_TaiKhoan";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            LOGGER.info("Fetching all accounts...");
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
            LOGGER.info("Fetched " + taiKhoanList.size() + " accounts.");
        } catch (SQLException e) {
            LOGGER.severe("Error in selectAllTaiKhoan: " + e.getMessage());
            throw e;
        }
        return taiKhoanList;
    }

    public void updateTaiKhoanStatus(String soDienThoai, String trangThai) throws SQLException {
        if (soDienThoai == null || soDienThoai.trim().isEmpty() || trangThai == null || trangThai.trim().isEmpty()) {
            LOGGER.warning("Invalid data for updating account status: soDienThoai=" + soDienThoai + ", trangThai=" + trangThai);
            throw new SQLException("Phone number or status cannot be null or empty.");
        }

        String query = "UPDATE DCD_TaiKhoan SET DCD_TrangThai = ? WHERE DCD_SoDienThoai = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, trangThai);
            pstmt.setString(2, soDienThoai);
            LOGGER.info("Updating account status for phone: " + soDienThoai + " to " + trangThai);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                LOGGER.info("Account status updated successfully for phone: " + soDienThoai);
            } else {
                LOGGER.warning("No account updated for phone: " + soDienThoai);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in updateTaiKhoanStatus: " + e.getMessage());
            throw e;
        }
    }

    public void insertTaiKhoan(String soDienThoai, String cccd, String matKhau, String vaiTro, String trangThai) throws SQLException {
        if (soDienThoai == null || cccd == null || matKhau == null || vaiTro == null || trangThai == null ||
                soDienThoai.trim().isEmpty() || cccd.trim().isEmpty() || matKhau.trim().isEmpty() || vaiTro.trim().isEmpty() || trangThai.trim().isEmpty()) {
            LOGGER.warning("Invalid data for inserting account: soDienThoai=" + soDienThoai + ", cccd=" + cccd + ", vaiTro=" + vaiTro + ", trangThai=" + trangThai);
            throw new SQLException("Account data cannot be null or empty.");
        }

        // Kiểm tra xem DCD_CCCD có tồn tại trong DCD_CongDan hay không
        if (!isCccdExists(cccd)) {
            LOGGER.warning("CCCD '" + cccd + "' does not exist in DCD_CongDan.");
            throw new SQLException("CCCD '" + cccd + "' không tồn tại trong bảng DCD_CongDan. Vui lòng kiểm tra lại!");
        }

        String query = "INSERT INTO DCD_TaiKhoan (DCD_SoDienThoai, DCD_CCCD, DCD_MatKhau, DCD_VaiTro, DCD_TrangThai, DCD_NgayTao) VALUES (?, ?, ?, ?, ?, NOW())";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, soDienThoai);
            preparedStatement.setString(2, cccd);
            preparedStatement.setString(3, matKhau);
            preparedStatement.setString(4, vaiTro);
            preparedStatement.setString(5, trangThai);
            LOGGER.info("Inserting new account for phone: " + soDienThoai);
            preparedStatement.executeUpdate();
            LOGGER.info("Account inserted successfully for phone: " + soDienThoai);
        } catch (SQLException e) {
            LOGGER.severe("Error in insertTaiKhoan: " + e.getMessage());
            throw e;
        }
    }

    public void updateTaiKhoan(String soDienThoai, String cccd, String matKhau, String vaiTro, String trangThai) throws SQLException {
        if (soDienThoai == null || cccd == null || matKhau == null || vaiTro == null || trangThai == null ||
                soDienThoai.trim().isEmpty() || cccd.trim().isEmpty() || matKhau.trim().isEmpty() || vaiTro.trim().isEmpty() || trangThai.trim().isEmpty()) {
            LOGGER.warning("Invalid data for updating account: soDienThoai=" + soDienThoai + ", cccd=" + cccd + ", vaiTro=" + vaiTro + ", trangThai=" + trangThai);
            throw new SQLException("Account data cannot be null or empty.");
        }

        // Kiểm tra xem DCD_CCCD có tồn tại trong DCD_CongDan hay không
        if (!isCccdExists(cccd)) {
            LOGGER.warning("CCCD '" + cccd + "' does not exist in DCD_CongDan.");
            throw new SQLException("CCCD '" + cccd + "' không tồn tại trong bảng DCD_CongDan. Vui lòng kiểm tra lại!");
        }

        String query = "UPDATE DCD_TaiKhoan SET DCD_CCCD = ?, DCD_MatKhau = ?, DCD_VaiTro = ?, DCD_TrangThai = ? WHERE DCD_SoDienThoai = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cccd);
            preparedStatement.setString(2, matKhau);
            preparedStatement.setString(3, vaiTro);
            preparedStatement.setString(4, trangThai);
            preparedStatement.setString(5, soDienThoai);
            LOGGER.info("Updating account for phone: " + soDienThoai);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                LOGGER.info("Account updated successfully for phone: " + soDienThoai);
            } else {
                LOGGER.warning("No account updated for phone: " + soDienThoai);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in updateTaiKhoan: " + e.getMessage());
            throw e;
        }
    }

    public int countCapLaiRequestsByStatus(String trangThai) throws SQLException {
        if (trangThai == null || trangThai.trim().isEmpty()) {
            LOGGER.warning("Invalid status provided: " + trangThai);
            return 0;
        }

        String query = "SELECT COUNT(*) FROM DCD_YeuCauCapLai WHERE DCD_TrangThai = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, trangThai);
            LOGGER.info("Counting cap lai requests with status: " + trangThai);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                LOGGER.info("Total cap lai requests with status " + trangThai + ": " + count);
                return count;
            }
            return 0;
        } catch (SQLException e) {
            LOGGER.severe("Error in countCapLaiRequestsByStatus: " + e.getMessage());
            throw e;
        }
    }

    public int countCapLaiRequestsByStatusAndDelivery(String trangThaiGiaoHang) throws SQLException {
        if (trangThaiGiaoHang == null || trangThaiGiaoHang.trim().isEmpty()) {
            LOGGER.warning("Invalid delivery status provided: " + trangThaiGiaoHang);
            return 0;
        }

        String query = "SELECT COUNT(*) FROM DCD_YeuCauCapLai WHERE DCD_TrangThaiGiaoHang = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, trangThaiGiaoHang);
            LOGGER.info("Counting cap lai requests with delivery status: " + trangThaiGiaoHang);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                LOGGER.info("Total cap lai requests with delivery status " + trangThaiGiaoHang + ": " + count);
                return count;
            }
            return 0;
        } catch (SQLException e) {
            LOGGER.severe("Error in countCapLaiRequestsByStatusAndDelivery: " + e.getMessage());
            throw e;
        }
    }

    public int countChinhSuaRequestsByStatus(String trangThai) throws SQLException {
        if (trangThai == null || trangThai.trim().isEmpty()) {
            LOGGER.warning("Invalid status provided: " + trangThai);
            return 0;
        }

        String query = "SELECT COUNT(*) FROM DCD_YeuCauChinhSua WHERE DCD_TrangThai = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, trangThai);
            LOGGER.info("Counting chinh sua requests with status: " + trangThai);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                LOGGER.info("Total chinh sua requests with status " + trangThai + ": " + count);
                return count;
            }
            return 0;
        } catch (SQLException e) {
            LOGGER.severe("Error in countChinhSuaRequestsByStatus: " + e.getMessage());
            throw e;
        }
    }

    public int countDoiMatKhauRequestsByStatus(String trangThai) throws SQLException {
        if (trangThai == null || trangThai.trim().isEmpty()) {
            LOGGER.warning("Invalid status provided: " + trangThai);
            return 0;
        }

        String query = "SELECT COUNT(*) FROM DCD_YeuCauDoiMatKhau WHERE DCD_TrangThai = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, trangThai);
            LOGGER.info("Counting doi mat khau requests with status: " + trangThai);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                LOGGER.info("Total doi mat khau requests with status " + trangThai + ": " + count);
                return count;
            }
            return 0;
        } catch (SQLException e) {
            LOGGER.severe("Error in countDoiMatKhauRequestsByStatus: " + e.getMessage());
            throw e;
        }
    }

    public void insertCapLaiRequest(YeuCauCapLai yeuCau) throws SQLException {
        if (yeuCau == null || yeuCau.getCccd() == null || yeuCau.getLoaiYeuCau() == null ||
                yeuCau.getTrangThai() == null || yeuCau.getTenNguoiNhan() == null ||
                yeuCau.getSoDienThoaiNhan() == null || yeuCau.getDiaChiNhan() == null) {
            LOGGER.warning("Invalid YeuCauCapLai object provided for insertion. Required fields (cccd, loaiYeuCau, trangThai, tenNguoiNhan, soDienThoaiNhan, diaChiNhan) cannot be null.");
            throw new SQLException("YeuCauCapLai object or required fields cannot be null.");
        }

        String query = "INSERT INTO DCD_YeuCauCapLai (DCD_CCCD, DCD_LoaiYeuCau, DCD_TrangThai, DCD_TrangThaiGiaoHang, DCD_TenNguoiNhan, DCD_SoDienThoaiNhan, DCD_DiaChiNhan, DCD_NgayTao) VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, yeuCau.getCccd());
            preparedStatement.setString(2, yeuCau.getLoaiYeuCau());
            preparedStatement.setString(3, yeuCau.getTrangThai());
            preparedStatement.setString(4, yeuCau.getTrangThaiGiaoHang() != null ? yeuCau.getTrangThaiGiaoHang() : "CHUA_GIAO");
            preparedStatement.setString(5, yeuCau.getTenNguoiNhan());
            preparedStatement.setString(6, yeuCau.getSoDienThoaiNhan());
            preparedStatement.setString(7, yeuCau.getDiaChiNhan());
            LOGGER.info("Inserting cap lai request for CCCD: " + yeuCau.getCccd());
            preparedStatement.executeUpdate();
            LOGGER.info("Cap lai request inserted successfully for CCCD: " + yeuCau.getCccd());
        } catch (SQLException e) {
            LOGGER.severe("Error in insertCapLaiRequest: " + e.getMessage());
            throw e;
        }
    }

    public void insertChinhSuaRequest(YeuCauChinhSua yeuCau) throws SQLException {
        if (yeuCau == null || yeuCau.getCccd() == null) {
            LOGGER.warning("Invalid YeuCauChinhSua object provided for insertion.");
            throw new SQLException("YeuCauChinhSua object or CCCD cannot be null.");
        }

        String query = "INSERT INTO DCD_YeuCauChinhSua (DCD_CCCD, DCD_TruongCanSua, DCD_GiaTriMoi, DCD_TrangThai, DCD_NgayTao) VALUES (?, ?, ?, ?, NOW())";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, yeuCau.getCccd());
            preparedStatement.setString(2, yeuCau.getTruongCanSua());
            preparedStatement.setString(3, yeuCau.getGiaTriMoi());
            preparedStatement.setString(4, yeuCau.getTrangThai());
            LOGGER.info("Inserting chinh sua request for CCCD: " + yeuCau.getCccd());
            preparedStatement.executeUpdate();
            LOGGER.info("Chinh sua request inserted successfully for CCCD: " + yeuCau.getCccd());
        } catch (SQLException e) {
            LOGGER.severe("Error in insertChinhSuaRequest: " + e.getMessage());
            throw e;
        }
    }

    public void insertDoiMatKhauRequest(YeuCauDoiMatKhau yeuCau) throws SQLException {
        if (yeuCau == null || yeuCau.getSoDienThoai() == null) {
            LOGGER.warning("Invalid YeuCauDoiMatKhau object provided for insertion.");
            throw new SQLException("YeuCauDoiMatKhau object or phone number cannot be null.");
        }

        String query = "INSERT INTO DCD_YeuCauDoiMatKhau (DCD_SoDienThoai, DCD_MatKhauMoi, DCD_TrangThai, DCD_NgayTao) VALUES (?, ?, ?, NOW())";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, yeuCau.getSoDienThoai());
            preparedStatement.setString(2, yeuCau.getMatKhauMoi());
            preparedStatement.setString(3, yeuCau.getTrangThai());
            LOGGER.info("Inserting doi mat khau request for phone: " + yeuCau.getSoDienThoai());
            preparedStatement.executeUpdate();
            LOGGER.info("Doi mat khau request inserted successfully for phone: " + yeuCau.getSoDienThoai());
        } catch (SQLException e) {
            LOGGER.severe("Error in insertDoiMatKhauRequest: " + e.getMessage());
            throw e;
        }
    }

    public List<YeuCauCapLai> getAllCapLaiRequests() throws SQLException {
        List<YeuCauCapLai> requests = new ArrayList<>();
        String query = "SELECT * FROM DCD_YeuCauCapLai";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            LOGGER.info("Fetching all cap lai requests...");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int maYeuCau = rs.getInt("DCD_MaYeuCau");
                String cccd = rs.getString("DCD_CCCD");
                String loaiYeuCau = rs.getString("DCD_LoaiYeuCau");
                String trangThai = rs.getString("DCD_TrangThai");
                String trangThaiGiaoHang = rs.getString("DCD_TrangThaiGiaoHang");
                String tenNguoiNhan = rs.getString("DCD_TenNguoiNhan");
                String soDienThoaiNhan = rs.getString("DCD_SoDienThoaiNhan");
                String diaChiNhan = rs.getString("DCD_DiaChiNhan");
                Timestamp ngayTao = rs.getTimestamp("DCD_NgayTao");
                Timestamp ngayCapNhat = rs.getTimestamp("DCD_NgayCapNhat");
                requests.add(new YeuCauCapLai(maYeuCau, cccd, loaiYeuCau, trangThai, trangThaiGiaoHang, tenNguoiNhan, soDienThoaiNhan, diaChiNhan, ngayTao, ngayCapNhat));
            }
            LOGGER.info("Fetched " + requests.size() + " cap lai requests.");
        } catch (SQLException e) {
            LOGGER.severe("Error in getAllCapLaiRequests: " + e.getMessage());
            throw e;
        }
        return requests;
    }

    public void updateCapLaiRequestStatus(int maYeuCau, String trangThai, String trangThaiGiaoHang) throws SQLException {
        String query = "UPDATE DCD_YeuCauCapLai SET DCD_TrangThai = ?, DCD_TrangThaiGiaoHang = ?, DCD_NgayCapNhat = CURRENT_TIMESTAMP WHERE DCD_MaYeuCau = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, trangThai);
            pstmt.setString(2, trangThaiGiaoHang);
            pstmt.setInt(3, maYeuCau);
            LOGGER.info("Updating cap lai request status for maYeuCau: " + maYeuCau + " to " + trangThai + "/" + trangThaiGiaoHang);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                LOGGER.info("Cap lai request status updated successfully for maYeuCau: " + maYeuCau);
            } else {
                LOGGER.warning("No cap lai request updated for maYeuCau: " + maYeuCau);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in updateCapLaiRequestStatus: " + e.getMessage());
            throw e;
        }
    }

    public List<YeuCauChinhSua> getAllChinhSuaRequests() throws SQLException {
        List<YeuCauChinhSua> requests = new ArrayList<>();
        String query = "SELECT * FROM DCD_YeuCauChinhSua";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            LOGGER.info("Fetching all chinh sua requests...");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int maYeuCau = rs.getInt("DCD_MaYeuCau");
                String cccd = rs.getString("DCD_CCCD");
                String truongCanSua = rs.getString("DCD_TruongCanSua");
                String giaTriMoi = rs.getString("DCD_GiaTriMoi");
                String trangThai = rs.getString("DCD_TrangThai");
                Timestamp ngayTao = rs.getTimestamp("DCD_NgayTao");
                Timestamp ngayCapNhat = rs.getTimestamp("DCD_NgayCapNhat");
                requests.add(new YeuCauChinhSua(maYeuCau, cccd, truongCanSua, giaTriMoi, trangThai, ngayTao, ngayCapNhat));
            }
            LOGGER.info("Fetched " + requests.size() + " chinh sua requests.");
        } catch (SQLException e) {
            LOGGER.severe("Error in getAllChinhSuaRequests: " + e.getMessage());
            throw e;
        }
        return requests;
    }

    public void updateChinhSuaRequestStatus(int maYeuCau, String trangThai) throws SQLException {
        try (Connection connection = getConnection()) {
            // Bước 1: Cập nhật trạng thái yêu cầu
            String updateRequestQuery = "UPDATE DCD_YeuCauChinhSua SET DCD_TrangThai = ?, DCD_NgayCapNhat = CURRENT_TIMESTAMP WHERE DCD_MaYeuCau = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(updateRequestQuery)) {
                pstmt.setString(1, trangThai);
                pstmt.setInt(2, maYeuCau);
                LOGGER.info("Updating chinh sua request status for maYeuCau: " + maYeuCau + " to " + trangThai);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    LOGGER.info("Chinh sua request status updated successfully for maYeuCau: " + maYeuCau);
                } else {
                    LOGGER.warning("No chinh sua request updated for maYeuCau: " + maYeuCau);
                }
            }

            // Bước 2: Nếu duyệt, cập nhật thông tin vào bảng DCD_CongDan
            if ("DA_DUYET".equals(trangThai)) {
                YeuCauChinhSua request = getChinhSuaRequestById(maYeuCau);
                if (request != null) {
                    String cccd = request.getCccd();
                    String truongCanSua = request.getTruongCanSua();
                    String giaTriMoi = request.getGiaTriMoi();
                    String updateQuery = "";
                    switch (truongCanSua) {
                        case "DCD_SoDienThoai":
                            updateQuery = "UPDATE DCD_CongDan SET DCD_SoDienThoai = ? WHERE DCD_CCCD = ?";
                            break;
                        case "DCD_Email":
                            updateQuery = "UPDATE DCD_CongDan SET DCD_Email = ? WHERE DCD_CCCD = ?";
                            break;
                        default:
                            LOGGER.warning("Unsupported field to update: " + truongCanSua);
                            return;
                    }
                    try (PreparedStatement pstmtUpdate = connection.prepareStatement(updateQuery)) {
                        pstmtUpdate.setString(1, giaTriMoi);
                        pstmtUpdate.setString(2, cccd);
                        LOGGER.info("Updating field " + truongCanSua + " for CCCD: " + cccd + " to " + giaTriMoi);
                        pstmtUpdate.executeUpdate();
                        LOGGER.info("Field updated successfully for CCCD: " + cccd);
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in updateChinhSuaRequestStatus: " + e.getMessage());
            throw e;
        }
    }

    private YeuCauChinhSua getChinhSuaRequestById(int maYeuCau) throws SQLException {
        String query = "SELECT * FROM DCD_YeuCauChinhSua WHERE DCD_MaYeuCau = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, maYeuCau);
            LOGGER.info("Fetching chinh sua request with maYeuCau: " + maYeuCau);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String cccd = rs.getString("DCD_CCCD");
                String truongCanSua = rs.getString("DCD_TruongCanSua");
                String giaTriMoi = rs.getString("DCD_GiaTriMoi");
                String trangThai = rs.getString("DCD_TrangThai");
                Timestamp ngayTao = rs.getTimestamp("DCD_NgayTao");
                Timestamp ngayCapNhat = rs.getTimestamp("DCD_NgayCapNhat");
                return new YeuCauChinhSua(maYeuCau, cccd, truongCanSua, giaTriMoi, trangThai, ngayTao, ngayCapNhat);
            }
            LOGGER.info("No chinh sua request found with maYeuCau: " + maYeuCau);
            return null;
        } catch (SQLException e) {
            LOGGER.severe("Error in getChinhSuaRequestById: " + e.getMessage());
            throw e;
        }
    }

    public List<YeuCauDoiMatKhau> getAllDoiMatKhauRequests() throws SQLException {
        List<YeuCauDoiMatKhau> requests = new ArrayList<>();
        String query = "SELECT * FROM DCD_YeuCauDoiMatKhau";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            LOGGER.info("Fetching all doi mat khau requests...");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int maYeuCau = rs.getInt("DCD_MaYeuCau");
                String soDienThoai = rs.getString("DCD_SoDienThoai");
                String matKhauMoi = rs.getString("DCD_MatKhauMoi");
                String trangThai = rs.getString("DCD_TrangThai");
                Timestamp ngayTao = rs.getTimestamp("DCD_NgayTao");
                requests.add(new YeuCauDoiMatKhau(maYeuCau, soDienThoai, matKhauMoi, trangThai, ngayTao));
            }
            LOGGER.info("Fetched " + requests.size() + " doi mat khau requests.");
        } catch (SQLException e) {
            LOGGER.severe("Error in getAllDoiMatKhauRequests: " + e.getMessage());
            throw e;
        }
        return requests;
    }

    public void updateDoiMatKhauRequestStatus(int maYeuCau, String trangThai) throws SQLException {
        try (Connection connection = getConnection()) {
            // Bước 1: Cập nhật trạng thái yêu cầu
            String updateRequestQuery = "UPDATE DCD_YeuCauDoiMatKhau SET DCD_TrangThai = ? WHERE DCD_MaYeuCau = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(updateRequestQuery)) {
                pstmt.setString(1, trangThai);
                pstmt.setInt(2, maYeuCau);
                LOGGER.info("Updating doi mat khau request status for maYeuCau: " + maYeuCau + " to " + trangThai);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    LOGGER.info("Doi mat khau request status updated successfully for maYeuCau: " + maYeuCau);
                } else {
                    LOGGER.warning("No doi mat khau request updated for maYeuCau: " + maYeuCau);
                }
            }

            // Bước 2: Nếu duyệt, cập nhật mật khẩu vào bảng DCD_TaiKhoan
            if ("HOAN_THANH".equals(trangThai)) {
                YeuCauDoiMatKhau request = getDoiMatKhauRequestById(maYeuCau);
                if (request != null) {
                    String soDienThoai = request.getSoDienThoai();
                    String matKhauMoi = request.getMatKhauMoi();
                    String updateQuery = "UPDATE DCD_TaiKhoan SET DCD_MatKhau = ? WHERE DCD_SoDienThoai = ?";
                    try (PreparedStatement pstmtUpdate = connection.prepareStatement(updateQuery)) {
                        pstmtUpdate.setString(1, matKhauMoi);
                        pstmtUpdate.setString(2, soDienThoai);
                        LOGGER.info("Updating password for phone: " + soDienThoai);
                        pstmtUpdate.executeUpdate();
                        LOGGER.info("Password updated successfully for phone: " + soDienThoai);
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in updateDoiMatKhauRequestStatus: " + e.getMessage());
            throw e;
        }
    }

    private YeuCauDoiMatKhau getDoiMatKhauRequestById(int maYeuCau) throws SQLException {
        String query = "SELECT * FROM DCD_YeuCauDoiMatKhau WHERE DCD_MaYeuCau = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, maYeuCau);
            LOGGER.info("Fetching doi mat khau request with maYeuCau: " + maYeuCau);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String soDienThoai = rs.getString("DCD_SoDienThoai");
                String matKhauMoi = rs.getString("DCD_MatKhauMoi");
                String trangThai = rs.getString("DCD_TrangThai");
                Timestamp ngayTao = rs.getTimestamp("DCD_NgayTao");
                return new YeuCauDoiMatKhau(maYeuCau, soDienThoai, matKhauMoi, trangThai, ngayTao);
            }
            LOGGER.info("No doi mat khau request found with maYeuCau: " + maYeuCau);
            return null;
        } catch (SQLException e) {
            LOGGER.severe("Error in getDoiMatKhauRequestById: " + e.getMessage());
            throw e;
        }
    }

    public void updateCongDanInfo(String cccd, String soDienThoai, String email) throws SQLException {
        if (cccd == null || soDienThoai == null || email == null || cccd.trim().isEmpty() || soDienThoai.trim().isEmpty() || email.trim().isEmpty()) {
            LOGGER.warning("Invalid data for updating citizen info: cccd=" + cccd + ", soDienThoai=" + soDienThoai + ", email=" + email);
            throw new SQLException("CCCD, phone number, or email cannot be null or empty.");
        }

        String query = "UPDATE DCD_CongDan SET DCD_SoDienThoai = ?, DCD_Email = ? WHERE DCD_CCCD = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, soDienThoai);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, cccd);
            LOGGER.info("Updating citizen info for CCCD: " + cccd);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                LOGGER.info("Citizen info updated successfully for CCCD: " + cccd);
            } else {
                LOGGER.warning("No citizen info updated for CCCD: " + cccd);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in updateCongDanInfo: " + e.getMessage());
            throw e;
        }
    }
}