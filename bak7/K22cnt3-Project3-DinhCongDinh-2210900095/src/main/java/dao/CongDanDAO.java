package dao;

import model.CongDan;
import model.TaiKhoan;
import model.YeuCauCapLai;
import model.YeuCauChinhSua;
import model.YeuCauDoiMatKhau;

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

    public CongDan getCongDanByPhone(String soDienThoai) throws SQLException {
        CongDan congDan = null;
        String query = "SELECT * FROM DCD_CongDan WHERE DCD_SoDienThoai = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, soDienThoai);
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
            preparedStatement.setString(4, congDan.getGioiTinh().equals("Nữ") ? "Nu" : congDan.getGioiTinh());
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
            preparedStatement.setString(3, congDan.getGioiTinh().equals("Nữ") ? "Nu" : congDan.getGioiTinh());
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
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
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
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
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
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, soDienThoai);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }

    public int countCongDan() throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_CongDan";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

    public int countTaiKhoan() throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_TaiKhoan";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

    public int countLockedTaiKhoan() throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_TaiKhoan WHERE DCD_TrangThai = 'KHOA'";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

    public List<TaiKhoan> selectAllTaiKhoan() throws SQLException {
        List<TaiKhoan> taiKhoanList = new ArrayList<>();
        String query = "SELECT * FROM DCD_TaiKhoan";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
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

    public void updateTaiKhoanStatus(String soDienThoai, String trangThai) throws SQLException {
        String query = "UPDATE DCD_TaiKhoan SET DCD_TrangThai = ? WHERE DCD_SoDienThoai = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, trangThai);
            pstmt.setString(2, soDienThoai);
            pstmt.executeUpdate();
        }
    }

    public int countCapLaiRequestsByStatus(String trangThai) throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_YeuCauCapLai WHERE DCD_TrangThai = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, trangThai);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

    public int countCapLaiRequestsByStatusAndDelivery(String trangThaiGiaoHang) throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_YeuCauCapLai WHERE DCD_TrangThaiGiaoHang = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, trangThaiGiaoHang);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

    public int countChinhSuaRequestsByStatus(String trangThai) throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_YeuCauChinhSua WHERE DCD_TrangThai = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, trangThai);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

    public int countDoiMatKhauRequestsByStatus(String trangThai) throws SQLException {
        String query = "SELECT COUNT(*) FROM DCD_YeuCauDoiMatKhau WHERE DCD_TrangThai = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, trangThai);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

    public List<YeuCauCapLai> getAllCapLaiRequests() throws SQLException {
        List<YeuCauCapLai> requests = new ArrayList<>();
        String query = "SELECT * FROM DCD_YeuCauCapLai";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
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
            pstmt.executeUpdate();
        }
    }

    public List<YeuCauChinhSua> getAllChinhSuaRequests() throws SQLException {
        List<YeuCauChinhSua> requests = new ArrayList<>();
        String query = "SELECT * FROM DCD_YeuCauChinhSua";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
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
                pstmt.executeUpdate();
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
                    }
                    try (PreparedStatement pstmtUpdate = connection.prepareStatement(updateQuery)) {
                        pstmtUpdate.setString(1, giaTriMoi);
                        pstmtUpdate.setString(2, cccd);
                        pstmtUpdate.executeUpdate();
                    }
                }
            }
        }
    }

    private YeuCauChinhSua getChinhSuaRequestById(int maYeuCau) throws SQLException {
        String query = "SELECT * FROM DCD_YeuCauChinhSua WHERE DCD_MaYeuCau = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, maYeuCau);
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
        }
        return null;
    }

    public List<YeuCauDoiMatKhau> getAllDoiMatKhauRequests() throws SQLException {
        List<YeuCauDoiMatKhau> requests = new ArrayList<>();
        String query = "SELECT * FROM DCD_YeuCauDoiMatKhau";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int maYeuCau = rs.getInt("DCD_MaYeuCau");
                String soDienThoai = rs.getString("DCD_SoDienThoai");
                String matKhauMoi = rs.getString("DCD_MatKhauMoi");
                String trangThai = rs.getString("DCD_TrangThai");
                Timestamp ngayTao = rs.getTimestamp("DCD_NgayTao");
                requests.add(new YeuCauDoiMatKhau(maYeuCau, soDienThoai, matKhauMoi, trangThai, ngayTao));
            }
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
                pstmt.executeUpdate();
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
                        pstmtUpdate.executeUpdate();
                    }
                }
            }
        }
    }

    private YeuCauDoiMatKhau getDoiMatKhauRequestById(int maYeuCau) throws SQLException {
        String query = "SELECT * FROM DCD_YeuCauDoiMatKhau WHERE DCD_MaYeuCau = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, maYeuCau);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String soDienThoai = rs.getString("DCD_SoDienThoai");
                String matKhauMoi = rs.getString("DCD_MatKhauMoi");
                String trangThai = rs.getString("DCD_TrangThai");
                Timestamp ngayTao = rs.getTimestamp("DCD_NgayTao");
                return new YeuCauDoiMatKhau(maYeuCau, soDienThoai, matKhauMoi, trangThai, ngayTao);
            }
        }
        return null;
    }

    public boolean isCccdExists(String cccd) throws SQLException {
        String query = "SELECT DCD_CCCD FROM DCD_CongDan WHERE DCD_CCCD = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, cccd);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }

    public void insertTaiKhoan(String soDienThoai, String cccd, String matKhau, String vaiTro, String trangThai) throws SQLException {
        // Kiểm tra xem DCD_CCCD có tồn tại trong DCD_CongDan hay không
        if (!isCccdExists(cccd)) {
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
            preparedStatement.executeUpdate();
        }
    }

    public void updateTaiKhoan(String soDienThoai, String cccd, String matKhau, String vaiTro, String trangThai) throws SQLException {
        // Kiểm tra xem DCD_CCCD có tồn tại trong DCD_CongDan hay không
        if (!isCccdExists(cccd)) {
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
            preparedStatement.executeUpdate();
        }
    }
}