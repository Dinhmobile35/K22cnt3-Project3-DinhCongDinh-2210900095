package model;

import java.sql.Date;

public class DCD_CongDan {
    private String DCD_CCCD;
    private String DCD_HoTen;
    private Date DCD_NgaySinh;
    private String DCD_GioiTinh;
    private String DCD_SoDienThoai;
    private String DCD_Email;
    private String DCD_DiaChi;
    private Date DCD_NgayCap;
    private Date DCD_NgayHetHan;
    private String DCD_MatKhau;
    private String DCD_VaiTro;
    private String DCD_TrangThai;
    private Date DCD_NgayTao;

    // Constructor mặc định
    public DCD_CongDan() {}

    // Constructor đầy đủ
    public DCD_CongDan(String DCD_CCCD, String DCD_HoTen, Date DCD_NgaySinh, String DCD_GioiTinh,
                       String DCD_SoDienThoai, String DCD_Email, String DCD_DiaChi, Date DCD_NgayCap,
                       Date DCD_NgayHetHan, String DCD_MatKhau, String DCD_VaiTro, String DCD_TrangThai,
                       Date DCD_NgayTao) {
        this.DCD_CCCD = DCD_CCCD;
        this.DCD_HoTen = DCD_HoTen;
        this.DCD_NgaySinh = DCD_NgaySinh;
        this.DCD_GioiTinh = DCD_GioiTinh;
        this.DCD_SoDienThoai = DCD_SoDienThoai;
        this.DCD_Email = DCD_Email;
        this.DCD_DiaChi = DCD_DiaChi;
        this.DCD_NgayCap = DCD_NgayCap;
        this.DCD_NgayHetHan = DCD_NgayHetHan;
        this.DCD_MatKhau = DCD_MatKhau;
        this.DCD_VaiTro = DCD_VaiTro;
        this.DCD_TrangThai = DCD_TrangThai;
        this.DCD_NgayTao = DCD_NgayTao;
    }

    // Getters và Setters
    public String getDCD_CCCD() { return DCD_CCCD; }
    public void setDCD_CCCD(String DCD_CCCD) { this.DCD_CCCD = DCD_CCCD; }
    public String getDCD_HoTen() { return DCD_HoTen; }
    public void setDCD_HoTen(String DCD_HoTen) { this.DCD_HoTen = DCD_HoTen; }
    public Date getDCD_NgaySinh() { return DCD_NgaySinh; }
    public void setDCD_NgaySinh(Date DCD_NgaySinh) { this.DCD_NgaySinh = DCD_NgaySinh; }
    public String getDCD_GioiTinh() { return DCD_GioiTinh; }
    public void setDCD_GioiTinh(String DCD_GioiTinh) { this.DCD_GioiTinh = DCD_GioiTinh; }
    public String getDCD_SoDienThoai() { return DCD_SoDienThoai; }
    public void setDCD_SoDienThoai(String DCD_SoDienThoai) { this.DCD_SoDienThoai = DCD_SoDienThoai; }
    public String getDCD_Email() { return DCD_Email; }
    public void setDCD_Email(String DCD_Email) { this.DCD_Email = DCD_Email; }
    public String getDCD_DiaChi() { return DCD_DiaChi; }
    public void setDCD_DiaChi(String DCD_DiaChi) { this.DCD_DiaChi = DCD_DiaChi; }
    public Date getDCD_NgayCap() { return DCD_NgayCap; }
    public void setDCD_NgayCap(Date DCD_NgayCap) { this.DCD_NgayCap = DCD_NgayCap; }
    public Date getDCD_NgayHetHan() { return DCD_NgayHetHan; }
    public void setDCD_NgayHetHan(Date DCD_NgayHetHan) { this.DCD_NgayHetHan = DCD_NgayHetHan; }
    public String getDCD_MatKhau() { return DCD_MatKhau; }
    public void setDCD_MatKhau(String DCD_MatKhau) { this.DCD_MatKhau = DCD_MatKhau; }
    public String getDCD_VaiTro() { return DCD_VaiTro; }
    public void setDCD_VaiTro(String DCD_VaiTro) { this.DCD_VaiTro = DCD_VaiTro; }
    public String getDCD_TrangThai() { return DCD_TrangThai; }
    public void setDCD_TrangThai(String DCD_TrangThai) { this.DCD_TrangThai = DCD_TrangThai; }
    public Date getDCD_NgayTao() { return DCD_NgayTao; }
    public void setDCD_NgayTao(Date DCD_NgayTao) { this.DCD_NgayTao = DCD_NgayTao; }
}