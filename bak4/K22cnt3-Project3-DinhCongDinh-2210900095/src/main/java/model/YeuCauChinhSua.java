package model;

import java.sql.Timestamp;

public class YeuCauChinhSua {
    private int maYeuCau;
    private String cccd;
    private String truongCanSua;
    private String giaTriMoi;
    private String trangThai;
    private Timestamp ngayTao;
    private Timestamp ngayCapNhat;

    // Constructor không tham số
    public YeuCauChinhSua() {}

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

    // Getters và Setters
    public int getMaYeuCau() {
        return maYeuCau;
    }

    public void setMaYeuCau(int maYeuCau) {
        this.maYeuCau = maYeuCau;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getTruongCanSua() {
        return truongCanSua;
    }

    public void setTruongCanSua(String truongCanSua) {
        this.truongCanSua = truongCanSua;
    }

    public String getGiaTriMoi() {
        return giaTriMoi;
    }

    public void setGiaTriMoi(String giaTriMoi) {
        this.giaTriMoi = giaTriMoi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Timestamp getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Timestamp ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }
}