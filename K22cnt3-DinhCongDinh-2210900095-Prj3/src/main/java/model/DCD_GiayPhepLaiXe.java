package model;

import java.sql.Date;
import java.sql.Timestamp; // Thêm import cho Timestamp

public class DCD_GiayPhepLaiXe {
    private String DCD_SoGPLX;
    private String DCD_CCCD;
    private String DCD_HangGPLX;
    private Date DCD_NgayCap;
    private Date DCD_NgayHetHan;
    private String DCD_NoiCap;
    private String DCD_TrangThai;
    private Timestamp DCD_NgayTao; // Sửa từ Date thành Timestamp

    public DCD_GiayPhepLaiXe() {}

    public DCD_GiayPhepLaiXe(String DCD_SoGPLX, String DCD_CCCD, String DCD_HangGPLX, Date DCD_NgayCap,
                             Date DCD_NgayHetHan, String DCD_NoiCap, String DCD_TrangThai, Timestamp DCD_NgayTao) {
        this.DCD_SoGPLX = DCD_SoGPLX;
        this.DCD_CCCD = DCD_CCCD;
        this.DCD_HangGPLX = DCD_HangGPLX;
        this.DCD_NgayCap = DCD_NgayCap;
        this.DCD_NgayHetHan = DCD_NgayHetHan;
        this.DCD_NoiCap = DCD_NoiCap;
        this.DCD_TrangThai = DCD_TrangThai;
        this.DCD_NgayTao = DCD_NgayTao;
    }

    // Getters và Setters
    public String getDCD_SoGPLX() { return DCD_SoGPLX; }
    public void setDCD_SoGPLX(String DCD_SoGPLX) { this.DCD_SoGPLX = DCD_SoGPLX; }
    public String getDCD_CCCD() { return DCD_CCCD; }
    public void setDCD_CCCD(String DCD_CCCD) { this.DCD_CCCD = DCD_CCCD; }
    public String getDCD_HangGPLX() { return DCD_HangGPLX; }
    public void setDCD_HangGPLX(String DCD_HangGPLX) { this.DCD_HangGPLX = DCD_HangGPLX; }
    public Date getDCD_NgayCap() { return DCD_NgayCap; }
    public void setDCD_NgayCap(Date DCD_NgayCap) { this.DCD_NgayCap = DCD_NgayCap; }
    public Date getDCD_NgayHetHan() { return DCD_NgayHetHan; }
    public void setDCD_NgayHetHan(Date DCD_NgayHetHan) { this.DCD_NgayHetHan = DCD_NgayHetHan; }
    public String getDCD_NoiCap() { return DCD_NoiCap; }
    public void setDCD_NoiCap(String DCD_NoiCap) { this.DCD_NoiCap = DCD_NoiCap; }
    public String getDCD_TrangThai() { return DCD_TrangThai; }
    public void setDCD_TrangThai(String DCD_TrangThai) { this.DCD_TrangThai = DCD_TrangThai; }
    public Timestamp getDCD_NgayTao() { return DCD_NgayTao; } // Sửa thành Timestamp
    public void setDCD_NgayTao(Timestamp DCD_NgayTao) { this.DCD_NgayTao = DCD_NgayTao; } // Sửa thành Timestamp
}