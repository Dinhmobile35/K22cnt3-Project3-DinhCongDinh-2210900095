package com.example.K22cnt3Project3DinhCongDinh2210900095.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "DCD_YeuCauChinhSua")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DCD_YeuCauChinhSua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DCD_MaYeuCau;

    private String DCD_CCCD;
    @Enumerated(EnumType.STRING)
    private TruongCanSua DCD_TruongCanSua;
    private String DCD_GiaTriMoi;
    @Enumerated(EnumType.STRING)
    private TrangThai DCD_TrangThai;
    private Timestamp DCD_NgayTao;
    private Timestamp DCD_NgayCapNhat;
}
