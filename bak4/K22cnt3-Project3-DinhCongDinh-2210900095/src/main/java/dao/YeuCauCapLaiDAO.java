package dao;

import model.YeuCauCapLai;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class YeuCauCapLaiDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/K22cnt3_DinhCongDinh_2210900095_Project3_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT = "INSERT INTO DCD_YeuCauCapLai (DCD_CCCD, DCD_LoaiYeuCau, DCD_TrangThai, DCD_TrangThaiGiaoHang, DCD_TenNguoiNhan, DCD_SoDienThoaiNhan, DCD_DiaChiNhan) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM DCD_YeuCauCapLai";
    private static final String UPDATE_STATUS = "UPDATE DCD_YeuCauCapLai SET DCD_TrangThai = ? WHERE DCD_MaYeuCau = ?";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertRequest(YeuCauCapLai yeuCau) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setString(1, yeuCau.getCccd());
            ps.setString(2, yeuCau.getLoaiYeuCau());
            ps.setString(3, yeuCau.getTrangThai());
            ps.setString(4, yeuCau.getTrangThaiGiaoHang());
            ps.setString(5, yeuCau.getTenNguoiNhan());
            ps.setString(6, yeuCau.getSoDienThoaiNhan());
            ps.setString(7, yeuCau.getDiaChiNhan());
            ps.executeUpdate();
        }
    }

    public List<YeuCauCapLai> selectAllRequests() throws SQLException {
        List<YeuCauCapLai> list = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                YeuCauCapLai yeuCau = new YeuCauCapLai();
                yeuCau.setMaYeuCau(rs.getInt("DCD_MaYeuCau"));
                yeuCau.setCccd(rs.getString("DCD_CCCD"));
                yeuCau.setLoaiYeuCau(rs.getString("DCD_LoaiYeuCau"));
                yeuCau.setTrangThai(rs.getString("DCD_TrangThai"));
                yeuCau.setTrangThaiGiaoHang(rs.getString("DCD_TrangThaiGiaoHang"));
                yeuCau.setTenNguoiNhan(rs.getString("DCD_TenNguoiNhan"));
                yeuCau.setSoDienThoaiNhan(rs.getString("DCD_SoDienThoaiNhan"));
                yeuCau.setDiaChiNhan(rs.getString("DCD_DiaChiNhan"));
                yeuCau.setNgayTao(rs.getTimestamp("DCD_NgayTao"));
                yeuCau.setNgayCapNhat(rs.getTimestamp("DCD_NgayCapNhat"));
                list.add(yeuCau);
            }
        }
        return list;
    }

    public void updateStatus(int maYeuCau, String trangThai) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(UPDATE_STATUS)) {
            ps.setString(1, trangThai);
            ps.setInt(2, maYeuCau);
            ps.executeUpdate();
        }
    }
}