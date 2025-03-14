package model;

import java.sql.Date;

public class CongDan {
    private String cccd;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private Date ngayCap;
    private Date ngayHetHan;
    private String image; // Thuộc tính này có thể là null nếu không sử dụng

    // Constructor đầy đủ
    public CongDan(String cccd, String hoTen, Date ngaySinh, String gioiTinh, String soDienThoai,
                   String email, String diaChi, Date ngayCap, Date ngayHetHan, String image) {
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
        this.image = image;
    }

    // Constructor không có image (dùng khi image là null)
    public CongDan(String cccd, String hoTen, Date ngaySinh, String gioiTinh, String soDienThoai,
                   String email, String diaChi, Date ngayCap, Date ngayHetHan) {
        this(cccd, hoTen, ngaySinh, gioiTinh, soDienThoai, email, diaChi, ngayCap, ngayHetHan, null);
    }

    // Getters và Setters
    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}