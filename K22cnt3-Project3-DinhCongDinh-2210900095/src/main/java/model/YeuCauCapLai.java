package model;

import java.sql.Timestamp;

public class YeuCauCapLai {
    private int maYeuCau;           // DCD_MaYeuCau
    private String cccd;            // DCD_CCCD
    private String loaiYeuCau;      // DCD_LoaiYeuCau (ENUM: MOI, CAP_LAI, MAT)
    private String trangThai;       // DCD_TrangThai (ENUM: CHO_DUYET, DA_DUYET, TU_CHOI)
    private String trangThaiGiaoHang; // DCD_TrangThaiGiaoHang (ENUM: CHUA_GIAO, DANG_GIAO, DA_NHAN)
    private String tenNguoiNhan;    // DCD_TenNguoiNhan
    private String soDienThoaiNhan; // DCD_SoDienThoaiNhan
    private String diaChiNhan;      // DCD_DiaChiNhan
    private Timestamp ngayTao;      // DCD_NgayTao
    private Timestamp ngayCapNhat;  // DCD_NgayCapNhat

    // Constructor mặc định
    public YeuCauCapLai() {
    }

    // Constructor đầy đủ tham số
    public YeuCauCapLai(int maYeuCau, String cccd, String loaiYeuCau, String trangThai, String trangThaiGiaoHang, String tenNguoiNhan, String soDienThoaiNhan, String diaChiNhan, Timestamp ngayTao, Timestamp ngayCapNhat) {
        this.maYeuCau = maYeuCau;
        this.cccd = cccd;
        this.loaiYeuCau = loaiYeuCau;
        this.trangThai = trangThai;
        this.trangThaiGiaoHang = trangThaiGiaoHang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.soDienThoaiNhan = soDienThoaiNhan;
        this.diaChiNhan = diaChiNhan;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    // Getters
    public int getMaYeuCau() {
        return maYeuCau;
    }

    public String getCccd() {
        return cccd;
    }

    public String getLoaiYeuCau() {
        return loaiYeuCau;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getTrangThaiGiaoHang() {
        return trangThaiGiaoHang;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public String getSoDienThoaiNhan() {
        return soDienThoaiNhan;
    }

    public String getDiaChiNhan() {
        return diaChiNhan;
    }

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    public Timestamp getNgayCapNhat() {
        return ngayCapNhat;
    }

    // Setters
    public void setMaYeuCau(int maYeuCau) {
        this.maYeuCau = maYeuCau;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setLoaiYeuCau(String loaiYeuCau) {
        this.loaiYeuCau = loaiYeuCau;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setTrangThaiGiaoHang(String trangThaiGiaoHang) {
        this.trangThaiGiaoHang = trangThaiGiaoHang;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public void setSoDienThoaiNhan(String soDienThoaiNhan) {
        this.soDienThoaiNhan = soDienThoaiNhan;
    }

    public void setDiaChiNhan(String diaChiNhan) {
        this.diaChiNhan = diaChiNhan;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setNgayCapNhat(Timestamp ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }
}