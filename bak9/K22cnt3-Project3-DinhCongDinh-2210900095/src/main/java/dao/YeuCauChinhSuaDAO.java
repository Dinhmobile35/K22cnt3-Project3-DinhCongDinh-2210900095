package dao;

import model.YeuCauChinhSua;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class YeuCauChinhSuaDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/K22cnt3_DinhCongDinh_2210900095_Project3_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT = "INSERT INTO DCD_YeuCauChinhSua (DCD_CCCD, DCD_TruongCanSua, DCD_GiaTriMoi, DCD_TrangThai) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM DCD_YeuCauChinhSua";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertRequest(YeuCauChinhSua yeuCau) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setString(1, yeuCau.getCccd());
            ps.setString(2, yeuCau.getTruongCanSua());
            ps.setString(3, yeuCau.getGiaTriMoi());
            ps.setString(4, yeuCau.getTrangThai());
            ps.executeUpdate();
        }
    }

    public List<YeuCauChinhSua> selectAllRequests() throws SQLException {
        List<YeuCauChinhSua> list = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                YeuCauChinhSua yeuCau = new YeuCauChinhSua();
                yeuCau.setMaYeuCau(rs.getInt("DCD_MaYeuCau"));
                yeuCau.setCccd(rs.getString("DCD_CCCD"));
                yeuCau.setTruongCanSua(rs.getString("DCD_TruongCanSua"));
                yeuCau.setGiaTriMoi(rs.getString("DCD_GiaTriMoi"));
                yeuCau.setTrangThai(rs.getString("DCD_TrangThai"));
                yeuCau.setNgayTao(rs.getTimestamp("DCD_NgayTao"));
                yeuCau.setNgayCapNhat(rs.getTimestamp("DCD_NgayCapNhat"));
                list.add(yeuCau);
            }
        }
        return list;
    }
}