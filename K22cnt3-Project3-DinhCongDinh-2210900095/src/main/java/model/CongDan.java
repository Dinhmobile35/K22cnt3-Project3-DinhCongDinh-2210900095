package model;

import java.sql.Date;
import java.sql.Timestamp;

public class CongDan {
    private String cccd;        // DCD_CCCD
    private String hoTen;       // DCD_HoTen
    private Date ngaySinh;      // DCD_NgaySinh
    private String gioiTinh;    // DCD_GioiTinh (ENUM: NAM, NỮ, KHÁC)
    private String soDienThoai; // DCD_SoDienThoai (UNIQUE)
    private String email;       // DCD_Email (UNIQUE)
    private String diaChi;      // DCD_DiaChi
    private Date ngayCap;       // DCD_NgayCap
    private Date ngayHetHan;    // DCD_NgayHetHan
    private Timestamp ngayTao;  // DCD_NgayTao (TIMESTAMP)

    // Constructor mặc định
    public CongDan() {
    }

    // Constructor đầy đủ tham số
    public CongDan(String cccd, String hoTen, Date ngaySinh, String gioiTinh, String soDienThoai, String email, String diaChi, Date ngayCap, Date ngayHetHan, Timestamp ngayTao) {
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
        this.ngayTao = ngayTao;
    }

    // Getters
    public String getCccd() {
        return cccd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    // Setters
    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }
}