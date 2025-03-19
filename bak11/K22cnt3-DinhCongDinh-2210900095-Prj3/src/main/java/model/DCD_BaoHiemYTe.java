package model;

import java.sql.Date;

public class DCD_BaoHiemYTe {
    private String DCD_MaBHYT;
    private String DCD_CCCD;
    private Date DCD_NgayCap;
    private Date DCD_NgayHetHan;
    private String DCD_NoiDangKyKhamBenh;
    private String DCD_TrangThai;
    private Date DCD_NgayTao;

    public DCD_BaoHiemYTe() {}

    public DCD_BaoHiemYTe(String DCD_MaBHYT, String DCD_CCCD, Date DCD_NgayCap, Date DCD_NgayHetHan,
                          String DCD_NoiDangKyKhamBenh, String DCD_TrangThai, Date DCD_NgayTao) {
        this.DCD_MaBHYT = DCD_MaBHYT;
        this.DCD_CCCD = DCD_CCCD;
        this.DCD_NgayCap = DCD_NgayCap;
        this.DCD_NgayHetHan = DCD_NgayHetHan;
        this.DCD_NoiDangKyKhamBenh = DCD_NoiDangKyKhamBenh;
        this.DCD_TrangThai = DCD_TrangThai;
        this.DCD_NgayTao = DCD_NgayTao;
    }

    // Getters và Setters
    public String getDCD_MaBHYT() { return DCD_MaBHYT; }
    public void setDCD_MaBHYT(String DCD_MaBHYT) { this.DCD_MaBHYT = DCD_MaBHYT; }
    public String getDCD_CCCD() { return DCD_CCCD; }
    public void setDCD_CCCD(String DCD_CCCD) { this.DCD_CCCD = DCD_CCCD; }
    public Date getDCD_NgayCap() { return DCD_NgayCap; }
    public void setDCD_NgayCap(Date DCD_NgayCap) { this.DCD_NgayCap = DCD_NgayCap; }
    public Date getDCD_NgayHetHan() { return DCD_NgayHetHan; }
    public void setDCD_NgayHetHan(Date DCD_NgayHetHan) { this.DCD_NgayHetHan = DCD_NgayHetHan; }
    public String getDCD_NoiDangKyKhamBenh() { return DCD_NoiDangKyKhamBenh; }
    public void setDCD_NoiDangKyKhamBenh(String DCD_NoiDangKyKhamBenh) { this.DCD_NoiDangKyKhamBenh = DCD_NoiDangKyKhamBenh; }
    public String getDCD_TrangThai() { return DCD_TrangThai; }
    public void setDCD_TrangThai(String DCD_TrangThai) { this.DCD_TrangThai = DCD_TrangThai; }
    public Date getDCD_NgayTao() { return DCD_NgayTao; }
    public void setDCD_NgayTao(Date DCD_NgayTao) { this.DCD_NgayTao = DCD_NgayTao; }
}