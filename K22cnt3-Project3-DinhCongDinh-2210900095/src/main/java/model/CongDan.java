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
    private byte[] hinhAnh; // Trường hinhAnh (nếu có)

    public CongDan(String cccd, String hoTen, Date ngaySinh, String gioiTinh, String soDienThoai, String email, String diaChi, Date ngayCap, Date ngayHetHan, byte[] hinhAnh) {
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
        this.hinhAnh = hinhAnh;
    }

    // Getter
    public String getCccd() { return cccd; }
    public String getHoTen() { return hoTen; }
    public Date getNgaySinh() { return ngaySinh; }
    public String getGioiTinh() { return gioiTinh; }
    public String getSoDienThoai() { return soDienThoai; }
    public String getEmail() { return email; }
    public String getDiaChi() { return diaChi; }
    public Date getNgayCap() { return ngayCap; }
    public Date getNgayHetHan() { return ngayHetHan; }
    public byte[] getHinhAnh() { return hinhAnh; }
}