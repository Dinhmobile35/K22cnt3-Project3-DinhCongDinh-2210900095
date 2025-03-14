package dao;

import model.YeuCauCapLai;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class YeuCauCapLaiDAO {
    private static final Logger LOGGER = Logger.getLogger(YeuCauCapLaiDAO.class.getName());
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

    public void insertYeuCauCapLai(YeuCauCapLai yeuCau) throws SQLException {
        if (yeuCau == null || yeuCau.getCccd() == null || yeuCau.getLoaiYeuCau() == null ||
                yeuCau.getTrangThai() == null || yeuCau.getTenNguoiNhan() == null ||
                yeuCau.getSoDienThoaiNhan() == null || yeuCau.getDiaChiNhan() == null) {
            LOGGER.warning("Invalid YeuCauCapLai object provided for insertion. Required fields (cccd, loaiYeuCau, trangThai, tenNguoiNhan, soDienThoaiNhan, diaChiNhan) cannot be null.");
            throw new SQLException("YeuCauCapLai object or required fields cannot be null.");
        }

        // Kiểm tra giá trị ENUM cho DCD_LoaiYeuCau
        if (!List.of("MOI", "CAP_LAI", "MAT").contains(yeuCau.getLoaiYeuCau())) {
            LOGGER.warning("Invalid DCD_LoaiYeuCau value: " + yeuCau.getLoaiYeuCau());
            throw new SQLException("DCD_LoaiYeuCau must be one of: MOI, CAP_LAI, MAT");
        }

        // Kiểm tra giá trị ENUM cho DCD_TrangThai
        if (!List.of("CHO_DUYET", "DA_DUYET", "TU_CHOI").contains(yeuCau.getTrangThai())) {
            LOGGER.warning("Invalid DCD_TrangThai value: " + yeuCau.getTrangThai());
            throw new SQLException("DCD_TrangThai must be one of: CHO_DUYET, DA_DUYET, TU_CHOI");
        }

        // Kiểm tra giá trị ENUM cho DCD_TrangThaiGiaoHang
        String trangThaiGiaoHang = yeuCau.getTrangThaiGiaoHang() != null ? yeuCau.getTrangThaiGiaoHang() : "CHUA_GIAO";
        if (!List.of("CHUA_GIAO", "DANG_GIAO", "DA_NHAN").contains(trangThaiGiaoHang)) {
            LOGGER.warning("Invalid DCD_TrangThaiGiaoHang value: " + trangThaiGiaoHang);
            throw new SQLException("DCD_TrangThaiGiaoHang must be one of: CHUA_GIAO, DANG_GIAO, DA_NHAN");
        }

        String query = "INSERT INTO DCD_YeuCauCapLai (DCD_CCCD, DCD_LoaiYeuCau, DCD_TrangThai, DCD_TrangThaiGiaoHang, DCD_TenNguoiNhan, DCD_SoDienThoaiNhan, DCD_DiaChiNhan, DCD_NgayTao) VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, yeuCau.getCccd());
            preparedStatement.setString(2, yeuCau.getLoaiYeuCau());
            preparedStatement.setString(3, yeuCau.getTrangThai());
            preparedStatement.setString(4, trangThaiGiaoHang);
            preparedStatement.setString(5, yeuCau.getTenNguoiNhan());
            preparedStatement.setString(6, yeuCau.getSoDienThoaiNhan());
            preparedStatement.setString(7, yeuCau.getDiaChiNhan());
            LOGGER.info("Inserting cap lai request for CCCD: " + yeuCau.getCccd());
            preparedStatement.executeUpdate();
            LOGGER.info("Cap lai request inserted successfully for CCCD: " + yeuCau.getCccd());
        } catch (SQLException e) {
            LOGGER.severe("Error in insertYeuCauCapLai: " + e.getMessage());
            throw e;
        }
    }

    public YeuCauCapLai getYeuCauCapLaiById(int maYeuCau) throws SQLException {
        if (maYeuCau <= 0) {
            LOGGER.warning("Invalid maYeuCau provided: " + maYeuCau);
            return null;
        }

        String query = "SELECT * FROM DCD_YeuCauCapLai WHERE DCD_MaYeuCau = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, maYeuCau);
            LOGGER.info("Fetching cap lai request with maYeuCau: " + maYeuCau);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String cccd = rs.getString("DCD_CCCD");
                String loaiYeuCau = rs.getString("DCD_LoaiYeuCau");
                String trangThai = rs.getString("DCD_TrangThai");
                String trangThaiGiaoHang = rs.getString("DCD_TrangThaiGiaoHang");
                String tenNguoiNhan = rs.getString("DCD_TenNguoiNhan");
                String soDienThoaiNhan = rs.getString("DCD_SoDienThoaiNhan");
                String diaChiNhan = rs.getString("DCD_DiaChiNhan");
                Timestamp ngayTao = rs.getTimestamp("DCD_NgayTao");
                Timestamp ngayCapNhat = rs.getTimestamp("DCD_NgayCapNhat");
                LOGGER.info("Cap lai request found with maYeuCau: " + maYeuCau);
                return new YeuCauCapLai(maYeuCau, cccd, loaiYeuCau, trangThai, trangThaiGiaoHang, tenNguoiNhan, soDienThoaiNhan, diaChiNhan, ngayTao, ngayCapNhat);
            } else {
                LOGGER.info("No cap lai request found with maYeuCau: " + maYeuCau);
                return null;
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in getYeuCauCapLaiById: " + e.getMessage());
            throw e;
        }
    }

    public void updateYeuCauCapLai(YeuCauCapLai yeuCau) throws SQLException {
        if (yeuCau == null || yeuCau.getMaYeuCau() <= 0 || yeuCau.getCccd() == null ||
                yeuCau.getLoaiYeuCau() == null || yeuCau.getTrangThai() == null ||
                yeuCau.getTenNguoiNhan() == null || yeuCau.getSoDienThoaiNhan() == null ||
                yeuCau.getDiaChiNhan() == null) {
            LOGGER.warning("Invalid YeuCauCapLai object provided for update. Required fields (maYeuCau, cccd, loaiYeuCau, trangThai, tenNguoiNhan, soDienThoaiNhan, diaChiNhan) cannot be null or invalid.");
            throw new SQLException("YeuCauCapLai object or required fields must be valid.");
        }

        // Kiểm tra giá trị ENUM cho DCD_LoaiYeuCau
        if (!List.of("MOI", "CAP_LAI", "MAT").contains(yeuCau.getLoaiYeuCau())) {
            LOGGER.warning("Invalid DCD_LoaiYeuCau value: " + yeuCau.getLoaiYeuCau());
            throw new SQLException("DCD_LoaiYeuCau must be one of: MOI, CAP_LAI, MAT");
        }

        // Kiểm tra giá trị ENUM cho DCD_TrangThai
        if (!List.of("CHO_DUYET", "DA_DUYET", "TU_CHOI").contains(yeuCau.getTrangThai())) {
            LOGGER.warning("Invalid DCD_TrangThai value: " + yeuCau.getTrangThai());
            throw new SQLException("DCD_TrangThai must be one of: CHO_DUYET, DA_DUYET, TU_CHOI");
        }

        // Kiểm tra giá trị ENUM cho DCD_TrangThaiGiaoHang
        String trangThaiGiaoHang = yeuCau.getTrangThaiGiaoHang() != null ? yeuCau.getTrangThaiGiaoHang() : "CHUA_GIAO";
        if (!List.of("CHUA_GIAO", "DANG_GIAO", "DA_NHAN").contains(trangThaiGiaoHang)) {
            LOGGER.warning("Invalid DCD_TrangThaiGiaoHang value: " + trangThaiGiaoHang);
            throw new SQLException("DCD_TrangThaiGiaoHang must be one of: CHUA_GIAO, DANG_GIAO, DA_NHAN");
        }

        String query = "UPDATE DCD_YeuCauCapLai SET DCD_CCCD = ?, DCD_LoaiYeuCau = ?, DCD_TrangThai = ?, DCD_TrangThaiGiaoHang = ?, DCD_TenNguoiNhan = ?, DCD_SoDienThoaiNhan = ?, DCD_DiaChiNhan = ?, DCD_NgayCapNhat = CURRENT_TIMESTAMP WHERE DCD_MaYeuCau = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, yeuCau.getCccd());
            preparedStatement.setString(2, yeuCau.getLoaiYeuCau());
            preparedStatement.setString(3, yeuCau.getTrangThai());
            preparedStatement.setString(4, trangThaiGiaoHang);
            preparedStatement.setString(5, yeuCau.getTenNguoiNhan());
            preparedStatement.setString(6, yeuCau.getSoDienThoaiNhan());
            preparedStatement.setString(7, yeuCau.getDiaChiNhan());
            preparedStatement.setInt(8, yeuCau.getMaYeuCau());
            LOGGER.info("Updating cap lai request with maYeuCau: " + yeuCau.getMaYeuCau());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                LOGGER.info("Cap lai request updated successfully with maYeuCau: " + yeuCau.getMaYeuCau());
            } else {
                LOGGER.warning("No cap lai request updated with maYeuCau: " + yeuCau.getMaYeuCau());
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in updateYeuCauCapLai: " + e.getMessage());
            throw e;
        }
    }

    public void updateCapLaiRequestStatus(int maYeuCau, String trangThai, String trangThaiGiaoHang) throws SQLException {
        if (maYeuCau <= 0) {
            LOGGER.warning("Invalid maYeuCau provided: " + maYeuCau);
            throw new SQLException("maYeuCau must be greater than 0.");
        }

        // Kiểm tra giá trị ENUM cho DCD_TrangThai
        if (trangThai == null || !List.of("CHO_DUYET", "DA_DUYET", "TU_CHOI").contains(trangThai)) {
            LOGGER.warning("Invalid DCD_TrangThai value: " + trangThai);
            throw new SQLException("DCD_TrangThai must be one of: CHO_DUYET, DA_DUYET, TU_CHOI");
        }

        // Kiểm tra giá trị ENUM cho DCD_TrangThaiGiaoHang
        if (trangThaiGiaoHang == null || !List.of("CHUA_GIAO", "DANG_GIAO", "DA_NHAN").contains(trangThaiGiaoHang)) {
            LOGGER.warning("Invalid DCD_TrangThaiGiaoHang value: " + trangThaiGiaoHang);
            throw new SQLException("DCD_TrangThaiGiaoHang must be one of: CHUA_GIAO, DANG_GIAO, DA_NHAN");
        }

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

    public void deleteYeuCauCapLai(int maYeuCau) throws SQLException {
        if (maYeuCau <= 0) {
            LOGGER.warning("Invalid maYeuCau provided: " + maYeuCau);
            throw new SQLException("maYeuCau must be greater than 0.");
        }

        String query = "DELETE FROM DCD_YeuCauCapLai WHERE DCD_MaYeuCau = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maYeuCau);
            LOGGER.info("Deleting cap lai request with maYeuCau: " + maYeuCau);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                LOGGER.info("Cap lai request deleted successfully with maYeuCau: " + maYeuCau);
            } else {
                LOGGER.warning("No cap lai request deleted with maYeuCau: " + maYeuCau);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error in deleteYeuCauCapLai: " + e.getMessage());
            throw e;
        }
    }

    public int countCapLaiRequestsByStatus(String trangThai) throws SQLException {
        if (trangThai == null || trangThai.trim().isEmpty()) {
            LOGGER.warning("Invalid status provided: " + trangThai);
            return 0;
        }

        // Kiểm tra giá trị ENUM cho DCD_TrangThai
        if (!List.of("CHO_DUYET", "DA_DUYET", "TU_CHOI").contains(trangThai)) {
            LOGGER.warning("Invalid DCD_TrangThai value: " + trangThai);
            throw new SQLException("DCD_TrangThai must be one of: CHO_DUYET, DA_DUYET, TU_CHOI");
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

    public int countCapLaiRequestsByDeliveryStatus(String trangThaiGiaoHang) throws SQLException {
        if (trangThaiGiaoHang == null || trangThaiGiaoHang.trim().isEmpty()) {
            LOGGER.warning("Invalid delivery status provided: " + trangThaiGiaoHang);
            return 0;
        }

        // Kiểm tra giá trị ENUM cho DCD_TrangThaiGiaoHang
        if (!List.of("CHUA_GIAO", "DANG_GIAO", "DA_NHAN").contains(trangThaiGiaoHang)) {
            LOGGER.warning("Invalid DCD_TrangThaiGiaoHang value: " + trangThaiGiaoHang);
            throw new SQLException("DCD_TrangThaiGiaoHang must be one of: CHUA_GIAO, DANG_GIAO, DA_NHAN");
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
            LOGGER.severe("Error in countCapLaiRequestsByDeliveryStatus: " + e.getMessage());
            throw e;
        }
    }
}