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

    // Thêm constructor mặc định
    public YeuCauChinhSua() {
        this.maYeuCau = 0;
        this.cccd = null;
        this.truongCanSua = null;
        this.giaTriMoi = null;
        this.trangThai = null;
        this.ngayTao = null;
        this.ngayCapNhat = null;
    }

    // Constructor với 7 tham số
    public YeuCauChinhSua(int maYeuCau, String cccd, String truongCanSua, String giaTriMoi, String trangThai, Timestamp ngayTao, Timestamp ngayCapNhat) {
        this.maYeuCau = maYeuCau;
        this.cccd = cccd;
        this.truongCanSua = truongCanSua;
        this.giaTriMoi = giaTriMoi;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    // Getter và Setter
    public int getMaYeuCau() { return maYeuCau; }
    public void setMaYeuCau(int maYeuCau) { this.maYeuCau = maYeuCau; }

    public String getCccd() { return cccd; }
    public void setCccd(String cccd) { this.cccd = cccd; }

    public String getTruongCanSua() { return truongCanSua; }
    public void setTruongCanSua(String truongCanSua) { this.truongCanSua = truongCanSua; }

    public String getGiaTriMoi() { return giaTriMoi; }
    public void setGiaTriMoi(String giaTriMoi) { this.giaTriMoi = giaTriMoi; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    public Timestamp getNgayTao() { return ngayTao; }
    public void setNgayTao(Timestamp ngayTao) { this.ngayTao = ngayTao; }

    public Timestamp getNgayCapNhat() { return ngayCapNhat; }
    public void setNgayCapNhat(Timestamp ngayCapNhat) { this.ngayCapNhat = ngayCapNhat; }
}