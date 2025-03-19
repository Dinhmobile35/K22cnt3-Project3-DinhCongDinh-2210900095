package model;

import java.sql.Date;

public class DCD_GiayPhepLaiXe {
    private String DCD_SoGPLX;
    private String DCD_CCCD;
    private String DCD_LoaiGPLX;
    private Date DCD_NgayCap;
    private Date DCD_NgayHetHan;
    private String DCD_TrangThai;
    private Date DCD_NgayTao;

    public DCD_GiayPhepLaiXe() {}

    public DCD_GiayPhepLaiXe(String DCD_SoGPLX, String DCD_CCCD, String DCD_LoaiGPLX, Date DCD_NgayCap,
                             Date DCD_NgayHetHan, String DCD_TrangThai, Date DCD_NgayTao) {
        this.DCD_SoGPLX = DCD_SoGPLX;
        this.DCD_CCCD = DCD_CCCD;
        this.DCD_LoaiGPLX = DCD_LoaiGPLX;
        this.DCD_NgayCap = DCD_NgayCap;
        this.DCD_NgayHetHan = DCD_NgayHetHan;
        this.DCD_TrangThai = DCD_TrangThai;
        this.DCD_NgayTao = DCD_NgayTao;
    }

    // Getters và Setters
    public String getDCD_SoGPLX() { return DCD_SoGPLX; }
    public void setDCD_SoGPLX(String DCD_SoGPLX) { this.DCD_SoGPLX = DCD_SoGPLX; }
    public String getDCD_CCCD() { return DCD_CCCD; }
    public void setDCD_CCCD(String DCD_CCCD) { this.DCD_CCCD = DCD_CCCD; }
    public String getDCD_LoaiGPLX() { return DCD_LoaiGPLX; }
    public void setDCD_LoaiGPLX(String DCD_LoaiGPLX) { this.DCD_LoaiGPLX = DCD_LoaiGPLX; }
    public Date getDCD_NgayCap() { return DCD_NgayCap; }
    public void setDCD_NgayCap(Date DCD_NgayCap) { this.DCD_NgayCap = DCD_NgayCap; }
    public Date getDCD_NgayHetHan() { return DCD_NgayHetHan; }
    public void setDCD_NgayHetHan(Date DCD_NgayHetHan) { this.DCD_NgayHetHan = DCD_NgayHetHan; }
    public String getDCD_TrangThai() { return DCD_TrangThai; }
    public void setDCD_TrangThai(String DCD_TrangThai) { this.DCD_TrangThai = DCD_TrangThai; }
    public Date getDCD_NgayTao() { return DCD_NgayTao; }
    public void setDCD_NgayTao(Date DCD_NgayTao) { this.DCD_NgayTao = DCD_NgayTao; }
}