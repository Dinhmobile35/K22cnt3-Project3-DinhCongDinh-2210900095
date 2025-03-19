package model;

import java.sql.Timestamp;

public class YeuCauDoiMatKhau {
    private int maYeuCau;       // DCD_MaYeuCau
    private String soDienThoai; // DCD_SoDienThoai
    private String matKhauMoi;  // DCD_MatKhauMoi
    private String trangThai;   // DCD_TrangThai (ENUM: CHO_DUYET, HOAN_THANH)
    private Timestamp ngayTao;  // DCD_NgayTao

    // Constructor mặc định
    public YeuCauDoiMatKhau() {
    }

    // Constructor đầy đủ tham số
    public YeuCauDoiMatKhau(int maYeuCau, String soDienThoai, String matKhauMoi, String trangThai, Timestamp ngayTao) {
        this.maYeuCau = maYeuCau;
        this.soDienThoai = soDienThoai;
        this.matKhauMoi = matKhauMoi;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    // Getters
    public int getMaYeuCau() {
        return maYeuCau;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getMatKhauMoi() {
        return matKhauMoi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    // Setters
    public void setMaYeuCau(int maYeuCau) {
        this.maYeuCau = maYeuCau;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setMatKhauMoi(String matKhauMoi) {
        this.matKhauMoi = matKhauMoi;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }
}