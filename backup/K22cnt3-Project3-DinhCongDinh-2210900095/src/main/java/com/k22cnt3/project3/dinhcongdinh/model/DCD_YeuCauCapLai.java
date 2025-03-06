package com.k22cnt3.project3.dinhcongdinh.model;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DCD_YeuCauCapLai")
public class DCD_YeuCauCapLai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DCD_MaYeuCau")
    private Long maYeuCau;

    @ManyToOne
    @JoinColumn(name = "DCD_CCCD", nullable = false)
    private DCD_CongDan congDan;

    @Enumerated(EnumType.STRING)
    @Column(name = "DCD_LoaiYeuCau", nullable = false)
    private LoaiYeuCau loaiYeuCau;

    @Enumerated(EnumType.STRING)
    @Column(name = "DCD_TrangThai", nullable = false)
    private TrangThaiYeuCau trangThai = TrangThaiYeuCau.CHO_DUYET;

    @Enumerated(EnumType.STRING)
    @Column(name = "DCD_TrangThaiGiaoHang", nullable = false)
    private TrangThaiGiaoHang trangThaiGiaoHang = TrangThaiGiaoHang.CHUA_GIAO;

    @Column(name = "DCD_TenNguoiNhan", length = 100, nullable = false)
    private String tenNguoiNhan;

    @Column(name = "DCD_SoDienThoaiNhan", length = 15, nullable = false)
    private String soDienThoaiNhan;

    @Column(name = "DCD_DiaChiNhan", columnDefinition = "TEXT", nullable = false)
    private String diaChiNhan;

    @Column(name = "DCD_NgayTao", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao = new Date();

    @Column(name = "DCD_NgayCapNhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayCapNhat = new Date();

    // Getters và Setters
}

enum LoaiYeuCau {
    MOI, CAP_LAI, MAT
}

enum TrangThaiYeuCau {
    CHO_DUYET, DA_DUYET, TU_CHOI
}

enum TrangThaiGiaoHang {
    CHUA_GIAO, DANG_GIAO, DA_NHAN
}
