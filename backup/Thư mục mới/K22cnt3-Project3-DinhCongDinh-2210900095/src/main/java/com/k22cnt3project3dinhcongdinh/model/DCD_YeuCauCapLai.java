package com.k22cnt3project3dinhcongdinh.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import com.k22cnt3project3dinhcongdinh.model.Enums.*;

@Entity
@Table(name = "DCD_YeuCauCapLai")
@Data
public class DCD_YeuCauCapLai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DCD_MaYeuCau")
    private Integer maYeuCau;

    @Column(name = "DCD_CCCD", nullable = false, length = 12)
    private String cccd;

    @Enumerated(EnumType.STRING)
    @Column(name = "DCD_LoaiYeuCau", nullable = false)
    private LoaiYeuCau loaiYeuCau;

    @Enumerated(EnumType.STRING)
    @Column(name = "DCD_TrangThai")
    private TrangThaiYeuCau trangThai = TrangThaiYeuCau.CHO_DUYET;

    @Enumerated(EnumType.STRING)
    @Column(name = "DCD_TrangThaiGiaoHang")
    private TrangThaiGiaoHang trangThaiGiaoHang = TrangThaiGiaoHang.CHUA_GIAO;

    @Column(name = "DCD_TenNguoiNhan", nullable = false, length = 100)
    private String tenNguoiNhan;

    @Column(name = "DCD_SoDienThoaiNhan", nullable = false, length = 15)
    private String soDienThoaiNhan;

    @Column(name = "DCD_DiaChiNhan", columnDefinition = "TEXT", nullable = false)
    private String diaChiNhan;

    @Column(name = "DCD_NgayTao", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao = new Date();

    @Column(name = "DCD_NgayCapNhat", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayCapNhat = new Date();

    @ManyToOne
    @JoinColumn(name = "DCD_CCCD", referencedColumnName = "DCD_CCCD", insertable = false, updatable = false)
    private DCD_CongDan congDan;
}