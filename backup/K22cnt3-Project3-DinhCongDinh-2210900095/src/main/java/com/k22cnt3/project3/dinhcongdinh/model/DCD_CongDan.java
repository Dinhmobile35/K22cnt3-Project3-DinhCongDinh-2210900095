package com.k22cnt3.project3.dinhcongdinh.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DCD_CongDan")
public class DCD_CongDan {
    @Id
    @Column(name = "DCD_CCCD", length = 12, nullable = false)
    private String cccd;

    @Column(name = "DCD_HoTen", length = 100, nullable = false)
    private String hoTen;

    @Column(name = "DCD_NgaySinh", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "DCD_GioiTinh", nullable = false)
    @Enumerated(EnumType.STRING)
    private GioiTinh gioiTinh;

    @Column(name = "DCD_SoDienThoai", length = 15, unique = true)
    private String soDienThoai;

    @Column(name = "DCD_Email", length = 100, unique = true)
    private String email;

    @Column(name = "DCD_DiaChi", columnDefinition = "TEXT", nullable = false)
    private String diaChi;

    @Column(name = "DCD_NgayCap", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngayCap;

    @Column(name = "DCD_NgayHetHan")
    @Temporal(TemporalType.DATE)
    private Date ngayHetHan;

    @Column(name = "DCD_NgayTao", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao = new Date();

    // Getters và Setters
}

enum GioiTinh {
    NAM, NU, KHAC
}
