package model;

import java.sql.Timestamp;

public class TaiKhoan {
    private String soDienThoai;
    private String cccd;
    private String matKhau;
    private String vaiTro;
    private String trangThai;
    private Timestamp ngayTao;

    public TaiKhoan(String soDienThoai, String cccd, String matKhau, String vaiTro, String trangThai, Timestamp ngayTao) {
        this.soDienThoai = soDienThoai;
        this.cccd = cccd;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    // Getters và Setters
    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
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
}