package com.k22cnt3.project3.dinhcongdinh.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DCD_TaiKhoan")
public class DCD_TaiKhoan {

    @Id
    @Column(name = "DCD_CCCD", length = 12, nullable = false)
    private String cccd;

    @Column(name = "DCD_HoTen", length = 100, nullable = false)
    private String hoTen;

    @Column(name = "DCD_SoDienThoai", length = 15, unique = true, nullable = false)
    private String soDienThoai;

    @Column(name = "DCD_MatKhau", length = 100, nullable = false)
    private String matKhau;

    @Column(name = "DCD_Email", length = 100)
    private String email;

    // Constructor không tham số
    public DCD_TaiKhoan() {
    }

    // Getter và Setter
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
