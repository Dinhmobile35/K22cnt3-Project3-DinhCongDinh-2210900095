package model;

import java.sql.Timestamp;

public class YeuCauChinhSua {
    private int maYeuCau;       // DCD_MaYeuCau
    private String cccd;        // DCD_CCCD
    private String truongCanSua; // DCD_TruongCanSua (ENUM: DCD_SoDienThoai, DCD_Email)
    private String giaTriMoi;   // DCD_GiaTriMoi
    private String trangThai;   // DCD_TrangThai (ENUM: CHO_DUYET, DA_DUYET, TU_CHOI)
    private Timestamp ngayTao;  // DCD_NgayTao
    private Timestamp ngayCapNhat; // DCD_NgayCapNhat

    // Constructor mặc định
    public YeuCauChinhSua() {
    }

    // Constructor đầy đủ tham số
    public YeuCauChinhSua(int maYeuCau, String cccd, String truongCanSua, String giaTriMoi, String trangThai, Timestamp ngayTao, Timestamp ngayCapNhat) {
        this.maYeuCau = maYeuCau;
        this.cccd = cccd;
        this.truongCanSua = truongCanSua;
        this.giaTriMoi = giaTriMoi;
        this.trangThai = trangThai;
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

    public String getTruongCanSua() {
        return truongCanSua;
    }

    public String getGiaTriMoi() {
        return giaTriMoi;
    }

    public String getTrangThai() {
        return trangThai;
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

    public void setTruongCanSua(String truongCanSua) {
        this.truongCanSua = truongCanSua;
    }

    public void setGiaTriMoi(String giaTriMoi) {
        this.giaTriMoi = giaTriMoi;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setNgayCapNhat(Timestamp ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }
}