package com.k22cnt3project3dinhcongdinh.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import com.k22cnt3project3dinhcongdinh.model.Enums.*;

@Entity
@Table(name = "dcd_congdan") // Sử dụng lowercase để khớp với cách MySQL xử lý
@Data
public class DCD_CongDan {
    @Id
    @Column(name = "DCD_CCCD", length = 12, nullable = false)
    private String cccd;

    @Column(name = "DCD_HoTen", length = 100, nullable = false)
    private String hoTen;

    @Column(name = "DCD_NgaySinh", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayCap;

    @Column(name = "DCD_NgayHetHan")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayHetHan;

    @Column(name = "DCD_NgayTao", nullable = false, updatable = false, insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ngayTao;
}