package com.k22cnt3.project3.dinhcongdinh.model;



import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DCD_YeuCauChinhSua")
public class DCD_YeuCauChinhSua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DCD_MaYeuCau")
    private Long maYeuCau;

    @ManyToOne
    @JoinColumn(name = "DCD_CCCD", nullable = false)
    private DCD_CongDan congDan;

    @Enumerated(EnumType.STRING)
    @Column(name = "DCD_TruongCanSua", nullable = false)
    private TruongCanSua truongCanSua;

    @Column(name = "DCD_GiaTriMoi", length = 100, nullable = false)
    private String giaTriMoi;

    @Enumerated(EnumType.STRING)
    @Column(name = "DCD_TrangThai", nullable = false)
    private TrangThaiYeuCau trangThai = TrangThaiYeuCau.CHO_DUYET;

    @Column(name = "DCD_NgayTao", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao = new Date();

    @Column(name = "DCD_NgayCapNhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayCapNhat = new Date();

    // Getters và Setters
}

enum TruongCanSua {
    SO_DIEN_THOAI, EMAIL
}
