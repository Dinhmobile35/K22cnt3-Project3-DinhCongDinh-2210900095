package model;

import java.sql.Timestamp;

public class DCD_YeuCauCapLai {
    private int DCD_MaYeuCau;
    private String DCD_CCCD;
    private String DCD_LoaiYeuCau;
    private String DCD_TrangThai;
    private String DCD_TrangThaiGiaoHang;
    private String DCD_TenNguoiNhan;
    private String DCD_SoDienThoaiNhan;
    private String DCD_DiaChiNhan;
    private Timestamp DCD_NgayTao;
    private Timestamp DCD_NgayCapNhat;

    public DCD_YeuCauCapLai() {}

    public DCD_YeuCauCapLai(int DCD_MaYeuCau, String DCD_CCCD, String DCD_LoaiYeuCau, String DCD_TrangThai,
                            String DCD_TrangThaiGiaoHang, String DCD_TenNguoiNhan, String DCD_SoDienThoaiNhan,
                            String DCD_DiaChiNhan, Timestamp DCD_NgayTao, Timestamp DCD_NgayCapNhat) {
        this.DCD_MaYeuCau = DCD_MaYeuCau;
        this.DCD_CCCD = DCD_CCCD;
        this.DCD_LoaiYeuCau = DCD_LoaiYeuCau;
        this.DCD_TrangThai = DCD_TrangThai;
        this.DCD_TrangThaiGiaoHang = DCD_TrangThaiGiaoHang;
        this.DCD_TenNguoiNhan = DCD_TenNguoiNhan;
        this.DCD_SoDienThoaiNhan = DCD_SoDienThoaiNhan;
        this.DCD_DiaChiNhan = DCD_DiaChiNhan;
        this.DCD_NgayTao = DCD_NgayTao;
        this.DCD_NgayCapNhat = DCD_NgayCapNhat;
    }

    // Getters và Setters
    public int getDCD_MaYeuCau() { return DCD_MaYeuCau; }
    public void setDCD_MaYeuCau(int DCD_MaYeuCau) { this.DCD_MaYeuCau = DCD_MaYeuCau; }
    public String getDCD_CCCD() { return DCD_CCCD; }
    public void setDCD_CCCD(String DCD_CCCD) { this.DCD_CCCD = DCD_CCCD; }
    public String getDCD_LoaiYeuCau() { return DCD_LoaiYeuCau; }
    public void setDCD_LoaiYeuCau(String DCD_LoaiYeuCau) { this.DCD_LoaiYeuCau = DCD_LoaiYeuCau; }
    public String getDCD_TrangThai() { return DCD_TrangThai; }
    public void setDCD_TrangThai(String DCD_TrangThai) { this.DCD_TrangThai = DCD_TrangThai; }
    public String getDCD_TrangThaiGiaoHang() { return DCD_TrangThaiGiaoHang; }
    public void setDCD_TrangThaiGiaoHang(String DCD_TrangThaiGiaoHang) { this.DCD_TrangThaiGiaoHang = DCD_TrangThaiGiaoHang; }
    public String getDCD_TenNguoiNhan() { return DCD_TenNguoiNhan; }
    public void setDCD_TenNguoiNhan(String DCD_TenNguoiNhan) { this.DCD_TenNguoiNhan = DCD_TenNguoiNhan; }
    public String getDCD_SoDienThoaiNhan() { return DCD_SoDienThoaiNhan; }
    public void setDCD_SoDienThoaiNhan(String DCD_SoDienThoaiNhan) { this.DCD_SoDienThoaiNhan = DCD_SoDienThoaiNhan; }
    public String getDCD_DiaChiNhan() { return DCD_DiaChiNhan; }
    public void setDCD_DiaChiNhan(String DCD_DiaChiNhan) { this.DCD_DiaChiNhan = DCD_DiaChiNhan; }
    public Timestamp getDCD_NgayTao() { return DCD_NgayTao; }
    public void setDCD_NgayTao(Timestamp DCD_NgayTao) { this.DCD_NgayTao = DCD_NgayTao; }
    public Timestamp getDCD_NgayCapNhat() { return DCD_NgayCapNhat; }
    public void setDCD_NgayCapNhat(Timestamp DCD_NgayCapNhat) { this.DCD_NgayCapNhat = DCD_NgayCapNhat; }
}