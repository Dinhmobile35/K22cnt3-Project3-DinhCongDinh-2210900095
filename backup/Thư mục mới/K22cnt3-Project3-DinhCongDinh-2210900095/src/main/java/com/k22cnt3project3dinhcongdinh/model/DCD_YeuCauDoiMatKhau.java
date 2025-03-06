package com.k22cnt3project3dinhcongdinh.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import com.k22cnt3project3dinhcongdinh.model.Enums.*;

@Entity
@Table(name = "DCD_YeuCauDoiMatKhau")
@Data
public class DCD_YeuCauDoiMatKhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DCD_MaYeuCau")
    private Integer maYeuCau;

    @Column(name = "DCD_SoDienThoai", nullable = false, length = 15)
    private String soDienThoai;

    @Column(name = "DCD_MatKhauMoi", nullable = false, length = 100)
    private String matKhauMoi;

    @Enumerated(EnumType.STRING)
    @Column(name = "DCD_TrangThai")
    private TrangThaiDoiMatKhau trangThai = TrangThaiDoiMatKhau.CHO_DUYET;

    @Column(name = "DCD_NgayTao", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao = new Date();

    @ManyToOne
    @JoinColumn(name = "DCD_SoDienThoai", referencedColumnName = "DCD_SoDienThoai", insertable = false, updatable = false)
    private DCD_TaiKhoan taiKhoan;
}