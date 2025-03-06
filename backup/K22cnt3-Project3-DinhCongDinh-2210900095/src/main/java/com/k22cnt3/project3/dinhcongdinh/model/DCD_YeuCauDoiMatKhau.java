package com.k22cnt3.project3.dinhcongdinh.model;



import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DCD_YeuCauDoiMatKhau")
public class DCD_YeuCauDoiMatKhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DCD_MaYeuCau")
    private Long maYeuCau;

    @ManyToOne
    @JoinColumn(name = "DCD_SoDienThoai", nullable = false)
    private DCD_TaiKhoan taiKhoan;

    @Column(name = "DCD_MatKhauMoi", length = 100, nullable = false)
    private String matKhauMoi;

    @Enumerated(EnumType.STRING)
    @Column(name = "DCD_TrangThai", nullable = false)
    private TrangThaiDoiMatKhau trangThai = TrangThaiDoiMatKhau.CHO_DUYET;

    @Column(name = "DCD_NgayTao", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao = new Date();

    // Getters và Setters
}

enum TrangThaiDoiMatKhau {
    CHO_DUYET, HOAN_THANH
}
