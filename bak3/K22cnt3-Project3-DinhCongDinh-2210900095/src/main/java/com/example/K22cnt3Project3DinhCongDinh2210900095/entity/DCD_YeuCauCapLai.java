package com.example.K22cnt3Project3DinhCongDinh2210900095.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "DCD_YeuCauCapLai")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DCD_YeuCauCapLai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DCD_MaYeuCau;

    private String DCD_CCCD;
    @Enumerated(EnumType.STRING)
    private LoaiYeuCau DCD_LoaiYeuCau;
    @Enumerated(EnumType.STRING)
    private TrangThai DCD_TrangThai;
    @Enumerated(EnumType.STRING)
    private TrangThaiGiaoHang DCD_TrangThaiGiaoHang;
    private String DCD_TenNguoiNhan;
    private String DCD_SoDienThoaiNhan;
    private String DCD_DiaChiNhan;
    private Timestamp DCD_NgayTao;
    private Timestamp DCD_NgayCapNhat;
}
