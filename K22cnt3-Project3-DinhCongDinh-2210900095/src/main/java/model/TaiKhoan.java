package model;

import java.sql.Timestamp;

public class TaiKhoan {
    private String soDienThoai; // DCD_SoDienThoai
    private String cccd;        // DCD_CCCD
    private String matKhau;     // DCD_MatKhau
    private String vaiTro;      // DCD_VaiTro (ENUM: QUAN_TRI, NGUOI_DUNG)
    private String trangThai;   // DCD_TrangThai (ENUM: HOAT_DONG, KHOA)
    private Timestamp ngayTao;  // DCD_NgayTao

    // Constructor mặc định
    public TaiKhoan() {
    }

    // Constructor đầy đủ tham số
    public TaiKhoan(String soDienThoai, String cccd, String matKhau, String vaiTro, String trangThai, Timestamp ngayTao) {
        this.soDienThoai = soDienThoai;
        this.cccd = cccd;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    // Getters
    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getCccd() {
        return cccd;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    // Setters
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }
}