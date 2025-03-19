package model;

import java.sql.Date;

public class DCD_YeuCauChinhSua {
    private int DCD_MaYeuCau;
    private String DCD_CCCD;
    private String DCD_TruongCanSua;
    private String DCD_GiaTriMoi;
    private String DCD_TrangThai;
    private Date DCD_NgayTao;

    public DCD_YeuCauChinhSua() {}

    public DCD_YeuCauChinhSua(int DCD_MaYeuCau, String DCD_CCCD, String DCD_TruongCanSua, String DCD_GiaTriMoi,
                              String DCD_TrangThai, Date DCD_NgayTao) {
        this.DCD_MaYeuCau = DCD_MaYeuCau;
        this.DCD_CCCD = DCD_CCCD;
        this.DCD_TruongCanSua = DCD_TruongCanSua;
        this.DCD_GiaTriMoi = DCD_GiaTriMoi;
        this.DCD_TrangThai = DCD_TrangThai;
        this.DCD_NgayTao = DCD_NgayTao;
    }

    // Getters và Setters
    public int getDCD_MaYeuCau() { return DCD_MaYeuCau; }
    public void setDCD_MaYeuCau(int DCD_MaYeuCau) { this.DCD_MaYeuCau = DCD_MaYeuCau; }
    public String getDCD_CCCD() { return DCD_CCCD; }
    public void setDCD_CCCD(String DCD_CCCD) { this.DCD_CCCD = DCD_CCCD; }
    public String getDCD_TruongCanSua() { return DCD_TruongCanSua; }
    public void setDCD_TruongCanSua(String DCD_TruongCanSua) { this.DCD_TruongCanSua = DCD_TruongCanSua; }
    public String getDCD_GiaTriMoi() { return DCD_GiaTriMoi; }
    public void setDCD_GiaTriMoi(String DCD_GiaTriMoi) { this.DCD_GiaTriMoi = DCD_GiaTriMoi; }
    public String getDCD_TrangThai() { return DCD_TrangThai; }
    public void setDCD_TrangThai(String DCD_TrangThai) { this.DCD_TrangThai = DCD_TrangThai; }
    public Date getDCD_NgayTao() { return DCD_NgayTao; }
    public void setDCD_NgayTao(Date DCD_NgayTao) { this.DCD_NgayTao = DCD_NgayTao; }
}