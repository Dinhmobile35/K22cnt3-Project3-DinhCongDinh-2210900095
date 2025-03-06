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

    public CongDan(String cccd, String hoTen, Date ngaySinh, String gioiTinh, String soDienThoai, String email, String diaChi, Date ngayCap, Date ngayHetHan) {
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
    }

    // Getters and setters
    public String getCccd() { return cccd; }
    public void setCccd(String cccd) { this.cccd = cccd; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public Date getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; }
    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }
    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public Date getNgayCap() { return ngayCap; }
    public void setNgayCap(Date ngayCap) { this.ngayCap = ngayCap; }
    public Date getNgayHetHan() { return ngayHetHan; }
    public void setNgayHetHan(Date ngayHetHan) { this.ngayHetHan = ngayHetHan; }

    @Override
    public String toString() {
        return "CCCD: " + cccd + ", Họ tên: " + hoTen + ", Ngày sinh: " + ngaySinh + ", Giới tính: " + gioiTinh +
                ", SĐT: " + soDienThoai + ", Email: " + email + ", Địa chỉ: " + diaChi + ", Ngày cấp: " + ngayCap +
                ", Ngày hết hạn: " + ngayHetHan;
    }
}